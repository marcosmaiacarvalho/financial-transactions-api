package com.estudosmarcos.fixacao.repository;

import com.estudosmarcos.fixacao.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByDateBetween(LocalDate from, LocalDate to);

    List<Transaction> findByDescriptionContainingIgnoreCase(String description);

}
