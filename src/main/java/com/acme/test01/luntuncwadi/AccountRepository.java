package com.acme.test01.luntuncwadi;

import java.math.BigDecimal;

public interface AccountRepository {
    void withdraw(Long accountNum, BigDecimal amountToWithdraw) throws Exception;
}
