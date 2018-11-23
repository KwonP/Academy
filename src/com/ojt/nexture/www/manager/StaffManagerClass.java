package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;

public class StaffManagerClass implements StaffManager {
	int checkNum = 0;

	@Override

	public boolean fixStaff() {
		// TODO Auto-generated method stub
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
	public boolean deleteStaff() {
		// TODO Auto-generated method stub
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
	public void addClass() {
		// TODO Auto-generated method stub

	}

	public int getCheckNum() {
		return checkNum;
	}

}
