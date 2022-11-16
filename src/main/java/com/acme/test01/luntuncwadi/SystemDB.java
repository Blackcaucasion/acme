package com.acme.test01.luntuncwadi;

import java.util.HashSet;
import java.util.Set;

public class SystemDB {
    private  static  SystemDB systemDB = null;
    private Set<Account> accounts;

    public SystemDB(){
        accounts = new HashSet<>();
        // add current accounts and saving accounts
        Account ca1 = new CurrentAccount(12,"1225",1155,255);
        Account ca2 = new CurrentAccount(11,"1225",1155,255);
        Account sa1 = new SavingsAccount(25,"255",2000);
        Account sa2 = new SavingsAccount(22,"255",2000);
        accounts.add(ca1);
        accounts.add(ca2);
        accounts.add(sa1);
        accounts.add(sa2);

    }
    public  static SystemDB getSystemDB(){
        if(systemDB == null){
           systemDB = new SystemDB();

        }
        return systemDB;
    }


    public void addAll(Set<Account> newAccounts){
        accounts.addAll(newAccounts);
    }

    public void add(Account account){
        accounts.add(account);
    }

    public boolean remove(Account account){
        return this.accounts.remove(account);
    }

    /***
     * finds acc by acc no
     * @param accNumbe
     * @return Account
     */
    public  Account findByAccountNum(String accNumbe){
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
