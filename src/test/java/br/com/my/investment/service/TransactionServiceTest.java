package br.com.my.investment.service;

import br.com.my.investment.model.Operation;
import br.com.my.investment.model.Transaction;
import br.com.my.investment.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

    @InjectMocks
    private TransactionService service;

    @Mock
    private TransactionRepository repository;

    @Test
    void findAllWithTwoTransactions(){
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(Transaction.builder().amount(500)
                .category("AÇÃO").companyCode("ITSA4")
                .date(LocalDate.of(2017, 06, 30))
                .operation(Operation.BUY)
                .tax(10)
                .price(8.97)
                .totalValue(4495)
                .build());

        transactions.add(Transaction.builder().amount(500)
                .category("AÇÃO").companyCode("ITSA4")
                .date(LocalDate.of(2017, 07, 17))
                .operation(Operation.BUY)
                .tax(10)
                .price(9.12)
                .totalValue(4570)
                .build());
        given(repository.findAll()).willReturn(transactions);

        List<Transaction> transactionList = service.findAll();

        assertThat(transactionList).hasSize(2);
        then(repository).should().findAll();
    }

    @Test
    void findAllEmpty() {
        List<Transaction> transactions = new ArrayList<>();
        given(repository.findAll()).willReturn(transactions);
        List<Transaction> transactionList = service.findAll();
        assertThat(transactionList).isEmpty();
        then(repository).should().findAll();

    }
}
