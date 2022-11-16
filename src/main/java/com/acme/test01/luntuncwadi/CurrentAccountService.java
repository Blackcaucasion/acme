package com.acme.test01.luntuncwadi;

import javax.security.auth.login.AccountNotFoundException;

public class CurrentAccountService implements AccountService{

    private static CurrentAccountService service = null;
    private static CurrentAccountRepository repository = null;

    private CurrentAccountService(){
        repository = CurrentAccountRepository.getCurrentAccountRepository();
    }

    public static CurrentAccountService getCurrentAccountService(){
        if(service == null){
            service = new CurrentAccountService();
        }
        return service;
    }
    @Override
    public void withdraw(Long accountId, int amountToWithdraw) throws AccountNotFoundException {

    }
}
