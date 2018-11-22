package com.ojt.nexture.www.manager;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.StaffVO;
import com.ojt.nexture.www.ui.AcademyUI;

public class StaffManagerClass implements StaffManager {
	HumanVO human = new HumanVO();
	Scanner sc = new Scanner(System.in);
	String name;
	int age = 0;
	String password;
	String phoneNum;
	String department;
	boolean flag3;

	@Override
	public boolean fixStaff() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean joinStaff() {
		// TODO Auto-generated method stub

		System.out.println("情報を入力してください。");

		name = inputString("名前 : ");
		do {
			age = inputInt("年齢 : ");
		} while (age == 0 );
		password = inputString("パスワード : ");
		phoneNum = inputString("電話番号 : ");
		department = inputString("所属学部 : ");
		System.out.println("----------------------------------------------------------");
		System.out.println("名前 : " + name + ",   年齢 : " + age + ",   電話番号 : " + phoneNum + ",   所属学部 :" + department);
		System.out.println("----------------------------------------------------------");
		System.out.println("このまま会員登録を進めましょうか。 (Y/N)");
		String check = null;
		check = sc.next();

		if (check.equals("y") || check.equals("Y")) {
			human = new StaffVO(name, age, password, phoneNum, department);
			System.out.println("会員登録が完了しました。");
			flag3 = true;
			return true;
		} else {
			System.out.println("다시 입력해주십시오.");
			flag3 = false;
			return false;
		}
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
		System.out.println(message);
		String inputString = null;
		inputString = sc.next();
		return inputString;
	}

	public int inputInt(String message) {
		System.out.println(message);
		int inputInt = 0;
		try {
			inputInt = sc.nextInt();
		} catch (InputMismatchException e) {
			sc = new Scanner(System.in);
			System.out.println("잘못입력하셨습니다.");
		}
		return inputInt;
	}

	public HumanVO getHuman() {
		return human;
	}

	public boolean isFlag3() {
		return flag3;
	}
	
	
}
