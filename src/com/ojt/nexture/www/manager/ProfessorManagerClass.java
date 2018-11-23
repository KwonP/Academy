package com.ojt.nexture.www.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ojt.nexture.www.entity.ProfessorVO;
import com.ojt.nexture.www.entity.HumanVO;

public class ProfessorManagerClass implements ProfessorManager {
	Scanner sc = new Scanner(System.in);
	List<HumanVO> userList = new ArrayList<>();
	List<ProfessorVO> professorlist = new ArrayList<>();
	HumanVO human = new HumanVO();
	int checkPhoneNum;
	int checkNo;

	@Override
	public void pj_Join() {
		// TODO Auto-generated method stub

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
	public HumanVO loginProfessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean fixProfessor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProfessor() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getCheckPhoneNum() {
		// TODO Auto-generated method stub
		return checkPhoneNum;
	}

	

}