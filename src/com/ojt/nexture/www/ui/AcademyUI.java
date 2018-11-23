package com.ojt.nexture.www.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.entity.ProfessorVO;
import com.ojt.nexture.www.entity.StaffVO;
import com.ojt.nexture.www.entity.StudentVO;
import com.ojt.nexture.www.manager.ProfessorManagerClass;
import com.ojt.nexture.www.manager.StaffManagerClass;
import com.ojt.nexture.www.manager.StudentManagerClass;

public class AcademyUI {

	Scanner sc = new Scanner(System.in);
	List<HumanVO> userList = new ArrayList<>();
	List<LectureVO> lecList = new ArrayList<>();

	HumanVO human = null;
	ProfessorManagerClass professor = new ProfessorManagerClass();
	StudentManagerClass student = new StudentManagerClass();
	StaffManagerClass staff = new StaffManagerClass();

	String name;
	int age = 0;
	String password;
	String phoneNum;
	String department;
	String major;
	String student_Num;

	public AcademyUI() {
		boolean flag = true;
		// メインメニュー表示するためのループ文
		while (flag) {
			menu();

			int choice = 0;
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				missMatchExCler();
			}

			switch (choice) {
			case 1:
				System.out.println("会員登録へ移動");

				boolean flag2 = true;
				while (flag2) {
					typeSelMenu();
					System.out.println("タイプを入力ください");
					int choice2 = 0;
					try {
						choice2 = sc.nextInt();
					} catch (Exception e) {
						missMatchExCler();
					}
					switch (choice2) {
					case 1:
						// Professor登録
						System.out.println("情報を入力してください。");

						name = inputString("名前 : ");
						do {
							age = inputInt("年齢 : ");
						} while (age == 0);
						// age 값이 scan 받을 때 nextInt를 사용하는데, 이때 문자, 혹은 0을 입력할 시 제대로 입력 받을 때 까지 반복하도록 하는 문
						password = inputString("パスワード : ");
						phoneNum = inputString("電話番号 : ");
						department = inputString("所属学部 : ");
						System.out.println("----------------------------------------------------------");
						System.out.println("名前 : " + name + ",   年齢 : " + age + ",   電話番号 : " + phoneNum + ",   所属学部 :"
								+ department);
						System.out.println("----------------------------------------------------------");
						System.out.println("このまま会員登録を進めましょうか。 (Y/N)");
						String check = null;

						check = sc.next();
						if (check.equals("y") || check.equals("Y")) {
							human = new ProfessorVO(name, age, password, phoneNum, department);
							professor.joinProfessor(userList, human);

						} else {
							System.out.println("また入力してください。");
						}
						break;

					case 2:
						// Student登録

						System.out.println("情報を入力してください。");

						name = inputString("名前：");
						password = inputString("パスワード");
						do {
							age = inputInt("年齢 : ");
						} while (age == 0);
						phoneNum = inputString("電話番号：");
						major = inputString("専攻：");
						student_Num = inputString("学番：");

						System.out.println("======================================");
						System.out.println("名前：" + name + "、年齢：" + age + "、電話：" + phoneNum + "、専攻：" + major + "、学番："
								+ student_Num);
						System.out.println("======================================");
						System.out.println("このまま会員登録を進めましょうか。(Y/N)");

						check = null;

						check = sc.next();
						if (check.equals("y") || check.equals("Y")) {
							human = new StudentVO(name, age, password, phoneNum, major, student_Num);
							System.out.println(human);
							System.out.println("会員登録が完了しました。");
							student.joinStudent(userList, human);
							flag2 = false;
						} else {
							System.out.println("また入力してください。");
						}
						break;

					case 3:
						// Staff登録

						System.out.println("情報を入力してください。");

						name = inputString("名前 : ");
						do {
							age = inputInt("年齢 : ");
						} while (age == 0);
						// age 값이 scan 받을 때 nextInt를 사용하는데, 이때 문자, 혹은 0을 입력할 시 제대로 입력 받을 때 까지 반복하도록 하는 문
						password = inputString("パスワード : ");
						phoneNum = inputString("電話番号 : ");
						department = inputString("所属学部 : ");
						System.out.println("----------------------------------------------------------");
						System.out.println("名前 : " + name + ",   年齢 : " + age + ",   電話番号 : " + phoneNum + ",   所属学部 :"
								+ department);
						System.out.println("----------------------------------------------------------");
						System.out.println("このまま会員登録を進めましょうか。 (Y/N)");
						check = null;

						check = sc.next();
						if (check.equals("y") || check.equals("Y")) {
							human = new StaffVO(name, age, password, phoneNum, department);
							staff.joinStaff(userList, human);
							if (staff.getCheckNum() == 0) {
								flag2 = false;
							}
						} else {
							System.out.println("また入力してください。");
						}

						break;

					case 4:
						flag2 = false;
						break;

					default:
						System.out.println("正しくない命令です。");
						break;
					}

				}

				break;
			case 2:

				System.out.println("ログイン画面へ移行");

				break;
			case 3:

				break;
			default:
				System.out.println("正しいメニューを選択してください。");
				break;
			}

		}

	}

	public void menu() {
		System.out.println("===========アカデミー管理システム=========== \n");
		System.out.println("\t1．会員登録　　　2．ログイン \n");
		System.out.println("======================================");
	}

	public void typeSelMenu() {
		System.out.println("==============会員タイプ選択============= \n１．教授　２．学生　３．スタッフ　４．取り消し"
				+ "\n======================================");
	}

	public void missMatchExCler() {
		sc.nextLine();
		System.out.println("メニュー選択は数字を入力してください。");
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
			System.out.println("誤入力しました。");
		}
		return inputInt;
	}

	public List<HumanVO> getUserList() {
		return userList;
	}

	public void setUserList(List<HumanVO> userList) {
		this.userList = userList;
	}

	public List<LectureVO> getLecList() {
		return lecList;
	}

	public void setLecList(List<LectureVO> lecList) {
		this.lecList = lecList;
	}

}
