package com.example.backend.service;

import org.springframework.stereotype.Service;

import com.example.backend.dto.TransactionDTO;
import com.example.backend.model.Transaction;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.TransactionRepository;
import com.example.backend.model.Category;
import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;
import java.util.List;


@Service 
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository,
            CategoryRepository categoryRepository,
            UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    public Transaction createTransaction(TransactionDTO dto) {
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Transaction transaction = new Transaction();
        transaction.setAmount(dto.getAmount());
        transaction.setDescription(dto.getDescription());
        transaction.setDate(dto.getDate());
        transaction.setType(dto.getType());
        transaction.setCategory(category);
        transaction.setUser(user);

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public Transaction updateTransaction(Long id, TransactionDTO updatedTransaction) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));

        transaction.setDescription(updatedTransaction.getDescription());
        transaction.setAmount(updatedTransaction.getAmount());
        transaction.setDate(updatedTransaction.getDate());

        Category category = categoryRepository.findById(updatedTransaction.getCategoryId())
            .orElseThrow(() -> new RuntimeException("Category not found"));
        User user = userRepository.findById(updatedTransaction.getUserId())
            .orElseThrow(() -> new RuntimeException("User not found"));

        transaction.setType(updatedTransaction.getType());
        transaction.setCategory(category);
        transaction.setUser(user);

        return transactionRepository.save(transaction);
    }
}
