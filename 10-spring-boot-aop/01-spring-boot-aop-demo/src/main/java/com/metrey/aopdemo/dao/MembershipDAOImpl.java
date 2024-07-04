package com.metrey.aopdemo.dao;


import org.springframework.stereotype.Repository;

@Repository
public class MembershipDAOImpl implements MembershipDAO{
    @Override
    public boolean addSilyMember() {
        System.out.println(getClass() + ": addSilyMember()");
        return false;
    }

    @Override
    public void goToSleep() {
        System.out.println(getClass() + "goToSleep()");
    }
}
