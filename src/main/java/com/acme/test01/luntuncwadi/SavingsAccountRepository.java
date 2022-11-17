package com.acme.test01.luntuncwadi;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public class SavingsAccountRepository implements  AccountRepository{

    private static SavingsAccountRepository repository = null;
    private SystemDB systemDB;

    private SavingsAccountRepository(){
        systemDB = SystemDB.getSystemDB();
    }

    public static SavingsAccountRepository getSavingsAccountRepository(){
        if(repository == null){
            repository = new SavingsAccountRepository();
        }
        return repository;
    }
    @Override
    public void withdraw(Long accountNum, BigDecimal amountToWithdraw) throws Exception {
        Account account = SystemDB.getSystemDB().findByAccountNum(accountNum);
        if(account !=null){
            if( account instanceof SavingsAccount){
                System.out.println("account B "+ account.getBalance());
                BigDecimal minlimit = account.getBalance().subtract(amountToWithdraw);
                if(minlimit.compareTo(BigDecimal.valueOf(1000))<0){
                    throw  new Exception("amount too much");
                }else {
                    account.setBalance(account.getBalance().subtract(amountToWithdraw));
                    System.out.println("New Balance = "+ account.getBalance());
                    System.out.println("Success");
                    ;
                }

            }else {
                throw  new AccountNotFoundException("");
            }
        }
        else{
            throw new AccountNotFoundException("");
        }
    }

}
