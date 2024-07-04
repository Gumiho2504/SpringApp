package com.metrey.aopdemo.dao;

import com.metrey.aopdemo.Account;

public interface AccountDAO {

    void addAccount(Account theAccount,boolean vipFlag);

    boolean doWork();

}
