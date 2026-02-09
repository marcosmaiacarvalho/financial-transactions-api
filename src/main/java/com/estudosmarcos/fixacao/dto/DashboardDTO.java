package com.estudosmarcos.fixacao.dto;

import java.math.BigDecimal;

public record DashboardDTO(
        BigDecimal revenues,
        BigDecimal expenses,
        BigDecimal balance,
        HighestExpenseCategory highestExpenseCategory) {

    public record HighestExpenseCategory(String name, BigDecimal amount) {
    }

}
