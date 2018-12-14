package com.roche.training.craftingcode.bankkata;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class AccountServiceShould {

    @Test
    public void send_deposit_to_a_transaction_repository() {

        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        PrintService printService = mock(PrintService.class);

        AccountService accountService = new AccountService(transactionRepository, printService);

        accountService.deposit(100);

        verify(transactionRepository).deposit(anyDouble());
    }

    @Test
    public void send_withdraw_to_a_transaction_repository() {

        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        PrintService printService = mock(PrintService.class);

        AccountService accountService = new AccountService(transactionRepository, printService);

        accountService.withdraw(100);

        verify(transactionRepository).withdraw(anyDouble());

    }
}
