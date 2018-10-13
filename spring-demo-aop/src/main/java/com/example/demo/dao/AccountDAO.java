package com.example.demo.dao;

import org.springframework.stereotype.Component;

import com.example.demo.Account;

@Component
public class AccountDAO {
	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AND ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+"doWork()");
		return false;
	}
}

