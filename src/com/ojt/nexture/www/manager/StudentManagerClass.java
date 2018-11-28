package com.ojt.nexture.www.manager;

import java.util.List;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public class StudentManagerClass implements StudentManager {
	int checkNum = 0;
	int fixCheck, listNum;
	String userName;

	@Override
	public void loginStudent(List<HumanVO> userList, String uniqNum, String password) {

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUniqNum().equals(uniqNum))
				userName = userList.get(i).getName();
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t ようこそ！" + userName + "様！");
		System.out.println("\t1．全体講義一覧　　　2．自分の講義一覧　　　3．ログアウト \n");
		System.out.println("----------------------------------------------------------------------------------");

	}

	@Override
	public boolean allLeadingStudent(List<LectureVO> lecList) {
		
		System.out.println("講義リスト一です。");
		
		for (int i = 0; i < lecList.size(); i++) {
			if(lecList.get(i).getOk() == 2){
				System.out.println(i + ". 講義名 : " + lecList.get(i).getLectureName() + "  担当者 : "
						+ lecList.get(i).getProfessor() + "  単位 : " + lecList.get(i).getScore() + "  申請可能人数 : " + lecList.get(i).getPersonnel());
			}
		}
		
		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("\t1．講義申請　　　2．前で　 ");
		System.out.println("----------------------------------------------------------------------------------");
		return true;
	}
	
	@Override
	public boolean requestStudent(List<LectureVO> lecList, String lectNm) {
		for(int i = 0; i < lecList.size(); i++) {
			if(lecList.get(i).getLectureName().equals(lectNm)) {
				
				System.out.println(lectNm + "を申請しました。");
				System.out.println("承認をお待ちしてください。");
			} else {
				System.out.println("正しい講義を申請してください。");
			}
		}
		return true;
	}

	@Override
	public boolean leadingStudent(List<LectureVO> lecList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancletStudent(List<LectureVO> lecList) {
		// TODO Auto-generated method stub
		return false;
	}

}
