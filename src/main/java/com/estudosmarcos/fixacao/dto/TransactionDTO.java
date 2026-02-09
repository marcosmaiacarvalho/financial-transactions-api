package com.estudosmarcos.fixacao.dto;

import com.estudosmarcos.fixacao.entities.Transaction;
import com.estudosmarcos.fixacao.entities.TransactionType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionDTO(

        Long id,

        @NotBlank(message = "Descrição não pode estar em branco.")
        @Size(message = "A descrição deve ter no mínimo 5 caracteres", min = 5)
        String description,

        @NotNull(message = "Obrigatório informar um valor.")
        @Positive(message = "Valor deve ser MAIOR que 0.0")
        BigDecimal amount,

        @NotNull(message = "Obrigatório informar uma data.")
        LocalDate date,

        @NotNull(message = "Obrigatório informar um tipo.")
        TransactionType type,

        @Valid
        @NotNull(message = "Obrigatório informar uma categoria.")
        CategoryDTO category
) {

    public TransactionDTO(Transaction entity) {
        this(entity.getId(),
                entity.getDescription(),
                entity.getAmount(),
                entity.getDate(),
                entity.getType(),
                new CategoryDTO(entity.getCategory())
        );
    }

}
