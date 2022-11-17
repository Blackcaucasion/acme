package com.acme.test01.luntuncwadi;

import java.math.BigDecimal;

public class CurrentAccount extends Account{
    private BigDecimal overdraft;
    public CurrentAccount(Long customerNum, Long accountNum, BigDecimal balance,BigDecimal overdraft) {
        super(customerNum, accountNum, balance);
        this.overdraft =overdraft;
    }

    public BigDecimal getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(BigDecimal overdraft) {
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
