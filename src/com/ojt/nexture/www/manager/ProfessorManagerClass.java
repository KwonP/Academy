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
	String checkPhoneNum;
	@Override
	public void pj_Join() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean joinProfessor(List<HumanVO> userList, HumanVO human) {
		if (userList.size() == 0) {
			userList.add(human);
		} else {
			for (int i = 0; i < userList.size(); i++) {
				checkPhoneNum = userList.get(i).getPhoneNum();
				System.out.println(checkPhoneNum);
				if (human.getPhoneNum().equals(checkPhoneNum)) {
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

}