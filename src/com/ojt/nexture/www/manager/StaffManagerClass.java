package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;

public class StaffManagerClass implements StaffManager {
	String checkPhoneNum1;

	@Override

	public boolean fixStaff() {
		// TODO Auto-generated method stub
		return false;
	}

	// 회원가입
	@Override
	public boolean joinStaff(List<HumanVO> userList, HumanVO human) {
		// TODO Auto-generated method stub
		if (userList.size() == 0) {
			userList.add(human);
		} else {
			for (int i = 0; i < userList.size(); i++) {
				checkPhoneNum1 = userList.get(i).getPhoneNum();
				System.out.println(checkPhoneNum1);
				if (human.getPhoneNum().equals(checkPhoneNum1)){
					System.out.println("동일한 핸드폰 번호가 존재합니다.");
				}
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
	public void logInStaff() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addClass() {
		// TODO Auto-generated method stub

	}

}
