package com.ojt.nexture.www.manager;

import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.StudentVO;

public class StudentManagerClass implements StudentManager {

	Scanner sc = new Scanner(System.in);
	HumanVO human = new HumanVO();
	boolean flag3;

	@Override
	public boolean joinStudent() {

		System.out.println("情報を入力してください。");
		String name = inputString("名前：");
		String password = inputString("パスワード");
		int age = inputInt("年齢：");
		String phoneNum = inputString("電話番号：");
		String major = inputString("専攻：");
		String student_Num = inputString("学番：");

		System.out.println("======================================");
		System.out.println("名前：" + name + "、年齢：" + age + "、電話：" + phoneNum + "、専攻：" + major + "、学番：" + student_Num);
		System.out.println("======================================");
		System.out.println("このまま会員登録を進めましょうか。(Y/N)");
		String check = sc.next();

		if (check.equals("y") || check.equals("Y")) {
			human = new StudentVO(name, age, password, phoneNum, major, student_Num);
			System.out.println(human);
			System.out.println("会員登録が完了しました。");
			flag3 = true;
			return true;
		} else {
			flag3 = false;
			return false;
		}

	}

	@Override
	public HumanVO loginStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean leadingStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fixStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	// String값 입력
	private String inputString(String msg) {
		System.out.println(msg);
		return sc.next();
	}

	// int값 입력
	private int inputInt(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}

	// 중복체크
	private HumanVO findId(String phoneNum) {
		return null;
	}
	
	public boolean Flag3() {
		return flag3;
	}

	public HumanVO getHuman() {
		return human;
	}

	public void setHuman(HumanVO human) {
		this.human = human;
	}

}
