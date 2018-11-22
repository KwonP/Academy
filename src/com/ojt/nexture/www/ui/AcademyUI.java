package com.ojt.nexture.www.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.manager.StaffManagerClass;
import com.ojt.nexture.www.manager.StudentManagerClass;

public class AcademyUI {

	Scanner sc = new Scanner(System.in);
	List<HumanVO> userList = new ArrayList<>();
	List<LectureVO> lecList = new ArrayList<>();

	StudentManagerClass student = new StudentManagerClass();
	StaffManagerClass staff = new StaffManagerClass();

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

						break;
					case 2:
						// Student登録
						student.joinStudent();
						// userList.add((HumanVO) student.getStudentList());

						break;

					case 3:
						// Staff登録
						staff.joinStaff(); // Staff의 joinStaff 메소드 실행 (회원가입 실행)
						userList.add(staff.getHuman()); // 값 받아와서 HumanVO List에 저장
						if (staff.isFlag3()) {
							flag2 = false;
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
