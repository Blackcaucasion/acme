package com.acme.test01.luntuncwadi;

public class CurrentAccount extends Account{
    private double overdraft;
    public CurrentAccount(int customerNum, String accountNum, double balance,double overdraft) {
        super(customerNum, accountNum, balance);
        this.overdraft =overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public String toString() {
        return "CurrentAccount{" +
                "customerNum=" + customerNum +
                ", accountNum='" + accountNum + '\'' +
                ", balance=" + balance +
                ", overdraft=" + overdraft +
                '}';
    }
}
