package com.example.backend.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backend.model.Transaction;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Transaction findByDescription(String description);
    List<Transaction> findAllByDateBetween(String startDate, String endDate);
    List<Transaction> findAllByType(String type);
    List<Transaction> findAllByUserId(Long userId);
    List<Transaction> findAllByCategoryId(Long categoryId); 
}