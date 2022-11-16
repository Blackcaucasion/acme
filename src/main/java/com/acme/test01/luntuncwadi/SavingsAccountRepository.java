package com.acme.test01.luntuncwadi;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.Set;

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
    public void withdraw(String accountNum, double amountToWithdraws) throws Exception {
        BigDecimal amountToWithdraw =null;
        Account account = SystemDB.getSystemDB().findByAccountNum(accountNum);
        if(account !=null){
            if( account instanceof CurrentAccount){
                BigDecimal minlimit = BigDecimal.valueOf(account.getBalance() -Double.parseDouble(String.valueOf(amountToWithdraw)));
                if(minlimit.compareTo(BigDecimal.valueOf(1000))<0){
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
