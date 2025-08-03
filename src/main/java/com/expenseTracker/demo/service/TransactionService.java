package com.expenseTracker.demo.service;

import com.expenseTracker.demo.dto.SummaryDTO;
import com.expenseTracker.demo.model.Transaction;
import com.expenseTracker.demo.model.TransactionType;
import com.expenseTracker.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction addTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getTransactionsByCategory(String category) {
        return transactionRepository.findByCategoryIgnoreCase(category);
    }

    public List<Transaction> getTransactionsByDateRange(LocalDate startDate, LocalDate endDate) {
        return transactionRepository.findByDateBetween(startDate, endDate);
    }

    public List<Transaction> getTransactionsByType(TransactionType type) {
        return transactionRepository.findByType(type);
    }

    public SummaryDTO getSummary() {
        Double totalIncome = transactionRepository.getTotalIncome();
        Double totalExpense = transactionRepository.getTotalExpense();

        totalIncome = totalIncome == null ? 0.0 : totalIncome;
        totalExpense = totalExpense == null ? 0.0 : totalExpense;

        Double netBalance = totalIncome - totalExpense;
        return new SummaryDTO(totalIncome, totalExpense, netBalance);
    }

    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Optional<Transaction> optionalTransaction = transactionRepository.findById(id);
        if(optionalTransaction.isPresent()){
            Transaction existingTransaction = optionalTransaction.get();
            existingTransaction.setType(updatedTransaction.getType());
            existingTransaction.setCategory(updatedTransaction.getCategory());
            existingTransaction.setAmount((updatedTransaction.getAmount()));
            existingTransaction.setDate(updatedTransaction.getDate());
            return transactionRepository.save(existingTransaction);
        }
        else{
            throw new RuntimeException("Transaction with ID"+ id+ "not found");
        }
    }

    public void deleteTransaction(Long id) {
        if(!transactionRepository.existsById(id)){
            throw new RuntimeException("Transaction with ID "+id+" not found.");
        }

        transactionRepository.deleteById(id);
    }
}
