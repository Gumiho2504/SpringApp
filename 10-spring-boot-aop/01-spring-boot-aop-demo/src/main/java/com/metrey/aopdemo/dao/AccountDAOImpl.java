package com.metrey.aopdemo.dao;


import com.metrey.aopdemo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOImpl implements AccountDAO{
    @Override
    public void addAccount(Account theAccount,boolean vipFlag) {
        System.out.println(getClass() + ": addAccount()");
        System.out.println("Your Account : "+ theAccount);
    }

    @Override
    public boolean doWork() {
        System.out.println(getClass() + "doWork()");
        return false;
    }
}
