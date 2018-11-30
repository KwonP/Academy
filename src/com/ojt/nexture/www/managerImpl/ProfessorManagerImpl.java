package com.ojt.nexture.www.managerImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.manager.ProfessorManager;

public class ProfessorManagerImpl implements ProfessorManager {
	Scanner sc = new Scanner(System.in);
	int checkNo;
	int fixCheck, listNum;
	int checkNum = 0;
	int professorCheck = 0;
	int repreNumber =0;
	int plusenumber=1;
	String prename;
	String intch;
	String intchN;
	List<Integer> preList = new ArrayList<>();
	@Override
	public void pj_Join(List<HumanVO> userList, List<LectureVO> lecList, String userUinqNum) {
		if (lecList.size() == 0 ) {
			System.out.println("保存された値段がありません。");
		}
		for(int a=0; a<lecList.size(); a++) {
			if(!lecList.get(a).getUniqNum().equals(userUinqNum) && lecList.size() >=1) {
				checkNo++;
			}
		}
		if (checkNo > 0) {
			System.out.println("保存された値段がありません。");
		} else {
		}
		for (int i = 0; i < lecList.size(); i++) {
			if (lecList.get(i).getUniqNum().equals(userUinqNum)) {
				if (lecList.get(i).getOk() == 1) {
					intch = Integer.toString(lecList.get(i).getOk());
					intchN = intch;
					intchN = "承認待ち";
				}
				if (lecList.get(i).getOk() == 2) {
					intch = Integer.toString(lecList.get(i).getOk());
					intchN = intch;
					intchN = "承認完了";
				}
				System.out.println(plusenumber+ "." + " 講義名 : " + lecList.get(i).getLectureName() + "  担当者 : "
						+ lecList.get(i).getProfessor() + "  単位 : " + lecList.get(i).getScore() + "  OK : " + intchN);
				plusenumber++;
			}
			
		}
	}

	@Override
	public boolean addClass(List<LectureVO> lecList, LectureVO lecture, List<HumanVO> userList, String userUinqNum) {

		checkNo = 0;
		if (lecList.size() == 0) {
			lecList.add(lecture);
			System.out.println("入力が完了しました。");
		} else {
			for (int z = 0; z < userList.size(); z++) {
				if (userList.get(z).getUniqNum().equals(userUinqNum)) {
					String prename = userList.get(z).getName();
					System.out.println(prename);
					for (int i = 0; i < lecList.size(); i++) {
						if (lecture.getLectureName().equals(lecList.get(i).getLectureName())
								&& lecture.getProfessor().equals(prename)) {
							checkNo++;
						}

					}
				}
			}

			if (checkNo > 0) {
				System.out.println("入力した講義です。");
			} else {
				System.out.println("入力が完了しました。");
				lecList.add(lecture);
			}
		}
		return false;
	}

	@Override
	public void loginProfessor(List<HumanVO> userList, String userUinqNum) {
		// TODO Auto-generated method stub
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUniqNum().equals(userUinqNum)) {
				String pre = userList.get(i).getName();
				System.out.println("-------------------------------------------");
				System.out.println("　　　　　　               ようこそ!" + pre + "さん!");
				System.out.println("1.担当講義閲覧     2.講義入力     3.情報修正     4.ログアウト");
				System.out.println("-------------------------------------------");
			}
		}

	}

	@Override
	public boolean fixProfessor(List<LectureVO> lecList, List<HumanVO> userList,
			String userUinqNum) {
		if (lecList.size() == 0 ) {
			System.out.println("保存された値段がありません。");
		}
		for(int a=0; a<lecList.size(); a++) {
			if(!lecList.get(a).getUniqNum().equals(userUinqNum) && lecList.size() >=1) {
				checkNo++;
			}
		}
		if (checkNo > 0) {
			System.out.println("保存された値段がありません。");
		} else {
		}
		for (int i = 0; i < lecList.size(); i++) {
			if (lecList.get(i).getUniqNum().equals(userUinqNum)) {
				if (lecList.get(i).getOk() == 1) {
					intch = Integer.toString(lecList.get(i).getOk());
					intchN = intch;
					intchN = "承認待ち";
				}
				if (lecList.get(i).getOk() == 2) {
					intch = Integer.toString(lecList.get(i).getOk());
					intchN = intch;
					intchN = "承認完了";
				}
				System.out.println(plusenumber + "." + " 講義名 : " + lecList.get(i).getLectureName() + "  担当者 : "
						+ lecList.get(i).getProfessor() + "  単位 : " + lecList.get(i).getScore() + "  OK : " + intchN);
				plusenumber++;
				
			}
			//preList[i] = plusenumber;
		}
		System.out.println("원하시는 강의 교수를 선택해주세요 ");
		repreNumber = sc.nextInt();
		if(plusenumber == repreNumber ) {
			System.out.println(plusenumber);
			
		}
		
	
		
		
		
		/*System.out.println("このまま会員登録を進めましょうか。 (Y/N)");
		String check = sc.nextLine();
		if (check.equals("y") || check.equals("Y")) {
			for (int a = 0; a < lecList.size(); a++) {
				if (lecList.get(a).getUniqNum().equals(personnel.getUniqNum()) && lecList.get(a).getPersonnel() == personnel.getPersonnel()) {
					fixCheck = 0;

				} else {
					for (int i = 0; i < userList.size(); i++) {
						if (userUinqNum.equals(lecList.get(i).getUniqNum()) && lecList.get(i).getPersonnel() != personnel.getPersonnel()) {
							fixCheck = 1;
							listNum = i;

						}
					}
				}
			}
			if (fixCheck == 0) {
				System.out.println("同じ名前があります。");
				System.out.println("修正を失敗しました。");
				checkNum = 1;
			}
			if (fixCheck == 1) {
				lecList.set(listNum, personnel);
				System.out.println("修正が完了しました。");
				System.out.println("またログインしてください。");
				checkNum = 2;
			}
		}*/
		return true;
	}

	public int getCheckNum() {
		// TODO Auto-generated method stub
		return checkNum;
	}

}