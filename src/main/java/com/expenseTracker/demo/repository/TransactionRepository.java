package com.expenseTracker.demo.repository;

import com.expenseTracker.demo.model.Transaction;
import com.expenseTracker.demo.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByCategoryIgnoreCase(String category);

    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Transaction> findByType(TransactionType type);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = 'INCOME'")
    Double getTotalIncome();

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.type = 'EXPENSE'")
    Double getTotalExpense();
}
