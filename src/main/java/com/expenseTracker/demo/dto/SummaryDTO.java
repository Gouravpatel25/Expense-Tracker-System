package com.expenseTracker.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SummaryDTO {
    private Double totalIncome;
    private Double totalExpense;
    private Double netBalance;
}
