package com.expenseTracker.demo.controller;

import com.expenseTracker.demo.dto.SummaryDTO;
import com.expenseTracker.demo.model.Transaction;
import com.expenseTracker.demo.model.TransactionType;
import com.expenseTracker.demo.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/add")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/all")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/category/{category}")
    public List<Transaction> getByCategory(@PathVariable String category) {
        return transactionService.getTransactionsByCategory(category);
    }

    @GetMapping("/date/{start}/{end}")
    public List<Transaction> getByDateRange(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate start,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate end
    ) {
        return transactionService.getTransactionsByDateRange(start, end);
    }

    @GetMapping("/type/{type}")
    public List<Transaction> getByType(@PathVariable TransactionType type) {
        return transactionService.getTransactionsByType(type);
    }

    @PutMapping("/update/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody Transaction updatedTransaction){
        return transactionService.updateTransaction(id,updatedTransaction);
    }

    @DeleteMapping("/remove/{id}")
    public String deleteTransaction(@PathVariable Long id){
        transactionService.deleteTransaction(id);
        return "Transaction with ID "+id+" has been deleted. ";
    }
    @GetMapping("/summary")
    public SummaryDTO getSummary() {
        return transactionService.getSummary();
    }


}
