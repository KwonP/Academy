package com.ojt.nexture.www.manager;

import java.util.Scanner;

public class StaffManagerClass implements StaffManager {
	String name;
	int age;
	String password;
	String phoneNum;
	String department;

	@Override
	public boolean fixStaff() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean joinStaff() {
		// TODO Auto-generated method stub
		name = inputString("이름 : ");
		age = inputInt("나이 : ");
		password = inputString("비밀번호 : ");
		phoneNum = inputString("전화번호 : ");
		department = inputString("소속학부 : ");
		return false;
	}

	@Override
	public boolean deleteStaff() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logInStaff() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addClass() {
		// TODO Auto-generated method stub

	}

	public String inputString(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.next();
	}

	public int inputInt(String message) {
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextInt();
	}
}
