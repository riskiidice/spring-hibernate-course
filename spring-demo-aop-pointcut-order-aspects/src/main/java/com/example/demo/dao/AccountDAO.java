package com.example.demo.dao;

import org.springframework.stereotype.Component;

import com.example.demo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
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

