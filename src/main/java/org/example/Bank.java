package org.example;

import java.util.HashMap;
import java.util.Map;
public class Bank {
    //attributes
    private Map<String, BankAccount>accounts;

    //constructors
    public Bank (){
        accounts = new HashMap<>();
    }

    //a method to add an account
    public void addAccount(String accountNumber, String accountHolderName, double balance, String accountType){

        BankAccount account = new BankAccount(accountNumber, accountHolderName, balance, accountType);

        accounts.put(accountNumber, account);
        System.out.println("Account Created Successfully.");

    }
    //a method to get an account
    public BankAccount getAccount(String accountNumber){
        return accounts.get(accountNumber);
    }
}
