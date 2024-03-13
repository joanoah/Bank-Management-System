package org.example;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //create the scanner object
        Scanner scanner = new Scanner(System.in);

        //create a bank object
        Bank CPLBank = new Bank();

        //login logic loop
        boolean isLoggedIn = false;

        do{
            System.out.print("Enter Username: ");
            String username = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            isLoggedIn = CPLBank.login(username, password);

            if (!isLoggedIn){
                System.out.println("Invalid Username or Password. Please try again!!!");

            }
        }while(!isLoggedIn);

        //a variable to save the user choice from the menu
        int userChoice;
        System.out.println("======================================================");

        System.out.println("\t\t\t\t Welcome to CPLBank!!!");

        System.out.println("=======================================================");

        do{
            System.out.println("\n1. Add Account");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Log Out");
            System.out.println("Enter your choice: ");


            userChoice = scanner.nextInt();
            scanner.nextLine(); //consumes the newLine character

            switch (userChoice){
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accountNumber = scanner.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String accountHolderName = scanner.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine(); //consumes new line character

                    System.out.print("Enter The Account Type (e.g Savings, Checking): ");
                    String accountType = scanner.nextLine();


                    CPLBank.addAccount(accountNumber, accountHolderName, balance, accountType);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();

                    BankAccount account = CPLBank.getAccount(accountNumber);

                    if (account != null){
                        System.out.print("Enter the amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    }else{
                        System.out.print("Account not found!!!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    accountNumber = scanner.nextLine();
                    account = CPLBank.getAccount(accountNumber);

                    if (account != null){
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    }else{
                        System.out.println("Account Not Found!!!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Sender Account Number: ");
                    String senderAccountNumber = scanner.nextLine();

                    System.out.print("Enter Recipient Account Number: ");
                    String recipientAccountNumber = scanner.nextLine();

                    BankAccount senderAccount = CPLBank.getAccount(senderAccountNumber);
                    BankAccount recipientAccount = CPLBank.getAccount(recipientAccountNumber);

                    if (senderAccount != null && recipientAccount != null){
                        System.out.println("Enter Transfer Amount: ");
                        double transferAmount = scanner.nextDouble();
                        senderAccount.transferFunds(recipientAccount, transferAmount);
                    }else {
                        System.out.println("Sender or Recipient Account Not Found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter the Account Number: ");
                    accountNumber = scanner.nextLine();
                    account = CPLBank.getAccount(accountNumber);

                    if (account != null){
                        System.out.println("Transaction History For Account: " + accountNumber);
                        List<String> transactions = account.getTransactionHistory();

                        for (String transaction : transactions){
                            System.out.println(transaction);
                        }

                    }else {
                        System.out.println("Account Not Found!!!");
                    }
                    break;

                case 6:
                    CPLBank.logout();
                    System.out.println("Logged Out Successfully.");
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter choice between 1 and 5.");

            }
        }while(userChoice != 6);

        //close the scanner object
        scanner.close();

    }
}