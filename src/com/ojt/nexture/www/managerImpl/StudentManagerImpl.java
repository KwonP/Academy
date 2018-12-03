package com.ojt.nexture.www.managerImpl;

import java.util.ArrayList;
import java.util.List;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.manager.StudentManager;

public class StudentManagerImpl implements StudentManager {

	int checkNum, checkNum2, personCount;
	String userName;
	int lectNum1;
	int lectNum2;
	List<Integer> request;

	@Override // ログイン機能
	public void loginStudent(List<HumanVO> userList, String uniqNum, String password) {

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUniqNum().equals(uniqNum))
				userName = userList.get(i).getName();
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t ようこそ！" + userName + "様！");
		System.out.println("\t1．全体講義一覧及び申請　　　2．自分の講義一覧及びキャンセル　　　3．ログアウト \n");
		System.out.println("----------------------------------------------------------------------------------");

	}

	@Override // 講義リストを見る機能
	public boolean allLeadingStudent(List<LectureVO> lecList, List<String[]> classStudent) {

		System.out.println("講義リスト一です。");
		lectNum1 = 1;
		request = new ArrayList<>();

		for (int a = 0; a < lecList.size(); a++) {
			personCount = 0;
			if (lecList.get(a).getOk() == 2) {
				for (int y = 0; y < classStudent.size(); y++) {
					if (lecList.get(a).getLectureName().equals(classStudent.get(y)[1])) {
						personCount++;
					}
				}
				System.out.println(lectNum1 + ". 講義名 : " + lecList.get(a).getLectureName() + "  担当者 : "
						+ lecList.get(a).getProfessor() + "  単位 : " + lecList.get(a).getScore() + "  申請人数 : "
						+ personCount + "/" + lecList.get(a).getPersonnel());
				request.add(a);
				lectNum1++;
			}
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("申請する講義の番号を選んでください。帰る時には0番を書いてください。");
		System.out.println("----------------------------------------------------------------------------------");

		return true;

	}

	@Override // 講義の申請機能
	public boolean requestStudent(List<String[]> classStudent, List<LectureVO> lecList, String userUinqNum,
			int lectNumCheck1) {

		checkNum = 0;
		personCount = 0;

		for (int i = 0; i < classStudent.size(); i++) {
			if (classStudent.get(i)[1].equals(lecList.get(request.get(lectNumCheck1 - 1)).getLectureName())) {
				if (userUinqNum.equals(classStudent.get(i)[0]))
					checkNum++;
			}
		} // 重複のチェック

		for (int i = 0; i < classStudent.size(); i++) {
			if (classStudent.get(i)[1].equals(lecList.get(request.get(lectNumCheck1 - 1)).getLectureName())) {
				personCount++;

			}
		} // 講義を申請した人数増加

		if (lecList.get(request.get(lectNumCheck1 - 1)).getPersonnel() <= personCount) {
			checkNum++;
		} // 講義を申請した人数チェック

		if (checkNum == 0) {

			classStudent
					.add(new String[] { userUinqNum, lecList.get(request.get(lectNumCheck1 - 1)).getLectureName() });

			System.out.println(lecList.get(request.get(lectNumCheck1 - 1)).getLectureName() + "を申請しました。");

		} else {
			System.out.println("人数が超過した講義とかもう申請した講義です。");
			checkNum = 0;
		}
		return true;

	}

	@Override // 自分が申請した講義リストを見る機能
	public boolean leadingStudent(List<String[]> classStudent, List<LectureVO> lecList, String userUinqNum) {
		
		lectNum2 = 1;
		
		System.out.println("自分の講義リスト一です。");

		for (int k = 0; k < classStudent.size(); k++) {
			if (userUinqNum.equals(classStudent.get(k)[0])) {
				for (int y = 0; y < lecList.size(); y++) {
					if (classStudent.get(k)[1].equals(lecList.get(y).getLectureName())) {
						System.out.println(lectNum2 + ". 講義名 : " + lecList.get(y).getLectureName() + "  担当者 : "
								+ lecList.get(y).getProfessor() + "  単位 : " + lecList.get(y).getScore());
						lectNum2++;
					}
				}
			}
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("申請キャンセルする講義の名前を書いてください。帰る時には0番を書いてください。");
		System.out.println("----------------------------------------------------------------------------------");

		return true;

	}

	@Override // 講義のキャンセル機能
	public boolean cancleStudent(List<String[]> classStudent, List<LectureVO> lecList, String userUinqNum,
			String lectNumCheck2) {

		checkNum2 = 0;

		for (int i = 0; i < classStudent.size(); i++) {
			if (classStudent.get(i)[1].equals(lectNumCheck2)) {
				if (userUinqNum.equals(classStudent.get(i)[0])) {
					checkNum2 = 0;
					classStudent.remove(classStudent.get(i));
					System.out.println(lectNumCheck2 + "をキャンセルしました。");
					personCount--;
				}
			}
		} // 講義を申請した方が自分か確認 // 講義を申請した人数減少

		return true;
	}
}
