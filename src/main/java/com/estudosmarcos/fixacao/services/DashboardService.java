package com.estudosmarcos.fixacao.services;

import com.estudosmarcos.fixacao.dto.CategoryDTO;
import com.estudosmarcos.fixacao.dto.DashboardDTO;
import com.estudosmarcos.fixacao.dto.TransactionDTO;
import com.estudosmarcos.fixacao.entities.TransactionType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
@Service
public class DashboardService {

    private final TransactionService transactionService;

    public DashboardDTO generate(Integer month, Integer year) {
        List<TransactionDTO> transactions = transactionService.findAll(month, year, null);

        // Otimização: Divide a lista em duas (Despesas vs Receitas) em uma única passagem O(N)
        Map<Boolean, List<TransactionDTO>> transactionsPerType = getTransactionsPerType(transactions);

        List<TransactionDTO> revenues = transactionsPerType.get(false);
        List<TransactionDTO> expenses = transactionsPerType.get(true);

        Map<CategoryDTO, BigDecimal> expensesPerCategory = group(expenses);

        BigDecimal totalRevenue = sum(revenues);
        BigDecimal totalExpense = sum(expenses);
        BigDecimal balance = totalRevenue.subtract(totalExpense);

        Map.Entry<CategoryDTO, BigDecimal> topSpendingCategory = getTopSpendingCategory(expensesPerCategory);

        DashboardDTO.HighestExpenseCategory highestExpenseCategory = null;

        if (topSpendingCategory != null) {
            highestExpenseCategory = new DashboardDTO.HighestExpenseCategory(
                    topSpendingCategory.getKey().name(), topSpendingCategory.getValue());
        }

        return new DashboardDTO(totalRevenue, totalExpense, balance, highestExpenseCategory);

    }

    private Map<Boolean, List<TransactionDTO>> getTransactionsPerType(List<TransactionDTO> transactions) {
        // partitioningBy: Cria um mapa onde a chave 'true' satisfaz a condição (é despesa) e 'false' não satisfaz
        return transactions.stream()
                .collect(partitioningBy(t -> t.type() == TransactionType.EXPENSE));
    }

    private Map<CategoryDTO, BigDecimal> group(List<TransactionDTO> transactions) {
        // groupingBy com reducing: Agrupa pela categoria e reduz os valores somando-os, evitando iterar novamente
        return transactions.stream().collect(groupingBy(TransactionDTO::category,
                mapping(TransactionDTO::amount, reducing(BigDecimal.ZERO, BigDecimal::add))));
    }

    private BigDecimal sum(List<TransactionDTO> transactions) {
        return transactions.stream().map(TransactionDTO::amount).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private Map.Entry<CategoryDTO, BigDecimal> getTopSpendingCategory(Map<CategoryDTO, BigDecimal> expensesPerCategory) {
        return expensesPerCategory.entrySet().stream().max(Map.Entry.<CategoryDTO, BigDecimal>comparingByValue()
                .thenComparing(entry -> entry.getKey().name())).orElse(null);
    }


}
