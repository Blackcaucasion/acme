package com.acme.test01.luntuncwadi;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Set;

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
    public void withdraw(String accountNum, double amountToWithdraws) throws Exception {
        BigDecimal amountToWithdraw =null;
        Account account = SystemDB.getSystemDB().findByAccountNum(accountNum);
        if(account !=null){
            if( account instanceof CurrentAccount){
                BigDecimal maxlimit = BigDecimal.valueOf(account.getBalance()+((CurrentAccount) account).getOverdraft());
                if(amountToWithdraw.compareTo(maxlimit) >0){
                    throw  new Exception("");
                }else {
                    systemDB.remove(account);
                    account.setBalance(account.getBalance() -Double.parseDouble(String.valueOf(amountToWithdraw)));
                    systemDB.add(account);
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

    @Override
    public Set<Account> getAll() {
        return systemDB.getAccounts();
    }
}
