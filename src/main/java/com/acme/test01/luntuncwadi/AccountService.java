package com.acme.test01.luntuncwadi;


import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public interface AccountService {
  void withdraw(Long accountId, BigDecimal amountToWithdraw)
          throws Exception;

}