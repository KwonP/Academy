package com.ojt.nexture.www.manager;

import java.util.List;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public class StudentManagerClass implements StudentManager {
	int checkNum = 0;
	int fixCheck, listNum;

	@Override
	public boolean joinStudent(List<HumanVO> userList, HumanVO human) {

		int Check = 0;

		if (userList.size() == 0) {
			userList.add(human);
		} else {

			for (int i = 0; i < userList.size(); i++) {

				if (human.getPhoneNum().equals(userList.get(i).getPhoneNum())) {
					Check++;
				}

			}
			if (Check > 0) {
				Check = 1;
				System.out.println("同一な電話番号があります。");
			} else {
				Check = 0;
				userList.add(human);
			}
		}

		for (int k = 0; k < userList.size(); k++) {
			System.out.println(userList.get(k));
		}

		return true;

	}

	@Override
	public HumanVO loginStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean leadingStudent(List<LectureVO> lecList) {
		for (int i = 0; i < lecList.size(); i++) {
			System.out.println(lecList.get(i));
		}
		return false;
	}

	@Override
	public boolean fixStudent(List<HumanVO> userList, HumanVO human, String userPhoneNum) {

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

		for (int y = 0; y < userList.size(); y++) {
			System.out.println(userList.get(y));
		}

		return true;
	}

	@Override
	public boolean deleteStudent(List<HumanVO> userList, String userPhoneNum) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getPhoneNum().equals(userPhoneNum)) {
				userList.remove(i);
			}
		}
		return false;
	}

}
