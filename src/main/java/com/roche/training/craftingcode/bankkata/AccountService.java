package com.roche.training.craftingcode.bankkata;

public class AccountService {

    private TransactionRepository transactionRepository;

    private PrintService printService;

    public AccountService(TransactionRepository transactionRepository, PrintService printService) {
        this.transactionRepository = transactionRepository;
        this.printService = printService;
    }

    public void deposit(double amount) {
        transactionRepository.deposit(amount);
    }

    public void withdraw(double amount) {
        transactionRepository.withdraw(amount);
    }

    public void printStatement() {
        printService.printStatement(transactionRepository.transactions());
    }
}
