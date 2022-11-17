package com.acme.test01.luntuncwadi;

import java.math.BigDecimal;

public abstract class Account {
    Long customerNum;
    Long accountNum;
    BigDecimal balance;

    public Account(Long customerNum, Long accountNum, BigDecimal balance) {
        this.customerNum = customerNum;
        this.accountNum = accountNum;
        this.balance = balance;
    }

    public Long getCustomerNum() {
        return customerNum;
    }

    public void setCustomerNum(Long customerNum) {
        this.customerNum = customerNum;
    }

    public Long getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(Long accountNum) {
        this.accountNum = accountNum;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
