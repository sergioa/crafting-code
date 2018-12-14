package com.roche.training.craftingcode.bankkata;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {
    private List<Transaction> transactions = new ArrayList<>();

    private Clock clock;

    public TransactionRepository(Clock clock) {
        this.clock = clock;
    }

    public void deposit(double amount) {
        transactions.add(new Transaction(clock.now(), amount));
    }

    public void withdraw(double amount) {
        transactions.add(new Transaction(clock.now(), -amount));
    }

    public List<Transaction> transactions() {
        return transactions;
    }

}
