package com.acme.test01.luntuncwadi;

import jdk.jshell.execution.Util;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;


public class MainApplication {
    private static SystemDB systemDB;
    private static Scanner scanner;
    private static SavingsAccountService savingsAccountService;
    private static CurrentAccountService currentAccountService;

    public static void main(String[] args) throws Exception {
        systemDB = SystemDB.getSystemDB();
        systemDB.getAccounts();
        savingsAccountService = SavingsAccountService.getSavingsAccountService();
        currentAccountService = CurrentAccountService.getCurrentAccountService();
        scanner = new Scanner(System.in);
        withdraw();
    }

    private static void withdraw() throws  Exception {

        System.out.println("Select account .\n\t1. Savings Account.\n\t2. Current Account.");
        int acountType = scanner.nextInt();
        System.out.println("Enter Account Number");
        Long accountNumber = scanner.nextLong();
        System.out.println("Enter amount");
        BigDecimal amount = scanner.nextBigDecimal();
        if(accountNumber !=null && amount!=null){
            switch (acountType){
                case 1:
                    savingsAccountService.withdraw(accountNumber, amount);
                    break;
                case 2:
                    currentAccountService.withdraw(accountNumber, amount);
                    break;
                default:
                    System.out.println("Invalid Account type...try again");
            }

        }
        else {
            System.out.println(" Try again");
        }
    }

}
