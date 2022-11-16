package com.acme.test01.luntuncwadi;

public abstract class Account {
    int customerNum;
    String accountNum;
    double balance;

    public Account(int customerNum, String accountNum, double balance) {
        this.customerNum = customerNum;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public int getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(int customerNum) {
        this.customerNum = customerNum;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
