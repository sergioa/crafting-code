package com.roche.training.craftingcode.bankkata;

import java.time.LocalDate;
import java.util.Objects;

public class Transaction {
    private final LocalDate date;
    private final double amount;

    public Transaction(final LocalDate date, final double amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate date() {
        return date;
    }

    public double amount() {
        return amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, amount);
    }
}
