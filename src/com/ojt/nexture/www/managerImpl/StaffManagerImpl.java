package com.ojt.nexture.www.managerImpl;

import java.util.ArrayList;
import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.manager.StaffManager;

public class StaffManagerImpl implements StaffManager {
	int checkPhoneNum, checkClassListNum;
	int deleteCheckFlag = 0;
	int fixCheck, listNum, professorCheck;
	List<Integer> viewLecList;
	String access;

	// staff ログイン
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

	// 教授登録
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
				checkPhoneNum = 1;
				System.out.println("同じ電話番号があります。");
			} else {
				checkPhoneNum = 0;
				System.out.println("登録が完了しました。");
				System.out.println("会員番号は " + human.getUniqNum() + "です。");
				userList.add(human);
			}
		}
		return true;
	}

	// 学生登録
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
				checkPhoneNum = 1;
				System.out.println("同じ電話番号があります。");
			} else {
				checkPhoneNum = 0;
				System.out.println("登録が完了しました。");
				System.out.println("会員番号は " + human.getUniqNum() + "です。");
				userList.add(human);
			}
		}
		return true;
	}

	// 講義承認
	@Override
	public boolean accessClass(List<LectureVO> lecList, int accessNum, List<Integer> accessCheck) {
		// TODO Auto-generated method stub
		System.out.println("承認が完了しました。");
		lecList.get(accessCheck.get(accessNum - 1)).setOk(2);
		return true;
	}

	// 全体講義一覧
	@Override
	public boolean viewAllClass(List<LectureVO> lecList) {
		// TODO Auto-generated method stub
		viewLecList = new ArrayList<>();
		checkClassListNum = 0;

		if (lecList.size() == 0) {
			System.out.println("講義リストがないです。");
			checkClassListNum = 1;
		} else {

			for (int i = 0; i < lecList.size(); i++) {
				if (lecList.get(i).getOk() == 1) {
					viewLecList.add(i);
				}
			}

			for (int j = 0; j < lecList.size(); j++) {
				if (lecList.get(j).getOk() != 1) {
					viewLecList.add(j);
				}
			}

			System.out.println("------------------------------------------------------------------------");
			for (int a = 0; a < viewLecList.size(); a++) {
				if (lecList.get(viewLecList.get(a)).getOk() == 1) {
					access = "承認待ち";
				}
				if (lecList.get(viewLecList.get(a)).getOk() == 2) {
					access = "承認完了";
				}
				System.out.println("講義名 : " + lecList.get(a).getLectureName() + ",     担当者 : "
						+ lecList.get(a).getProfessor() + ",     単位 : " + lecList.get(a).getScore() + ",     申請可能人数 : "
						+ lecList.get(a).getPersonnel() + ",     承認状況 :" + access);
			}
			System.out.println("------------------------------------------------------------------------");
		}
		return true;
	}

	public int getcheckPhoneNum() {
		return checkPhoneNum;
	}

	public int getDeleteCheckFlag() {
		return deleteCheckFlag;
	}

	public int getCheckClassListNum() {
		return checkClassListNum;
	}

}
