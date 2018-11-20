package com.ojt.nexture.www.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.ProfessorVO;
import com.ojt.nexture.www.entity.StaffVO;
import com.ojt.nexture.www.entity.StudentVO;
import com.ojt.nexture.www.manager.ManagerClass;
import com.ojt.nexture.www.manager.StaffManager;

public class AcademyUI {

	String name = null;
	String password = null;
	int age = 0;
	String phoneNum = null;
	String additionalInfo1 = "";
	String additionalInfo2 = "";
	boolean flag = false;
	boolean flag2 = false;
	int choice = 0;

	Scanner sc = new Scanner(System.in);
	StaffManager manager = new ManagerClass();

	public AcademyUI() {
		flag = true;
		// メインメニュー表示するためのループ文
		while (flag) {
			menu();
			choice = 0;
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				missMatchExCler();
			}

			switch (choice) {
			case 1:
				insertPerson();
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

		System.out.println("会員登録へ移動");

		flag2 = true;
		while (flag2) {
//			typeSelMenu();
			System.out.println("=============================================");
			int occupation = inputFromList(new String[] { "取り消し", "教授", "学生", "スタッフ" });
			if (occupation == 0) {
				return;
			}
//			int choice2 = 0;
//			try {
//				occupation = sc.nextInt();
//			} catch (Exception e) {
//				missMatchExCler();
//			}

			System.out.println("===========情報を入力してください=========== \n");
			HumanVO newHuman = null;

			name = inputString("名前 : ");
			password = inputString("パスワード :");
			age = inputInt("年齢 :");
			phoneNum = inputString("電話番号  : ");
			additionalInfo1 = "";
			additionalInfo2 = "";

			switch (occupation) {
			case 1:
				additionalInfo1 = inputString("所属学部  : ");
				newHuman = new ProfessorVO(name, password, age, phoneNum, additionalInfo1);
				break;

			case 2:
				additionalInfo1 = inputString("専攻  : ");
				additionalInfo2 = inputString("学番  : ");
				newHuman = new StudentVO(name, password, age, phoneNum, additionalInfo1, additionalInfo2);
				break;

			case 3:
				additionalInfo1 = inputString("所属学部  : ");
				newHuman = new StaffVO(name, password, age, phoneNum, additionalInfo1);
				break;

			default:
				System.out.println("正しくない命令です。");
				break;
			} // switch
			
			if (manager.insertPerson(newHuman)) {
				printSystemMessage("등록되었습니다.", true);
			} else {
				printSystemMessage("등록할 수 없습니다.", true);
			}
//			choice = 0;
//			insertCheck();
		}

	}

	public void insertCheck() {
		System.out.println("====================================== \n");
		System.out.println("名前 : " + name + ", 年齢 : " + age + ", 電話番号 : " + phoneNum);
		System.out.println("======================================");
		System.out.print("ここまま会員登録を進めましょうか。");
		String check = inputString("(Y/N)");
		if (check.equals("y")) {
			System.out.println("=======================");
			System.out.println("会員登録が完了しました。");
			System.out.println("=======================");

			sc.next();
		} else {
		}
	}

	public void menu() {
		System.out.println("===========アカデミー管理システム=========== \n");
		System.out.println("\t1．会員登録　　　2．ログイン \n");
		System.out.println("======================================");
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

	public int inputFromList(String[] lists) {
		int result = 0;
		for (int i = 0; i < lists.length; i++) {
			System.out.printf(" %d. %s\n", i, lists[i]);
		}
		System.out.println("=============================================");
		while (true) {
			result = inputInt("");
			if (result > lists.length - 1) {
				printSystemMessage("正しくない命令です。");
				continue;
			}
			return result;
		}

	} // inputFromList
}
