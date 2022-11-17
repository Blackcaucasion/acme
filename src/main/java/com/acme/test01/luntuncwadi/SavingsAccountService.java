package com.acme.test01.luntuncwadi;

import java.math.BigDecimal;

public class SavingsAccountService implements AccountService {
    private static SavingsAccountService service = null;
    private static SavingsAccountRepository repository = null;

    private SavingsAccountService(){
        repository = SavingsAccountRepository.getSavingsAccountRepository();
    }

    public static SavingsAccountService getSavingsAccountService(){
        if(service == null){
            service = new SavingsAccountService();
        }
        return service;
    }

    @Override
    public void withdraw(Long accountId, BigDecimal amountToWithdraw) throws Exception {
        repository.withdraw(accountId,amountToWithdraw);
    }
}
