package Bank;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;

public class Account {

    int balance;
    int previousTransaction;
    String customerName;
    String customerID;

    public Account(String customerName, String customerID) {
        this.customerName = customerName;
        this.customerID = customerID;
    }

    void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount > 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No previous transaction occurred");
        }
    }

    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = balance + (balance * interestRate * years);
        System.out.println("The current interest rate is: " + interestRate * 100);
        System.out.println("After " + years + " years your balance will be: " + newBalance);
    }


    public void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome " + customerName);
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A: Check your balance");
        System.out.println("B: Make a deposit");
        System.out.println("C: Make a withdraw");
        System.out.println("D: View previous transaction");
        System.out.println("E: Calculate interest");
        System.out.println("F: Exit");

        do {
            System.out.println();
            System.out.print("Enter an option: ");
            option = scanner.nextLine().toUpperCase(Locale.ROOT).charAt(0);
            System.out.println();

            switch (option) {
                case 'A':
                    System.out.println("==============================================");
                    System.out.println("Balance: $" + balance);
                    System.out.println("==============================================");
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = Integer.parseInt(scanner.nextLine());
                    deposit(amount);
                    System.out.println();

                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    amount = Integer.parseInt(scanner.nextLine());
                    withdraw(amount);
                    System.out.println();

                    break;
                case 'D':
                    System.out.println("==============================================");
                    getPreviousTransaction();
                    System.out.println("==============================================");
                    System.out.println();
                    break;
                case 'E':
                    System.out.println("Enter a number of years:");
                    int years = Integer.parseInt(scanner.nextLine());
                    calculateInterest(years);
                    System.out.println();
                    break;
            }

        } while (option != 'F');
        System.out.println("Thank you for using this banking app!");
    }
}
