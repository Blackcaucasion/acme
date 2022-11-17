package com.acme.test01.luntuncwadi;

import java.math.BigDecimal;

public class SavingsAccount extends  Account{

    public SavingsAccount(Long customerNum, Long accountNum, BigDecimal balance) {
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
