package com.ojt.nexture.www.managerImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.manager.ProfessorManager;

public class ProfessorManagerImpl implements ProfessorManager {
	Scanner sc = new Scanner(System.in);
	int checkNo;
	int fixCheck, listNum;
	int checkNum = 0;
	int professorCheck = 0;
	String repre = null;
	int repersonnel;
	int plusenumber = 1;
	String prename;
	String intch;
	String intchN;
	int tr;
	String newlecList;

	@Override
	public void pj_Join(List<String[]> classStudent, List<HumanVO> userList, List<LectureVO> lecList,
			String userUinqNum) {
		checkNo = 0;
		plusenumber = 1;
		tr = 0;
		do {
			for (int a = 0; a < lecList.size(); a++) {
				if (lecList.get(a).getUniqNum().equals(userUinqNum)) {
					checkNo++;
				}
			}
			if (checkNo == 0) {
				System.out.println("保存された値段がありません。");
			} else {
				for (int i = 0; i < lecList.size(); i++) {
					if (lecList.get(i).getUniqNum().equals(userUinqNum)) {
						if (lecList.get(i).getOk() == 1) {
							intch = Integer.toString(lecList.get(i).getOk());
							intchN = intch;
							intchN = "承認待ち";
						}
						if (lecList.get(i).getOk() == 2) {
							intch = Integer.toString(lecList.get(i).getOk());
							intchN = intch;
							intchN = "承認完了";
						}
						System.out.println(plusenumber + "." + " 講義名 : " + lecList.get(i).getLectureName() + "  担当者 : "
								+ lecList.get(i).getProfessor() + "  学生数 : " + lecList.get(i).getPersonnel() + "  単位 : "
								+ lecList.get(i).getScore() + "  OK : " + intchN);
						plusenumber++;
					}

				}
			}
			tr = 1;
		} while (tr == 0);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////

		if (plusenumber == 1) { // 강의 목록이 존재하지 않는다면
			checkNum = 1; // 목록이 다시 나오지 않는다 (로그인 후 메뉴로 돌아간다.)
		} else {
			System.out.println("講義科目を入力してください。 ");
			repre = sc.nextLine();
			for (int z = 0; z < lecList.size(); z++) {
				if (lecList.get(z).getLectureName().equals(repre)) {
					newlecList = lecList.get(z).getLectureName();
					System.out.println(newlecList);
				} else {
					System.out.println("값이 없습니다.");
					break;
				}
			}
			for (int a = 0; a < classStudent.size(); a++) {
				if (classStudent.get(a)[1].equals(newlecList)) {// 입력한 값이 같으면 출력
					for (int x = 0; x<userList.size(); x++) {
						if (classStudent.get(a)[0].equals(userList.get(x).getUniqNum())) {// 입력한 강의와 학생이 신청한 강의의 이름이 같으면
							System.out.println("학생이름:" + userList.get(x).getName());
						} else {
							System.out.println("값이 없습니다.3");
						}
					}
				} else {
					System.out.println("값이없습니다.2");
				}
			}

		}
	}

	@Override
	public boolean addClass(List<LectureVO> lecList, LectureVO lecture, List<HumanVO> userList, String userUinqNum) {

		checkNo = 0;
		if (lecList.size() == 0) {
			lecList.add(lecture);
			System.out.println("入力が完了しました。");
		} else {
			for (int z = 0; z < userList.size(); z++) {
				if (userList.get(z).getUniqNum().equals(userUinqNum)) {
					String prename = userList.get(z).getName();
					System.out.println(prename);
					for (int i = 0; i < lecList.size(); i++) {
						if (lecture.getLectureName().equals(lecList.get(i).getLectureName())
								&& lecture.getProfessor().equals(prename)) {
							checkNo++;
						}

					}
				}
			}

			if (checkNo > 0) {
				System.out.println("入力した講義です。");
			} else {
				System.out.println("入力が完了しました。");
				lecList.add(lecture);
			}
		}
		return false;
	}

	@Override
	public void loginProfessor(List<HumanVO> userList, String userUinqNum) {
		// TODO Auto-generated method stub
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUniqNum().equals(userUinqNum)) {
				String pre = userList.get(i).getName();
				System.out.println("-------------------------------------------");
				System.out.println("　　　　　　               ようこそ!" + pre + "さん!");
				System.out.println("1.担当講義閲覧     2.講義入力     3.情報修正     4.ログアウト");
				System.out.println("-------------------------------------------");
			}
		}

	}

	@Override
	public boolean fixProfessor(List<LectureVO> lecList, List<HumanVO> userList, String userUinqNum) {
		tr = 0;
		plusenumber = 1;
		checkNum = 0;
		do {
			for (int a = 0; a < lecList.size(); a++) {
				if (lecList.get(a).getUniqNum().equals(userUinqNum)) {
					checkNo++;
				}
			}
			if (checkNo == 0) {
				System.out.println("保存された値段がありません。");
			} else {
				for (int i = 0; i < lecList.size(); i++) {
					if (lecList.get(i).getUniqNum().equals(userUinqNum)) {
						if (lecList.get(i).getOk() == 1) {
							intch = Integer.toString(lecList.get(i).getOk());
							intchN = intch;
							intchN = "承認待ち";
						}
						if (lecList.get(i).getOk() == 2) {
							intch = Integer.toString(lecList.get(i).getOk());
							intchN = intch;
							intchN = "承認完了";
						}
						System.out.println(plusenumber + "." + " 講義名 : " + lecList.get(i).getLectureName() + "  担当者 : "
								+ lecList.get(i).getProfessor() + "  学生数 : " + lecList.get(i).getPersonnel() + "  単位 : "
								+ lecList.get(i).getScore() + "  OK : " + intchN);
						plusenumber++;
					}

				}
			}
			tr = 1;

		} while (tr == 0);

		if (plusenumber == 1) {
			checkNum = 1;
		} else {
			System.out.println("変更しようとする講義科目を入力してください。돌아 갈경우 0를 눌러주세요 ");
			repre = sc.nextLine();
			int q = 0;
			String w = Integer.toString(q);
			if (repre.equals(w)) {
				checkNum = 1;
			} else {
				for (int a = 0; a < lecList.size(); a++) {
					if (lecList.get(a).getLectureName().equals(repre)) {
						do {
							repersonnel = inputInt("学生数 :");
						} while (repersonnel == 0);
						checkNum = 1;
						lecList.get(a).setPersonnel(repersonnel);
						System.out.println("修正完了しました。");
					}
				}
			}
		}
		return false;
	}

	public int getCheckNum() {
		// TODO Auto-generated method stub
		return checkNum;
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

}