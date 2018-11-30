package com.ojt.nexture.www.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.entity.ProfessorVO;
import com.ojt.nexture.www.entity.StudentVO;
import com.ojt.nexture.www.managerImpl.StaffManagerImpl;
import com.ojt.nexture.www.managerImpl.ProfessorManagerImpl;
import com.ojt.nexture.www.managerImpl.StudentManagerImpl;

public class AcademyUI {

	Scanner sc = new Scanner(System.in);
	List<HumanVO> userList = new ArrayList<>();
	List<LectureVO> lecList = new ArrayList<>();
	List<String[]> classStudent = new ArrayList<>();

	HumanVO human = null;
	ProfessorManagerImpl professor = new ProfessorManagerImpl();
	StudentManagerImpl student = new StudentManagerImpl();
	StaffManagerImpl staff = new StaffManagerImpl();

	String uniqNum;
	int type = 0; // 1은 스태프, 2는 교수, 3은 학생
	String name;
	int age = 0;
	String password;
	String phoneNum;
	String department;
	String major;
	String student_Num;
	int score, personnel;

	int logInCheck, accessCount, accessNum, temp;
	int uniqNo = 0;
	int accessCheckNum = 1;
	List<Integer> accessCheck;

	List<Integer> request = new ArrayList<>();
	List<Integer> cancle = new ArrayList<>();

	public AcademyUI() {
		boolean flag = true;
		// メインメニュー表示するためのループ文
		while (flag) {
			menu();
			logInCheck = 0;

			int choice = 0;
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				missMatchExCler();
				choice = -1;
			}

			switch (choice) {
			case 1:
				String mainMenu = "2";
				Loop1: do { // 로그인 실패했을 시 1/2 선택지에 따라 메인메뉴로 갈 지 다시 로그인 화면으로 갈지 선택하기 위한 반복문
					System.out.println("会員でログインします。");
					String userUinqNum = inputString("会員番号 : ");
					String userPassword = inputString("パスワード : ");
					for (int i = 0; i < userList.size(); i++) {
						if (userPassword.equals(userList.get(i).getPassword())
								&& userUinqNum.equals(userList.get(i).getUniqNum())) {
							logInCheck = userList.get(i).getType();
						}
					}
					if (userUinqNum.equals("00000") && userPassword.equals("12345")) {
						logInCheck = 1;
					}
					if (logInCheck == 1) { // 스태프 로그인

						staff.logInStaff(userPassword, userUinqNum);
						int staffFlagNum = 0;

						Loop2: do {// 각 메뉴 실행 후 main이 아닌 로그인 되어있는 창으로 오기 위한 분기점

							int flagStaff = 0;

							try {
								flagStaff = sc.nextInt();
							} catch (Exception e) {
								missMatchExCler();
								flagStaff = 0;
							}

							switch (flagStaff) {
							case 1: // 유저등록
								System.out.println("1.教授登録      2.学生登録");
								int addUser;
								addUser = inputInt("");
								switch (addUser) {
								case 1:
									System.out.println("情報を入力してください。");

									type = 2;
									name = inputString("名前 : ");
									do {
										age = inputInt("年齢 : ");
									} while (age == 0);
									password = inputString("パスワード : ");
									phoneNum = inputString("電話番号 : ");
									department = inputString("所属学部 : ");
									System.out.println("=================================================");
									System.out.println("名前 : " + name + ",    年齢 : " + age + ",    電話番号 : " + phoneNum
											+ ",    所属学部 :" + department);
									System.out.println("=================================================");
									System.out.println("このまま会員登録を進めましょうか。 (Y/N)");
									String check = null;

									check = sc.next();
									if (check.equals("y") || check.equals("Y")) {
										uniqNum = String.format("%04d", uniqNo);
										human = new ProfessorVO(name, age, password, phoneNum, type, uniqNum,
												department);
										staff.joinProfessor(userList, human);
										if (staff.getcheckPhoneNum() == 0) {
											uniqNo++;
											staff.logInStaff(userPassword, userUinqNum);
											staffFlagNum = 0;
											continue Loop2;
										}
										if (staff.getcheckPhoneNum() == 1) {
											staff.logInStaff(userPassword, userUinqNum);
											staffFlagNum = 0;
											continue Loop2;
										}
									}
									if (check.equals("n") || check.equals("N")) {
										System.out.println("入力をキャンセルしました。");
										staff.logInStaff(userPassword, userUinqNum);
										staffFlagNum = 0;
										continue Loop2;
									} else {
										System.out.println("また入力してください。");
										staff.logInStaff(userPassword, userUinqNum);
										staffFlagNum = 0;
										continue Loop2;
									}
								case 2:
									System.out.println("情報を入力してください。");

									type = 3;
									name = inputString("名前：");
									password = inputString("パスワード");
									do {
										age = inputInt("年齢 : ");
									} while (age == 0);
									phoneNum = inputString("電話番号：");
									major = inputString("専攻：");
									student_Num = inputString("学番：");

									System.out.println("=================================================");
									System.out.println("名前： " + name + "、    年齢： " + age + "、    電話： " + phoneNum
											+ "、    専攻： " + major + "、    学番： " + student_Num);
									System.out.println("=================================================");
									System.out.println("このまま会員登録を進めましょうか。(Y/N)");

									check = null;

									check = sc.next();
									if (check.equals("y") || check.equals("Y")) {
										uniqNum = String.format("%04d", uniqNo);
										human = new StudentVO(name, age, password, phoneNum, type, uniqNum, major,
												student_Num);
										staff.joinStudent(userList, human);
										if (staff.getcheckPhoneNum() == 0) {
											uniqNo++;
											staff.logInStaff(userPassword, userUinqNum);
											staffFlagNum = 0;
											continue Loop2;
										}
										if (staff.getcheckPhoneNum() == 1) {
											staff.logInStaff(userPassword, userUinqNum);
											staffFlagNum = 0;
											continue Loop2;
										}
									}
									if (check.equals("n") || check.equals("N")) {
										System.out.println("入力をキャンセルしました。");
										staff.logInStaff(userPassword, userUinqNum);
										staffFlagNum = 0;
										continue Loop2;
									} else {
										System.out.println("また入力してください。");
										staff.logInStaff(userPassword, userUinqNum);
										staffFlagNum = 0;
										continue Loop2;
									}
								default:
								}
								break;
							case 2: // 강의승인
								int loop4Check = 1;
								accessCheck = new ArrayList<>();
								accessCount = 0;
								Loop4: do {
									accessCheckNum = 1;
									for (int a = 0; a < lecList.size(); a++) {
										if (lecList.get(a).getOk() == 1) {
											accessCount++;
										}
									}

									if (accessCount > 0) {
										for (int a = 0; a < lecList.size(); a++) {
											if (lecList.get(a).getOk() == 1) {
												System.out.println(
														accessCheckNum + ". 講義名 : " + lecList.get(a).getLectureName()
																+ ",     担当者 : " + lecList.get(a).getProfessor()
																+ ",     単位 : " + lecList.get(a).getScore()
																+ ",     申請可能人数 : " + lecList.get(a).getPersonnel());
												accessCheck.add(a);
												accessCheckNum++;
											}
										}
										accessNum = inputInt("承認しよとする講義の番号を選んでください。(0番 : メニュー画面)");
									} else {
										System.out.println("承認待ち中の講義がないです。");
										staff.logInStaff(userPassword, userUinqNum);
										staffFlagNum = 0;
										continue Loop2;
									}
									if (accessNum == 0) {
										staff.logInStaff(userPassword, userUinqNum);
										staffFlagNum = 0;
										continue Loop2;
									}
									String accessString = inputString(accessNum + "の講義を承認しますか。(Y/N)");
									if (accessString.equals("y") || accessString.equals("Y")) {
										staff.accessClass(lecList, accessNum, accessCheck);
										staff.logInStaff(userPassword, userUinqNum);
										staffFlagNum = 0;
										continue Loop2;
									} else {
										loop4Check = 0;
										continue Loop4;
									}
								} while (loop4Check == 0);
							case 3: // 전체강의목록
								int loop5Check = 1;
								Loop5: do {
									staff.viewAllClass(lecList, classStudent);
									if (staff.getCheckClassListNum() == 1) {
										staff.logInStaff(userPassword, userUinqNum);
										staffFlagNum = 0;
										continue Loop2;
									} else {
										int viewCheck = inputInt("(0番 :メニュー画面)");
										if (viewCheck == 0) {
											staff.logInStaff(userPassword, userUinqNum);
											staffFlagNum = 0;
											continue Loop2;
										} else {
											System.out.println("正しい番号を入力してください。");
											loop5Check = 0;
											continue Loop5;
										}
									}
								} while (loop5Check == 0);
							case 4: // 로그아웃
								System.out.println("ログアウトしました。");
								logInCheck = 0;
								break;
							}
							break Loop1;
						} while (staffFlagNum == 0);
					} else if (logInCheck == 2) {
						professor.loginProfessor(userList, userUinqNum);
						int PrCheckNum = 0;
						String fixcheck;
						LP1: do {
							int check = 0;
							try {
								check = sc.nextInt();
							} catch (Exception e) {
								missMatchExCler();
							}
							switch (check) {
							case 1:
								System.out.println("担当講義閲覧");
								professor.pj_Join(userList, lecList, userUinqNum);
								System.out.println("");
								professor.loginProfessor(userList, userUinqNum);
								continue LP1;
							case 2:
								String flagStaff2 = "2";
								do {

									System.out.println("講義を入力してください。");
									LectureVO lecture = null;
									String lectNm = inputString("講義名 : ");
									do {
										score = inputInt("単位 : ");
									} while (score == 0);
									do {
										personnel = inputInt("学生数 :");
									} while (personnel == 0);
									int ok = 1;
									System.out.println("------------------------------------------------");
									System.out.println(
											"　　　 講義名 : " + lectNm + ",   単位 : " + score + ",   学生数 : " + personnel);
									System.out.println("------------------------------------------------");
									System.out.println("このまま会員登録を進めましょうか。 (Y/N)");
									String lectureCheck = null;
									lectureCheck = sc.next();
									if (lectureCheck.equals("y") || lectureCheck.equals("Y")) {
										for (int i = 0; i < userList.size(); i++) {
											if (userList.get(i).getUniqNum().equals(userUinqNum)) {
												String preName = userList.get(i).getName();
												String pre = preName;
												lecture = new LectureVO(lectNm, pre, score, personnel, userUinqNum, ok);
											}
										}
										professor.addClass(lecList, lecture, userList, userUinqNum);
										professor.loginProfessor(userList, userUinqNum);
										flagStaff2 = "0";
										continue LP1;
									}
									if (lectureCheck.equals("n") || lectureCheck.equals("N")) {
										System.out.println("キャンセルされました。");
										professor.loginProfessor(userList, userUinqNum);
										continue LP1;
									} else {
										System.out.println("また入力してください。");

									}
								} while (flagStaff2.equals("2"));
								break LP1;
							case 3:
								do {
									professor.fixProfessor(lecList, userList, userUinqNum);
								} while (professor.getCheckNum() == 0);
								professor.loginProfessor(userList, userUinqNum);
								continue LP1;

							case 4:
								System.out.println("ログアウトしました。");
								break;
							default:
								System.out.println("誤入力しました。");
								continue LP1;
							}
							break Loop1;
						} while (PrCheckNum == 0);

					} else if (logInCheck == 3) { // 김혜원

						int studentLoopCheck1 = 1;
						int Student_S = 0;
						String check = null;

						studentLoop1: do { // 학생 로그인 화면 부분
							student.loginStudent(userList, userUinqNum, userPassword);

							try {
								Student_S = sc.nextInt();
							} catch (InputMismatchException e) {
								missMatchExCler();
							}

							switch (Student_S) {
							case 1:

								int lectNum1 = 1;

								student.allLeadingStudent(lecList, lectNum1);

								int lectNumCheck1 = inputInt("");

								if (lectNumCheck1 == 0) {
									studentLoopCheck1 = 0;
									continue studentLoop1;
								} else {
									System.out.println("このまま申請しますか。 (Y/N)");

									check = sc.next();

									if (check.equals("y") || check.equals("Y")) {
										student.requestStudent(classStudent, lecList, userUinqNum, lectNumCheck1);
										studentLoopCheck1 = 0;
										continue studentLoop1;
									}
									if (check.equals("n") || check.equals("N")) {
										System.out.println("入力をキャンセルしました。");
										studentLoopCheck1 = 0;
										continue studentLoop1;
									}

								}

							case 2:

								int lectNum2 = 1;

								student.leadingStudent(classStudent, lecList, userUinqNum, lectNum2);

								int lectNumCheck2 = inputInt("");

								System.out.println("");

								if (lectNumCheck2 == 0) {
									studentLoopCheck1 = 0;
									continue studentLoop1;
								} else {

									System.out.println("このままキャンセルしますか。 (Y/N)");

									check = sc.next();
									if (check.equals("y") || check.equals("Y")) {

										student.cancleStudent(classStudent, lecList, userUinqNum, lectNumCheck2);

										studentLoopCheck1 = 0;
										continue studentLoop1;
									}
									if (check.equals("n") || check.equals("N")) {
										System.out.println("入力をキャンセルしました。");
										studentLoopCheck1 = 0;
										continue studentLoop1;
									}

								}

							case 3:
								System.out.println("ログアウトしました。");
								continue Loop1;
							}
						} while (studentLoopCheck1 == 0);
					} else {
						logInfail();
						mainMenu = inputString("");
						continue Loop1;
					}
					break Loop1;
				} while (mainMenu.equals("2"));
				break;
			case -1:
				break;
			default:
				System.out.println("正しいメニューを選択してください。");
				break;
			}

		}

	}

	public void menu() {
		System.out.println("==============アカデミー管理システム=============== \n");
		System.out.println("\t\t1．ログイン  \n");
		System.out.println("============================================");
	}

	public void typeSelMenu() {
		System.out.println("==============会員タイプ選択============= \n１．教授　２．学生　３．スタッフ　４．取り消し"
				+ "\n======================================");
	}

	public void missMatchExCler() {
		sc.nextLine();
		System.out.println("メニュー選択は数字を入力してください。");
	}

	public void logInfail() {
		System.out.println("間違った情報です。名前とパスワードを確認してください。");
		System.out.println("メイン画面に : 1        　    再入力 : 2 ");
	}

	public String inputString(String message) {
		System.out.println(message);
		String inputString = null;
		inputString = sc.next();
		return inputString;
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

	public List<HumanVO> getUserList() {
		return userList;
	}

	public void setUserList(List<HumanVO> userList) {
		this.userList = userList;
	}

	public List<LectureVO> getLecList() {
		return lecList;
	}

	public void setLecList(List<LectureVO> lecList) {
		this.lecList = lecList;
	}

}
