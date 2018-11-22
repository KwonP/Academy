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
	

	@Override
	public void pj_Join() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean joinProfessor(List<HumanVO> userList, HumanVO human) {
		for(int i =0; i<userList.size(); i++) {
			if(userList.contains(human.getPhoneNum())) {
				System.out.println("동일 번호 존재");
				
			}else {
				System.out.println("오케잉");
				userList.add(human);
				System.out.println(userList);
			}
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