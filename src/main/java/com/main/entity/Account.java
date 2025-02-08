package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accNo;

    private String accountNumber;
    private Long customerId;
    private String customerName;
    private String accountType;
    private double balance;

    public Account() {}

    public Account(String accountNumber, Long customerId, String customerName, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.customerName = customerName;
        this.accountType = accountType;
        this.balance = balance;
    }

    public Long getAccNo() {
        return accNo;
    }

    public void setAccNo(Long accNo) {
        this.accNo = accNo;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account [accNo=" + accNo + ", accountNumber=" + accountNumber + ", customerId=" + customerId
                + ", customerName=" + customerName + ", accountType=" + accountType + ", balance=" + balance + "]";
    }
}
