package com.example.cnExpense.controllers;

import com.example.cnExpense.entities.Expense;
import com.example.cnExpense.entities.Income;
import com.example.cnExpense.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public Income saveExpense(@RequestBody Income income, @RequestBody Expense expense) {
        return expenseService.saveExpense(income, expense);
    }
}
