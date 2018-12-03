package com.ojt.nexture.www.managerImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.manager.ProfessorManager;

public class ProfessorManagerImpl implements ProfessorManager {
	Scanner sc = new Scanner(System.in);
	int checkNo, intNumCheck;
	int fixCheck, listNum;
	int checkNum = 0;
	int professorCheck = 0;
	String repre = null;
	int repersonnel;
	int plusenumber = 1;
	String prename;
	String intch;
	String intchN;
	int tr;
	int lectListnumber;
	int lectListnumber1;
	int lectListnumber2;
	int lectListnumber3;
	String newlecList;
	ArrayList<String> checkStudent;
	List<Integer> intNum;

	@Override
	public void pj_Join(List<String[]> classStudent, List<HumanVO> userList, List<LectureVO> lecList,
			String userUinqNum) {
		checkNo = 0;
		lectListnumber = 0;
		lectListnumber1 = 0;
		lectListnumber2 = 0;
		lectListnumber3 = 0;
		plusenumber = 1;
		tr = 0;
		checkStudent = new ArrayList<>();
		intNum = new ArrayList<>();
		do {
			for (int a = 0; a < lecList.size(); a++) {
				if (lecList.get(a).getUniqNum().equals(userUinqNum)) {
					checkNo++;
				}
			}
			if (checkNo == 0) {
				System.out.println("保存された値段がありません。 ");
			} else {
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
								+ lecList.get(i).getProfessor() + "  学生数 : " + lecList.get(i).getPersonnel() + "  単位 : "
								+ lecList.get(i).getScore() + "  承認可否 : " + intchN);
						plusenumber++;
					}

				}
			}
			tr = 1;
		} while (tr == 0);

		if (plusenumber == 1) {
			checkNum = 1;
		} else {
			System.out.println("講義科目を入力してください。帰る時には0番を書いてください。 ");
			repre = inputString("選択:0 , 講義科目:  ");
			if (repre.equals("0")) {
				checkNum = 1;
			} else {
				for (int z = 0; z < lecList.size(); z++) {
					if (lecList.get(z).getLectureName().equals(repre)) { // 입력한 강의 이름이 강의 목록에 있는지 체크
						lectListnumber = 1;
					}

				}
				if (lectListnumber == 0) { // 입력한 강의 이름이 강의 목록에 없다면
					System.out.println("入力され講義情報がありません");
				} else if (lectListnumber == 1) { // 입력한 강의 이름이 강의 목록에 있다면

					for (int a = 0; a < classStudent.size(); a++) {
						if (classStudent.get(a)[1].equals(repre)) { // 입력한 강의를 신청한 학생이 있는지 체크
							checkStudent.add(classStudent.get(a)[0]); // 입력한 강의를 신청한 학생이 있다면 checkStudent에 그 학생들의
																		// uniqNum 저장
							lectListnumber1 = 1;
						}
					}
					if (lectListnumber1 == 0) { // 입력한 강의를 신청한 학생이 없다면
						System.out.println("入力され学生情報がありません。");
					} else if (lectListnumber1 == 1) { // 입력한 강의를 신청한 학생이 있다면
						lectListnumber2 = 0;
						for (int c = 0; c < checkStudent.size(); c++) {
							for (int x = 0; x < userList.size(); x++) {
								if (checkStudent.get(c).equals(userList.get(x).getUniqNum())) { // 신청한 학생의 uniqNum를
									intNum.add(x); // userList에서 체크
									lectListnumber2 = 1;
								}
							}
						}
						if (lectListnumber2 == 1) {
							for (int i = 0; i < intNum.size(); i++) {
								if (lecList.get(intNum.get(i)).getUniqNum().equals(userUinqNum)) {
									lectListnumber3 = 1;
								}
							}
							if (lectListnumber3 == 1) {
								for (int a = 0; a < intNum.size(); a++) {
									System.out.println("学生の名前：  " + userList.get(intNum.get(a)).getName());
								}
							} else {
								System.out.println("해당 교수의 강의가 아닙니다.");
							}
						}

					}
				}
				checkNum = 1;
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
	public boolean fixProfessor(List<LectureVO> lecList, List<HumanVO> userList, String userUinqNum) {
		tr = 0;
		plusenumber = 1;
		checkNum = 0;
		do {
			for (int a = 0; a < lecList.size(); a++) {
				if (lecList.get(a).getUniqNum().equals(userUinqNum)) {
					checkNo++;
				}
			}
			if (checkNo == 0) {
				System.out.println("保存された値段がありません。");
			} else {
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
								+ lecList.get(i).getProfessor() + "  学生数 : " + lecList.get(i).getPersonnel() + "  単位 : "
								+ lecList.get(i).getScore() + "  承認可否 : " + intchN);
						plusenumber++;
					}

				}
			}
			tr = 1;

		} while (tr == 0);

		if (plusenumber == 1) {
			checkNum = 1;
		} else {
			System.out.println("変更しようとする講義科目を入力してください。帰る時には0番を書いてください。 ");
			repre = inputString("選択:0 , 講義科目: ");
			int q = 0;
			String w = Integer.toString(q);
			if (repre.equals(w)) {
				checkNum = 1;
			} else {
				for (int a = 0; a < lecList.size(); a++) {
					if (lecList.get(a).getLectureName().equals(repre)) {
						do {
							repersonnel = inputInt("学生数 :");
						} while (repersonnel == 0);
						checkNum = 1;
						lecList.get(a).setPersonnel(repersonnel);
						System.out.println("修正完了しました。");
					}
				}
			}
		}
		return false;
	}

	public int getCheckNum() {
		return checkNum;
	}

	public int inputInt(String message) {
		System.out.println(message);
		int inputInt = 0;
		try {
			inputInt = sc.nextInt();
		} catch (InputMismatchException e) {
			sc = new Scanner(System.in);
			System.out.println("誤入力しました。");
		}
		return inputInt;
	}

	public String inputString(String message) {
		System.out.println(message);
		String inputString = null;
		inputString = sc.next();
		return inputString;
	}
}