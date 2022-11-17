package com.acme.test01.luntuncwadi;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;

public class CurrentAccountRepository implements AccountRepository{
    private  static CurrentAccountRepository repository =null;
    private  SystemDB systemDB;
    private CurrentAccountRepository(){
        systemDB = SystemDB.getSystemDB();
    }
    public  static CurrentAccountRepository getCurrentAccountRepository(){
        if(repository ==null){
            repository = new CurrentAccountRepository();
        }
        return  repository;
    }
    @Override
    public void withdraw(Long accountNum, BigDecimal amountToWithdraw) throws Exception {
        Account account = SystemDB.getSystemDB().findByAccountNum(accountNum);
        if(account !=null){
            if( account instanceof CurrentAccount){
                BigDecimal maxlimit = account.getBalance().add(((CurrentAccount) account).getOverdraft());
                if(amountToWithdraw.compareTo(maxlimit) >0){
                    throw  new Exception("wrong amount ");
                }else {
                    account.setBalance(account.getBalance().subtract(amountToWithdraw));
                    System.out.println("New Balance = "+ account.getBalance());
                    System.out.println("Success");
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
