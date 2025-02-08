package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.entity.Account;
import com.main.repository.AccountRepository;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Long customerId, String customerName, String accountType, double balance) {
        Account account = new Account();
        account.setCustomerId(customerId);
        account.setCustomerName(customerName);
        account.setAccountType(accountType);
        account.setBalance(balance);
        account.setAccountNumber(generateAccountNumber());  
        
        return accountRepository.save(account);
    }

    private String generateAccountNumber() {
        return "AC" + (long)(Math.random() * 10000000000L);
    }

   
    public Account deposit(Long customerId, double amount) {
        Optional<Account> optionalAccount = accountRepository.findById(customerId);

        if (optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance() + amount);
            return accountRepository.save(account);
        } else {
            throw new RuntimeException("Account not found for ID: " + customerId);
        }
    }
}
