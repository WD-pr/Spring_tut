package com.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addMembershipAccount() {

		System.out.println(getClass().getName() + " : Adding membership account");

		return false;
	}

	public void doWork() {

		System.out.println(getClass().getName() + " : Doing some work");

	}

}
