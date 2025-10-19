package com.example.backend.service;

import org.springframework.stereotype.Service;
import com.example.backend.model.Transaction;
import com.example.backend.repository.TransactionRepository;
import java.util.List;


@Service 
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
    public Transaction updateTransaction(Long id, Transaction updatedTransaction) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transaction.setDescription(updatedTransaction.getDescription());
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setDate(updatedTransaction.getDate());
        transaction.setType(updatedTransaction.getType());
        transaction.setCategory(updatedTransaction.getCategory());
        transaction.setUser(updatedTransaction.getUser());

        return transactionRepository.save(transaction);
    }
}
