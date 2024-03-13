package org.example;

import java.util.HashMap;
import java.util.Map;
public class Bank {
    //attributes
    private Map<String, BankAccount>accounts;
    private String loggedInUser;

    //constructors
    public Bank (){
        accounts = new HashMap<>();
        loggedInUser = null;
    }
    //a method to log in the user

    public boolean login(String username, String password){
        //simulate a simple log in authentication
        if ("joanoah".equals(username) && "joanoahhh".equals(password)){
            loggedInUser = username;
            return true;
        }else{
            return false;
        }
    }

    //a method to log out the user
    public void logout(){
        loggedInUser = null;
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
