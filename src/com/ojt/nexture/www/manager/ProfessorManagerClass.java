package com.ojt.nexture.www.manager;

import java.util.List;
import java.util.Scanner;
import com.ojt.nexture.www.entity.HumanVO;

public class ProfessorManagerClass implements ProfessorManager {
	Scanner sc = new Scanner(System.in);
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
	public void loginProfessor(String userName) {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------");
		System.out.println("ようこそ!" + userName + "さん!");
		System.out.println("1.강의담당열람     2.정보수정     3.삭제     4.로그아웃");
		System.out.println("---------------------------------");
	}

	@Override
	public boolean fixProfessor() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProfessor(List<HumanVO> userList,String userPhoneNum) {
		// TODO Auto-generated method stub
		System.out.println("삭제 하겠습니까?(Y/N)");
		String check = sc.next();
		if(check.equals("y")||check.equals("Y")) {
			for(int i =0; i < userList.size(); i++) {
				if(userList.get(i).getPhoneNum().equals(userPhoneNum)) {
					System.out.println("삭제 되었습니다.");
					userList.remove(i);
					checkPhoneNum = 0;
				}
			}
		}else if(check.equals("n")||check.equals("N")) {
			checkPhoneNum = 1;
			System.out.println("취소했습니다");
			return false;
		}else {
			System.out.println("잘못 입력하셧습니다.");
		}
		return true;
	}

	public int getCheckPhoneNum() {
		// TODO Auto-generated method stub
		return checkPhoneNum;
	}

	

}