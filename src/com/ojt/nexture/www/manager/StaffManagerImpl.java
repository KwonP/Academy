package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public class StaffManagerImpl implements StaffManager {
	int checkNum;
	int deleteCheckFlag = 0;
	int fixCheck, listNum, professorCheck;

	@Override
	public void logInStaff(String userName, String userPassword, String userUinqNum) {
		// TODO Auto-generated method stub

		if (userName.equals("staff") && userPassword.equals("12345") && userUinqNum.equals("00000")) {
			System.out.println("---------------------------------------------------------");
			System.out.println("　　　　　　                       　ようこそ!" + userName + " さん!");
			System.out.println("1.ユーザー登録     2.講義入力     30.情報修正     4.退会     5.ログアウト");
			System.out.println("---------------------------------------------------------");
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
		for (int k = 0; k < userList.size(); k++) {
			System.out.println(userList.get(k));
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
		for (int k = 0; k < userList.size(); k++) {
			System.out.println(userList.get(k));
		}
		return true;
	}

	// 회원가입
	@Override
	public boolean joinStaff(List<HumanVO> userList, HumanVO human) {
		// TODO Auto-generated method stub
		int checkNo = 0;
		if (userList.size() == 0) {
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
				userList.add(human);
			}
		}
		return true;
	}

	public boolean fixStaff(List<HumanVO> userList, HumanVO human, String userPhoneNum) {

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
	public boolean deleteStaff(List<HumanVO> userList, String userPhoneNum, String deleteCheck) {
		// TODO Auto-generated method stub
		if (deleteCheck.equals("y") || deleteCheck.equals("Y")) {
			for (int i = 0; i < userList.size(); i++) {
				if (userList.get(i).getPhoneNum().equals(userPhoneNum)) {
					userList.remove(i);
					System.out.println("退会が完了しました。");
					deleteCheckFlag = 0;
				}
			}
		} else {
			System.out.println("退会をキャンセルしました。");
			deleteCheckFlag = 1;
		}
		return false;
	}

	@Override
	public boolean addClass(List<LectureVO> lecList, LectureVO lecture, List<HumanVO> userList) {
		// TODO Auto-generated method stub
		int checkNo = 0;
		professorCheck = 0;

		for (int a = 0; a < userList.size(); a++) {
			if (userList.get(a).getClass().getSimpleName().equals("ProfessorVO")
					&& userList.get(a).getName().equals(lecture.getProfessor())) {
				professorCheck = 1;
				System.out.println(professorCheck);
			}
		}
		if (professorCheck == 1) {
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
		} else {
			System.out.println("存在しない担当者です。");
		}
		return true;
	}

	public int getCheckNum() {
		return checkNum;
	}

	public int getDeleteCheckFlag() {
		return deleteCheckFlag;
	}

}
