package com.estudosmarcos.fixacao.dto;


import com.estudosmarcos.fixacao.entities.Category;
import jakarta.validation.constraints.NotNull;

public record CategoryDTO(
        @NotNull(message = "ID da categoria não pode estar em branco") Long id,
        String name) {

    public CategoryDTO(Category entity) {
        this(entity.getId(),
                entity.getName()
        );
    }
}
