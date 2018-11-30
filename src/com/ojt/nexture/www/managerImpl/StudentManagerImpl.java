package com.ojt.nexture.www.managerImpl;

import java.util.ArrayList;
import java.util.List;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.manager.StudentManager;

public class StudentManagerImpl implements StudentManager {
	int checkNum = 0;
	int fixCheck, listNum;
	String userName;
	int lectNum1, lectNum2 = 1;
	List<Integer> request = new ArrayList<>();

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
	public boolean allLeadingStudent(List<LectureVO> lecList, int lectNum1) {

		System.out.println("講義リスト一です。");

		for (int a = 0; a < lecList.size(); a++) {
			if (lecList.get(a).getOk() == 2) {
				System.out.println(lectNum1 + ". 講義名 : " + lecList.get(a).getLectureName() + "  担当者 : "
						+ lecList.get(a).getProfessor() + "  単位 : " + lecList.get(a).getScore() + "  申請可能人数 : "
						+ lecList.get(a).getPersonnel());
				request.add(a);
				lectNum1++;
			}
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("申請する講義の番号を選んでください。帰る時には0番を書いてください。");
		System.out.println("----------------------------------------------------------------------------------");

		return true;

	}

	@Override
	public boolean requestStudent(List<String[]> classStudent, List<LectureVO> lecList, String userUinqNum,
			int lectNumCheck1) {

//		for (int i = 0; i < classStudent.size(); i++) {
//			for (int k = 0; k < lecList.size(); k++) {
//
//				if (classStudent.get(i)[1].equals(lecList.get(k).getLectureName())) {
//					System.out.println("もう申請した講義です。");
//					break;
//				}
//
//			}
//		}
//		
		classStudent.add(new String[] { userUinqNum, lecList.get(request.get(lectNumCheck1 - 1)).getLectureName() });
		
		for (int c = 0; c < classStudent.size(); c++) {
			System.out.println(classStudent.get(c)[1]);
		}

		System.out.println(lecList.get(request.get(lectNumCheck1 - 1)).getLectureName() + "を申請しました。");

		return true;
	}

	@Override
	public boolean leadingStudent(List<String[]> classStudent, List<LectureVO> lecList, String userUinqNum,
			int lectNum2) {
		System.out.println("自分の講義リスト一です。");

		for (int k = 0; k < classStudent.size(); k++) {
			if (userUinqNum.equals(classStudent.get(k)[0])) {
				for (int y = 0; y < lecList.size(); y++) {
					if (classStudent.get(k)[1].equals(lecList.get(y).getLectureName())) {
						System.out.println(lectNum2 + ". 講義名 : " + lecList.get(y).getLectureName() + "  担当者 : "
								+ lecList.get(y).getProfessor() + "  単位 : " + lecList.get(y).getScore() + "  申請可能人数 : "
								+ lecList.get(y).getPersonnel());
						lectNum2++;
					}
				}
			}
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("申請キャンセルする講義の番号を選んでください。帰る時には0番を書いてください。");
		System.out.println("----------------------------------------------------------------------------------");
		return true;
	}

	@Override
	public boolean cancleStudent() {
		// TODO Auto-generated method stub
		return false;
	}

}
