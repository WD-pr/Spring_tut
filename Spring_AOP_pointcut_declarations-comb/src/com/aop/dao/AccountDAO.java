package com.aop.dao;

import org.springframework.stereotype.Component;

import com.aop.demo.Account;

@Component
public class AccountDAO {

	private String name;
	
	private String serviceCode;
	
	
	public void addAccount(Account account, boolean flag) {

		System.out.println(getClass() + " : Adding account");
	}

	public boolean doWork() {

		System.out.println(getClass() + " : Doing some work");

		return false;
	}

	public String getName() {
		System.out.println(getClass() + " : getting Name");
		return name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " : getting Service Code");
		return serviceCode;
	}

	public void setName(String name) {
		System.out.println(getClass() + " : setting Name");
		this.name = name;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " : setting Service Code");
		this.serviceCode = serviceCode;
	}
	
	
	
}
