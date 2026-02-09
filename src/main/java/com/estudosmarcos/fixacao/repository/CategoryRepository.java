package com.estudosmarcos.fixacao.repository;

import com.estudosmarcos.fixacao.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
