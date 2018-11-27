package com.ojt.nexture.www.manager;

import java.util.List;
import java.util.Scanner;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public class ProfessorManagerImpl implements ProfessorManager {
	Scanner sc = new Scanner(System.in);
	int checkPhoneNum;
	int checkNo;
	int fixCheck, listNum;
	int PrCheckNum = 0;
	int checkNum = 0;
	int professorCheck = 0;

	@Override
	public void pj_Join(List<LectureVO> lecList, String userName) {

		for (int i = 0; i < lecList.size(); i++) {
			if (lecList.get(i).getProfessor().equals(userName)) {
				System.out.println(i + 1 + "." + " 講義名 : " + lecList.get(i).getLectureName() + "  担当者 : "
						+ lecList.get(i).getProfessor() + "  単位 : " + lecList.get(i).getScore());
			}

		}
	}

	@Override
	public boolean addClass(List<LectureVO> lecList, LectureVO lecture, List<HumanVO> userList) {
		int checkNo = 0;
		professorCheck = 0;

		for (int a = 0; a < userList.size(); a++) {
			if (userList.get(a).getClass().getSimpleName().equals("ProfessorVO")
					&& userList.get(a).getName().equals(lecture.getProfessor())) {
				professorCheck = 1;
				System.out.println(professorCheck);
			}
		}
			if (lecList.size() == 0) {
				System.out.println("入力が完了しました。");
				lecList.add(lecture);
			} else {
				for (int i = 0; i < lecList.size(); i++) {
					if (lecture.getLectureName().equals(lecList.get(i).getLectureName())
							&& lecture.getProfessor().equals(lecList.get(i).getProfessor())) {
						checkNo++;
					}
				}
				if (checkNo > 0) {
					System.out.println("入力した講義です。");
				} else {
					System.out.println("入力が完了しました。");
					lecList.add(lecture);
				}
			}
			System.out.println("存在しない担当者です。");
		return true;
	}

	@Override
	public boolean joinProfessor(List<HumanVO> userList, HumanVO human) {
		checkNo = 0;
		if (userList.size() == 0) {
			userList.add(human);
		} else {
			for (int i = 0; i < userList.size(); i++) {
				if (human.getPhoneNum().equals(userList.get(i).getPhoneNum())) {
					checkNo++;
				}
			}
			if (checkNo > 0) {
				checkPhoneNum = 1;
				System.out.println("同じ電話番号があります。");
			} else {
				checkPhoneNum = 0;
				userList.add(human);
			}
		}
		for (int a = 0; a < userList.size(); a++) {
			System.out.println(userList.get(a));
		}

		return true;
	}

	@Override
	public void loginProfessor(String userName) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------");
		System.out.println("ようこそ!" + userName + "さん!");
		System.out.println("1.担当講義閲覧     2.講義入力     3.情報修正     4.退会     5.ログアウト");
		System.out.println("---------------------------------");
	}

	@Override
	public boolean fixProfessor(List<HumanVO> userList, HumanVO human, String userPhoneNum) {
		// TODO Auto-generated method stub
		for (int a = 0; a < userList.size(); a++) {
			if (human.getPhoneNum().equals(userList.get(a).getPhoneNum())) {
				fixCheck = 0;

			} else {
				for (int i = 0; i < userList.size(); i++) {
					if (userPhoneNum.equals(userList.get(i).getPhoneNum())) {
						fixCheck = 1;
						listNum = i;

					}
				}
			}
		}
		if (fixCheck == 0) {
			System.out.println("同じ電話番号があります。");
			System.out.println("修正を失敗しました。");
			checkNum = 1;
		}
		if (fixCheck == 1) {
			userList.set(listNum, human);
			System.out.println("修正が完了しました。");
			System.out.println("またログインしてください。");
			checkNum = 2;
		}
		return true;
	}

	@Override
	public boolean deleteProfessor(List<HumanVO> userList, String userPhoneNum) {
		// TODO Auto-generated method stub
		System.out.println("本当に退会しますか。 (Y/N)");
		String check = sc.next();
		if (check.equals("y") || check.equals("Y")) {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(userPhoneNum)) {
					System.out.println("退会が完了しました。");
					userList.remove(i);
					PrCheckNum = 0;
				}
			}
		} else if (check.equals("n") || check.equals("N")) {
			PrCheckNum = 1;
			System.out.println("退会をキャンセルしました。");
		} else {
			System.out.println("誤入力しました。");
			PrCheckNum = 1;
		}
		return false;
	}

	public int getCheckPhoneNum() {
		// TODO Auto-generated method stub
		return checkPhoneNum;
	}

	public int getPrCheckNum() {
		return PrCheckNum;
	}

	public int getCheckNum() {
		// TODO Auto-generated method stub
		return checkNum;
	}

}