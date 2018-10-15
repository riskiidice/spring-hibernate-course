package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	public List<Account> findAccount(boolean tripWire){
		
		// for academic purpose .. simulate an exception
		if(tripWire) {
			throw new RuntimeException("No soup for you!!");
		}
		
		List<Account> myAccounts = new ArrayList<>();
		
		Account temp1  = new Account("John", "Silver");
		Account temp2  = new Account("Amp", "Platium");
		Account temp3  = new Account("Tikumporn", "Gold");
		
		myAccounts.add(temp1);
		myAccounts.add(temp2);
		myAccounts.add(temp3);

		return myAccounts;
	}
	
	
	public String getName() {
		System.out.println(getClass()+": in getName()");
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(getClass()+": in setName()");
	}

	public String getServiceCode() {
		System.out.println(getClass()+": in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
		System.out.println(getClass()+": in setServiceCode()");
	}

	public void addAccount(Account theAccount, boolean vipFlag) {
		System.out.println(getClass()+ ": DOING MY DB WORK: ADDING AND ACCOUNT");
	}
	
	public boolean doWork() {
		System.out.println(getClass()+"doWork()");
		return false;
	}
}

