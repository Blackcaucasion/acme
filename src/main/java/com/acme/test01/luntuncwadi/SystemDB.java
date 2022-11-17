package com.acme.test01.luntuncwadi;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class SystemDB {
    private  static  SystemDB systemDB = null;
    private Set<Account> accounts;

    public SystemDB(){
        accounts = new HashSet<>();
        // add current accounts and saving accounts
        // add util class to check minimum requiremtns when creating account
        Account ca1 = new CurrentAccount(12L,1225L, BigDecimal.valueOf(2000), BigDecimal.valueOf(155));
        Account ca2 = new CurrentAccount(11L,1224L, BigDecimal.valueOf(2555), BigDecimal.valueOf(255));
        Account sa1 = new SavingsAccount(2512L,255L,BigDecimal.valueOf(3000));
        Account sa2 = new SavingsAccount(22L,155L,BigDecimal.valueOf(2000));
        accounts.add(ca1);
        accounts.add(ca2);
        accounts.add(sa1);
        accounts.add(sa2);
        System.out.println("Set  accounts: " + accounts);

    }
    public  static SystemDB getSystemDB(){
        if(systemDB == null){
           systemDB = new SystemDB();

        }
        return systemDB;
    }

    /***
     * finds acc by acc no
     * @param accNumbe
     * @return Account
     */
    public  Account findByAccountNum(Long accNumbe){
        return  accounts.stream().filter(account->account.getAccountNum().equals(accNumbe)).findAny().orElse(null);
    }

    /***
     *
     * @return set of all Accounts
     */
    public Set<Account> getAccounts(){


        return this.getSystemDB().accounts;
    }
}
