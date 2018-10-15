package com.example.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
	public void addAccount() {
		System.out.println(getClass()+ ": DOING STUFF: ADDING A MEMBERSHIP ACCOUNT");
	}
	public void goSleep() {
		System.out.println(getClass()+"I'm going to sleep...");
	}
}
