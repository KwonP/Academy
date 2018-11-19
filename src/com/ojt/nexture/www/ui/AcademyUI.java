package com.ojt.nexture.www.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.ProfessorVO;
import com.ojt.nexture.www.entity.StaffVO;
import com.ojt.nexture.www.entity.StudentVO;
import com.ojt.nexture.www.manager.ManagerClass;

import sun.applet.Main;

public class AcademyUI {
	
	String name = null;
	String password = null;
	int age = 0;
	String phoneNum = null;
	String additionalInfo1 = "";
	String additionalInfo2 = "";
	boolean flag = false;
	boolean flag2 = false;

	Scanner sc = new Scanner(System.in);
	ManagerClass manager = new ManagerClass();

	public AcademyUI() {
		flag = true;
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

				flag2 = true;
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
						insertPerson();
						break;
					case 2:
						// Student登録
						insertPerson();
						break;
					case 3:
						// Staff登録
						insertPerson();
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
				String userName;
				String password;
				System.out.println("ログイン画面へ移行");
				System.out.println("会員ID（名前）");
				System.out.println("");
				userName = sc.nextLine();
				password = sc.nextLine();
				break;
			case 3:

				break;
			default:
				System.out.println("正しいメニューを選択してください。");
				break;
			}

		}

	}

	// 회원 정보 등록
	public void insertPerson() {
		System.out.println("===========情報を入力してください=========== \n");
		HumanVO newHuman = null;

		name = inputString(" 이름 : ");
		password = inputString(" 패스워드 :");
		age = inputInt(" 나이 :");
		phoneNum = inputString(" 전화번호 : ");
		additionalInfo1 = "";
		additionalInfo2 = "";

		switch (1) {
		case 1:
			System.out.println("case1");
			additionalInfo1 = inputString(" 부서 : ");
			newHuman = new ProfessorVO(name, password, age, phoneNum, additionalInfo1);
			break;
		case 2:
			System.out.println("case2");
			additionalInfo1 = inputString(" 전공 : ");
			additionalInfo2 = inputString(" 학번 : ");
			newHuman = new StudentVO(name, password, age, phoneNum, additionalInfo1, additionalInfo2);
			break;
		case 3:
			System.out.println("case3");
			additionalInfo1 = inputString(" 부서 : ");
			newHuman = new StaffVO(name, password, age, phoneNum, additionalInfo1);
			break;
		} // switch

		insertCheck();
	}

	public void insertCheck() {
		System.out.println("====================================== \n");
		System.out.println("이름 : " + name + ", 나이 : " + age + ", 전화번호 : " + phoneNum);
		System.out.println("======================================");
		System.out.println("여기까지 회원정보가 맞습니까?");
		String check = inputString("Y/N");
		if (check.equals("y")) {
			flag2 = false;
} else {
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

	public void loginComplMenu(String name) {
		System.out.println("============================================= \n\n" + "\t\tようこそ！" + name + "様!\n\n"
				+ "１．担当講義一覧     ２．情報修正     ３．退会     ４．ログアウト\n" + "\n=============================================");
	}

	public void missMatchExCler() {
		sc.nextLine();
		System.out.println("メニュー選択は数字を入力してください。");
	}

	public String inputString(String inputMessage) {
		System.out.print(inputMessage);
		return sc.next();
	}

	public int inputInt(String inputMessage) {
		while (true) {
			try {
				System.out.print(inputMessage + " ");
				return sc.nextInt();
			} catch (InputMismatchException e) {
				printSystemMessage("숫자를 입력하여 주십시오.");
				sc.next();
			} // try
		} // while
	} // inputInt()

	public void printSystemMessage(String message) {
		System.out.println(" System : " + message);
	}

	public void printSystemMessage(String message, boolean isPause) {
		System.out.println("----------------------------------");
		printSystemMessage(message);
		System.out.println("----------------------------------");
		if (isPause) {
			System.out.println(" 아무키나 누르시면 메인으로 돌아갑니다.");
			// scanner.skip("[\\n\\r]");
			sc.next();
			// System.out.println("DEBUG @22222");
		}
	}
}
