package com.acme.test01.luntuncwadi;

public class SavingsAccount extends  Account{

    public SavingsAccount(int customerNum, String accountNum, double balance) {
        super(customerNum, accountNum, balance);
    }

    @Override
    public String toString() {
        return "SavingsAccount{" +
                "customerNum=" + customerNum +
                ", accountNum='" + accountNum + '\'' +
                ", balance=" + balance +
                '}';
    }
}
