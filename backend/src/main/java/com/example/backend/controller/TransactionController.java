package com.example.backend.controller;

import com.example.backend.service.TransactionService;

import jakarta.validation.Valid;

import com.example.backend.dto.TransactionDTO;
import com.example.backend.model.Transaction;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/transactions")

public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }
    @PostMapping
    public Transaction createTransaction(@RequestBody @Valid TransactionDTO dto) {
        return transactionService.createTransaction(dto);
    }
    @GetMapping("/{id}")
    public Transaction getTransactionById(@PathVariable Long id) {
        return transactionService.getTransactionById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionService.deleteTransaction(id);
    }
    @PutMapping("/{id}")
    public Transaction updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO transaction) {
        return transactionService.updateTransaction(id, transaction);
    }
}
