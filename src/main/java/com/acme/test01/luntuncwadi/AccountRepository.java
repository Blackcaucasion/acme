package com.acme.test01.luntuncwadi;

import java.util.Set;

public interface AccountRepository {
    void withdraw(String accountNum, double amountToWithdraw) throws Exception;
    Set<Account> getAll();
}
