package com.ojt.nexture.www.manager;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.StaffVO;
import com.ojt.nexture.www.ui.AcademyUI;

public class StaffManagerClass implements StaffManager {
	HumanVO human = new HumanVO();
	Scanner sc = new Scanner(System.in);

	@Override
	public boolean fixStaff() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean joinStaff() {
		// TODO Auto-generated method stub

		String name = inputString("이름 : ");
		int age = inputInt("나이 : ");
		String password = inputString("비밀번호 : ");
		String phoneNum = inputString("전화번호 : ");
		String department = inputString("소속학부 : ");

		System.out.println("======================================");
		System.out.println("이름 : " + name + ",   나이 : " + age + ",   전화번호 : " + phoneNum + ",   소속학부 :" + department);
		System.out.println("======================================");
		System.out.println("이대로의 정보가 맞습니까? (Y/N)");
		String check = sc.next();

		if (check.equals("y")) {
			human = new StaffVO(name, age, password, phoneNum, department);
			return true;
		} else {
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
		return sc.next();
	}

	public int inputInt(String message) {
		System.out.println(message);
		int inputInt = 0;
		try {
			inputInt = sc.nextInt();
		} catch (InputMismatchException e) {
			missMatchExCler();
		}
		return sc.nextInt();
	}

	public HumanVO getHuman() {
		return human;
	}

	public void missMatchExCler() {
		sc.nextLine();
		System.out.println("メニュー選択は数字を入力してください。");
	}
}
