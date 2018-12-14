package com.roche.training.craftingcode.bankkata;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static java.util.Collections.reverse;

public class PrintService {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final String HEADER = "DATE | AMOUNT | BALANCE";

    private Console console;

    public PrintService(Console console) {
        this.console = console;
    }

    public void printStatement(List<Transaction> transactions) {
        console.printLine(HEADER);

        double balance = transactions.stream().mapToDouble(Transaction::amount).sum();

        final MutableDouble mutableBalance = new MutableDouble(balance);

        List<Transaction> transactionsInReverseOrder = new ArrayList<>(transactions);
        reverse(transactionsInReverseOrder);

        transactionsInReverseOrder.forEach(transaction -> {
            console.printLine(
                    String.format(Locale.ROOT, "%s | %.2f | %.2f",
                            transaction.date().format(formatter),
                            transaction.amount(),
                            mutableBalance.value()));
            mutableBalance.decrement(transaction.amount());
        });
    }

    private class MutableDouble {
        private double value;

        public MutableDouble(double value) {
            this.value = value;
        }

        public double value() {
            return value;
        }

        public void decrement(double val) {
            this.value -= val;
        }
    }
}
