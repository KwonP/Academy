package com.ojt.nexture.www.managerImpl;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.manager.StaffManager;

public class StaffManagerImpl implements StaffManager {
	int checkNum, temp;
	int deleteCheckFlag = 0;
	int fixCheck, listNum, professorCheck;
	int[] viewLecList;
	String access;

	@Override
	public void logInStaff(String userPassword, String userUinqNum) {
		// TODO Auto-generated method stub
		if (userPassword.equals("12345") && userUinqNum.equals("00000")) {
			System.out.println("-------------------------------------------");
			System.out.println("　　　　　　               ようこそ! staff さん!");
			System.out.println("1.ユーザー登録     2.講義承認     3.全体講義一覧      4.ログアウト");
			System.out.println("-------------------------------------------");
		}

	}

	@Override
	public boolean joinProfessor(List<HumanVO> userList, HumanVO human) {
		// TODO Auto-generated method stub
		int checkNo = 0;
		if (userList.size() == 0) {
			System.out.println("登録が完了しました。");
			System.out.println("会員番号は " + human.getUniqNum() + "です。");
			userList.add(human);
		} else {
			for (int i = 0; i < userList.size(); i++) {
				if (human.getPhoneNum().equals(userList.get(i).getPhoneNum())) {
					checkNo++;
				} // 입력한 번호와 동일한 핸드폰 번호가 있다면 checkNo값 +1
			}
			if (checkNo > 0) { // 동일한 핸드폰 번호가 1개라도 있다면 checkNo값은 0보다 크다. 따라서 checkNo > 0 이라면 중복하는 번호가 있다는것
				checkNum = 1;
				System.out.println("同じ電話番号があります。");
			} else {
				checkNum = 0;
				System.out.println("登録が完了しました。");
				System.out.println("会員番号は " + human.getUniqNum() + "です。");
				userList.add(human);
			}
		}
		return true;
	}

	@Override
	public boolean joinStudent(List<HumanVO> userList, HumanVO human) {
		// TODO Auto-generated method stub
		int checkNo = 0;
		if (userList.size() == 0) {
			System.out.println("登録が完了しました。");
			System.out.println("会員番号は " + human.getUniqNum() + "です。");
			userList.add(human);
		} else {
			for (int i = 0; i < userList.size(); i++) {
				if (human.getPhoneNum().equals(userList.get(i).getPhoneNum())) {
					checkNo++;
				} // 입력한 번호와 동일한 핸드폰 번호가 있다면 checkNo값 +1
			}
			if (checkNo > 0) { // 동일한 핸드폰 번호가 1개라도 있다면 checkNo값은 0보다 크다. 따라서 checkNo > 0 이라면 중복하는 번호가 있다는것
				checkNum = 1;
				System.out.println("同じ電話番号があります。");
			} else {
				checkNum = 0;
				System.out.println("登録が完了しました。");
				System.out.println("会員番号は " + human.getUniqNum() + "です。");
				userList.add(human);
			}
		}
		return true;
	}

	@Override
	public boolean accessClass(List<LectureVO> lecList, int accessNum, List<Integer> accessCheck) {
		// TODO Auto-generated method stub
		System.out.println("承認が完了しました。");
		lecList.get(accessCheck.get(accessNum - 1)).setOk(2);
		return true;
	}

	@Override
	public boolean viewAllClass(List<LectureVO> lecList) {
		// TODO Auto-generated method stub
		for (int a = 0; a < lecList.size(); a++) {
			if (lecList.get(a).getOk() == 1) {
				access = "承認待ち";
			}
			if (lecList.get(a).getOk() == 2) {
				access = "承認";
			}
			System.out.println("講義名 : " + lecList.get(a).getLectureName() + ",     担当者 : "
					+ lecList.get(a).getProfessor() + ",     単位 : " + lecList.get(a).getScore() + ",     申請可能人数 : "
					+ lecList.get(a).getPersonnel().length + ",     承認状況 :" + access);
		}
		/*
		 * for (int i = 0; i < lecList.size(); i++) { if (lecList.get(i).getOk() == 1) {
		 * viewLecList[temp] = i; temp++; } } for (int j = 0; j < temp; j++) { for (int
		 * a = 0; a < lecList.size(); a++) { if (viewLecList[j] == a) {
		 * System.out.println("승인안된거"); System.out.println("講義名 : " +
		 * lecList.get(a).getLectureName() + "担当者 : " + lecList.get(a).getProfessor() +
		 * "単位 : " + lecList.get(a).getScore() + "申請可能人数 : " +
		 * lecList.get(a).getPersonnel() + "承認状況 :" + lecList.get(a).getOk());
		 * 
		 * } } } for (int j = 0; j < temp; j++) { for (int a = 0; a < lecList.size();
		 * a++) { if (viewLecList[j] != a) { System.out.println("승인된거");
		 * System.out.println("講義名 : " + lecList.get(a).getLectureName() + "担当者 : " +
		 * lecList.get(a).getProfessor() + "単位 : " + lecList.get(a).getScore() +
		 * "申請可能人数 : " + lecList.get(a).getPersonnel() + "承認状況 :" +
		 * lecList.get(a).getOk());
		 * 
		 * } } }
		 */
		return true;
	}

	public int getCheckNum() {
		return checkNum;
	}

	public int getDeleteCheckFlag() {
		return deleteCheckFlag;
	}

}
