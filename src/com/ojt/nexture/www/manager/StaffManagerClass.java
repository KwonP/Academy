package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public class StaffManagerClass implements StaffManager {
	int checkNum = 0;

	@Override

	public boolean fixStaff() {
		// TODO Auto-generated method stub
		System.out.println("정보수정 선택");
		return false;
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
		for (int a = 0; a < userList.size(); a++) {
			System.out.println(userList.get(a));
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
				}
			}
		} else {
			System.out.println("삭제안됨");
		}
		return false;
	}

	@Override
	public void logInStaff(String userName) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------");
		System.out.println("ようこそ!" + userName + "さん!");
		System.out.println("1.강의등록     2.정보수정     3.삭제     4.로그아웃");
		System.out.println("---------------------------------");

	}

	@Override
	public boolean addClass(List<LectureVO> lecList, LectureVO lecture) {
		// TODO Auto-generated method stub
		int checkNo = 0;
		if (lecture.getProfessor().equals(null)) {
			System.out.println("교수명을 입력해주십시오.");
		} else if (lecture.getLectureName().equals(null)) {
			System.out.println("강의명을 입력해주십시오.");
		} else if (lecture.getScore().equals(null)) {
			System.out.println("단위를 입력해주십시오.");
		} else {
			if (lecList.size() == 0) {
				lecList.add(lecture);
			} else {
				for (int i = 0; i < lecList.size(); i++) {
					if (lecture.getLectureName().equals(lecList.get(i).getLectureName())
							&& lecture.getProfessor().equals(lecList.get(i).getProfessor())) {
						checkNo++;
					}
				}
				if (checkNo > 0) {
					System.out.println("등록된 강의입니다.");
				} else {
					System.out.println("강의가 등록되었습니다.");
					lecList.add(lecture);
				}
			}
			for (int a = 0; a < lecList.size(); a++) {
				System.out.println(lecList.get(a));
			}
		}
		return true;

	}

	public int getCheckNum() {
		return checkNum;
	}

}
