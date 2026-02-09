package com.estudosmarcos.fixacao.services;

import com.estudosmarcos.fixacao.dto.TransactionDTO;
import com.estudosmarcos.fixacao.entities.Category;
import com.estudosmarcos.fixacao.entities.Transaction;
import com.estudosmarcos.fixacao.repository.CategoryRepository;
import com.estudosmarcos.fixacao.repository.TransactionRepository;
import com.estudosmarcos.fixacao.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<TransactionDTO> findAll(Integer month, Integer year, String description) {

        if (month != null && year != null) {
            LocalDate from = LocalDate.of(year, month, 1);
            LocalDate to = from.withDayOfMonth(from.lengthOfMonth());
            return convertToDto(transactionRepository.findByDateBetween(from, to));
        }

        if (description != null) {
            return convertToDto(transactionRepository.findByDescriptionContainingIgnoreCase(description));
        }

        return convertToDto(transactionRepository.findAll());
    }

    @Transactional(readOnly = true)
    public TransactionDTO findById(Long id) {
        Transaction entity = transactionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Transação não encontrada."));

        return new TransactionDTO(entity);
    }

    @Transactional
    public TransactionDTO create(TransactionDTO dto) {

            Transaction entity = new Transaction();
            // Fail Fast: Valida existência com baixo custo (SELECT 1) para garantir integridade antes de processar.
            if (!categoryRepository.existsById(dto.category().id())) {
                throw new ResourceNotFoundException("Categoria não existe.");
            }
            dtoToEntity(dto, entity);

            return new TransactionDTO(transactionRepository.save(entity));


    }

    @Transactional
    public void delete(Long id) {
        if (!transactionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Transação não encontrada.");
        }
        transactionRepository.deleteById(id);
    }


    private List<TransactionDTO> convertToDto(List<Transaction> list) {
        return list.stream().map(TransactionDTO::new).toList();
    }

    private void dtoToEntity(TransactionDTO dto, Transaction entity) {
        entity.setDescription(dto.description());
        entity.setAmount(dto.amount());
        entity.setDate(dto.date());
        entity.setType(dto.type());
        // Performance: Cria apenas o Proxy (sem novo SELECT) para vincular a categoria já validada.
        Category c = categoryRepository.getReferenceById(dto.category().id());
        entity.setCategory(c);
    }


}
