package com.ojt.nexture.www.manager;

import java.util.List;
import com.ojt.nexture.www.entity.HumanVO;

public class StudentManagerClass implements StudentManager {

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
	public boolean leadingStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fixStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent(List<HumanVO> userList,String userPhoneNum) {
		for(int i =0; i < userList.size(); i++) {
			if(userList.get(i).getPhoneNum().equals(userPhoneNum)) {
				userList.remove(i);
			}
		}
		return false;
	}

}
