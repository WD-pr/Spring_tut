package com.aop.dao;

import org.springframework.stereotype.Component;

import com.aop.demo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account, boolean flag) {

		System.out.println(getClass() + " : Adding account");
	}

	public boolean doWork() {

		System.out.println(getClass() + " : Doing some work");

		return false;
	}
}
