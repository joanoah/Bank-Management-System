package org.example;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    //attributes
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private String accountType;
    private List<String> transactionHistory;



    public BankAccount (String accountNumber, String accountHolderName, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.transactionHistory = new ArrayList<>();
        recordTransaction("Account created. Initial Balance: Ksh" + balance);
    }

        public String getAccountNumber() {
            return accountNumber;
        }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType(){
        return accountType;
    }

    public List<String> getTransactionHistory (){
        return transactionHistory;
    }


    //a method of depositing funds

    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposit Successful. Current balance: " + balance);
    }
    //a method for withdrawing funds

    public void withdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal of Ksh " + amount + " was successful. Current balance: Ksh " + balance);

        }else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }

    }

    //a method to record transactions


    public void recordTransaction(String description){
        String transaction = LocalDateTime.now() + ": " + description;
        transactionHistory.add(transaction);


    }
}
