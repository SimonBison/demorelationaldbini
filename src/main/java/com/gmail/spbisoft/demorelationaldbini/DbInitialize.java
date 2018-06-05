package com.gmail.spbisoft.demorelationaldbini;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class DbInitialize implements CommandLineRunner {
    private BankAccountRepository bankAccountRepository;

    public DbInitialize(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.bankAccountRepository.deleteAll();

        BankAccount bankAccount1 = new BankAccount("John", 100);
        BankAccount bankAccount2 = new BankAccount("Anna", 300);

        this.bankAccountRepository.save(bankAccount1);
        this.bankAccountRepository.save(bankAccount2);

        System.out.println(" -- Database has been initialized");
    }
}
