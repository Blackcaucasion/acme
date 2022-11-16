package com.acme.test01.luntuncwadi;


import javax.security.auth.login.AccountNotFoundException;

public interface AccountService {
  void withdraw(Long accountId, int amountToWithdraw)
            throws AccountNotFoundException;

}