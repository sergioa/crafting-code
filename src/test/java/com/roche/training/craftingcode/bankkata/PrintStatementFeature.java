package com.roche.training.craftingcode.bankkata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Mock
    Console console;

    @Mock
    Clock clock;

    @Test
    public void print_statement_containing_transactions_in_reverse_chronological_order() {

        TransactionRepository transactionRepository = new TransactionRepository(clock);
        when(clock.now())
                .thenReturn(
                        LocalDate.parse("01/04/2014", formatter),
                        LocalDate.parse("02/04/2014", formatter),
                        LocalDate.parse("10/04/2014", formatter)
                );

        AccountService accountService = new AccountService(transactionRepository, new PrintService(console));
        accountService.deposit(1000);
        accountService.withdraw(100);
        accountService.deposit(500);
        accountService.printStatement();


        InOrder inOrder = inOrder(console);
        inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
        inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
        inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
        inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
    }
}
