package com.ojt.nexture.www.ui;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.entity.ProfessorVO;
import com.ojt.nexture.www.entity.StudentVO;
import com.ojt.nexture.www.manager.ProfessorManagerImpl;
import com.ojt.nexture.www.manager.StaffManagerImpl;
import com.ojt.nexture.www.manager.StudentManagerClass;

public class AcademyUI {

	Scanner sc = new Scanner(System.in);
	List<HumanVO> userList = new ArrayList<>();
	List<LectureVO> lecList = new ArrayList<>();

	HumanVO human = null;
	ProfessorManagerImpl professor = new ProfessorManagerImpl();
	StudentManagerClass student = new StudentManagerClass();
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

	int logInCheck;
	int uniqNo = 0;

	public AcademyUI() {
		boolean flag = true;
		// メインメニュー表示するためのループ文
		while (flag) {
			menu();

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
									System.out.println("----------------------------------------------------------");
									System.out.println("名前 : " + name + ",   年齢 : " + age + ",   電話番号 : " + phoneNum
											+ ",   所属学部 :" + department);
									System.out.println("----------------------------------------------------------");
									System.out.println("このまま会員登録を進めましょうか。 (Y/N)");
									String check = null;

									check = sc.next();
									if (check.equals("y") || check.equals("Y")) {
										uniqNum = String.format("%04d", uniqNo);
										human = new ProfessorVO(name, age, password, phoneNum, type, uniqNum,
												department);
										staff.joinProfessor(userList, human);
										if (staff.getCheckNum() == 0) {
											uniqNo++;
											staff.logInStaff(userPassword, userUinqNum);
											staffFlagNum = 0;
											continue Loop2;
										}
										if (staff.getCheckNum() == 1) {
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

									System.out.println("======================================");
									System.out.println("名前：" + name + "、年齢：" + age + "、電話：" + phoneNum + "、専攻：" + major
											+ "、学番：" + student_Num);
									System.out.println("======================================");
									System.out.println("このまま会員登録を進めましょうか。(Y/N)");

									check = null;

									check = sc.next();
									if (check.equals("y") || check.equals("Y")) {
										uniqNum = String.format("%04d", uniqNo);
										human = new StudentVO(name, age, password, phoneNum, type, uniqNum, major,
												student_Num);
										staff.joinStudent(userList, human);
										if (staff.getCheckNum() == 0) {
											uniqNo++;
											staff.logInStaff(userPassword, userUinqNum);
											staffFlagNum = 0;
											continue Loop2;
										}
										if (staff.getCheckNum() == 1) {
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
								/*
								 * String flagStaff2 = "2"; Loop3: do { System.out.println("講義を入力してください。");
								 * LectureVO lecture = null; String lectureName = inputString("講義名 : "); String
								 * professor = inputString("担当者 : "); String score = inputString("単位 : ");
								 * 
								 * System.out.println("------------------------------------------------");
								 * System.out.println("                                    講義名 : " + lectureName
								 * + ",   担当者 : " + professor + ",   単位 : " + score);
								 * System.out.println("------------------------------------------------");
								 * System.out.println("このまま会員登録を進めましょうか。 (Y/N)"); String lectureCheck = null;
								 * 
								 * lectureCheck = sc.next(); if (lectureCheck.equals("y") ||
								 * lectureCheck.equals("Y")) { lecture = new LectureVO(lectureName, professor,
								 * score); staff.addClass(lecList, lecture, userList);
								 * staff.logInStaff(userName); flagStaff2 = "0"; continue Loop2; } else {
								 * System.out.println("また入力してください。"); } } while (flagStaff2.equals("2")); break
								 * Loop2;
								 */
							case 3: // 전체강의목록
								/*
								 * System.out.println("情報を入力してください。");
								 * 
								 * name = inputString("名前 : "); do { age = inputInt("年齢 : "); } while (age ==
								 * 0); // age 값이 scan 받을 때 nextInt를 사용하는데, 이때 문자, 혹은 0을 입력할 시 제대로 입력 받을 때 까지
								 * 반복하도록 하는 문 password = inputString("パスワード : "); phoneNum =
								 * inputString("電話番号 : "); department = inputString("所属学部 : ");
								 * System.out.println("修正しますか。 (Y/N)"); String check = null;
								 * 
								 * check = sc.next();
								 * 
								 * if (check.equals("y") || check.equals("Y")) { human = new StaffVO(name, age,
								 * password, phoneNum, department); staff.fixStaff(userList, human,
								 * userPhoneNum); if (staff.getCheckNum() == 1) { // 이미 존재하는 전화번호일 경우
								 * staff.logInStaff(userName); staffFlagNum = 0; continue Loop2; } if
								 * (staff.getCheckNum() == 2) { // 수정완료 break Loop2; } } else { // N를 눌렀을 경우
								 * System.out.println("キャンセルしました。"); staff.logInStaff(userName); staffFlagNum =
								 * 0; continue Loop2; }
								 */
							case 4: // 탈퇴
								/*
								 * String deleteCheck = inputString("本当に退会しますか。 (Y/N)");
								 * staff.deleteStaff(userList, userPhoneNum, deleteCheck); if
								 * (staff.getDeleteCheckFlag() == 1) { // n 누름 staff.logInStaff(userName);
								 * staffFlagNum = 0; continue Loop2; } if (staff.getDeleteCheckFlag() == 0) { //
								 * y 누름 staffFlagNum = 1; }
								 * 
								 * break;
								 */
							case 5: // 로그아웃
								System.out.println("ログアウトしました。");
								logInCheck = 0;
								break;
							}
							break Loop1;
						} while (staffFlagNum == 0);
					} else if (logInCheck == 1) {
						/*
						 * System.out.println("프로페서"); professor.loginProfessor(userName); int
						 * PrCheckNum = 0; String fixcheck; LP1: do { int check = 0; try { check =
						 * sc.nextInt(); } catch (Exception e) { missMatchExCler(); } switch (check) {
						 * case 1: System.out.println("担当講義閲覧"); professor.pj_Join(lecList, userName);
						 * professor.loginProfessor(userName); continue LP1; case 2:
						 * System.out.println("情報を入力してください。"); String flagStaff2 = "2"; do {
						 * System.out.println("講義を入力してください。"); LectureVO lecture = null; String lectNm =
						 * inputString("講義名 : "); String profe = inputString("担当者 : "); String score =
						 * inputString("単位 : "); int ovfull = inputInt("学生数");
						 * 
						 * 
						 * System.out.println("------------------------------------------------");
						 * System.out.println("                                    講義名 : " + lectNm +
						 * ",   担当者 : " + profe + ",   単位 : " + score + ",   学生数 : " + ovfull);
						 * System.out.println("------------------------------------------------");
						 * System.out.println("このまま会員登録を進めましょうか。 (Y/N)"); String lectureCheck = null;
						 * 
						 * lectureCheck = sc.next(); if (lectureCheck.equals("y") ||
						 * lectureCheck.equals("Y")) { lecture = new LectureVO(lectNm, profe, score);
						 * professor.addClass(lecList, lecture, userList,ovfull);
						 * professor.loginProfessor(userName); flagStaff2 = "0"; continue LP1; } else {
						 * System.out.println("また入力してください。"); } } while (flagStaff2.equals("2")); break
						 * LP1; case 3: System.out.println("情報を入力してください。"); name = inputString("名前 : ");
						 * do { age = inputInt("年齢 : "); } while (age == 0); // age 값이 scan 받을 때
						 * nextInt를 사용하는데, 이때 문자, 혹은 0을 입력할 시 제대로 입력 받을 때 까지 반복하도록 하는 문 password =
						 * inputString("パスワード : "); phoneNum = inputString("電話番号 : "); department =
						 * inputString("所属学部 : "); System.out.println("修正しますか。 (Y/N)"); fixcheck = null;
						 * 
						 * fixcheck = sc.next();
						 * 
						 * if (fixcheck.equals("y") || fixcheck.equals("Y")) { human = new
						 * ProfessorVO(name, age, password, phoneNum, department);
						 * professor.fixProfessor(userList, human, userPhoneNum); if
						 * (professor.getCheckNum() == 1) { // 이미 존재하는 전화번호일 경우
						 * professor.loginProfessor(userName); PrCheckNum = 0; continue LP1; } if
						 * (professor.getCheckNum() == 2) { // 수정완료 break LP1; } } else { // N를 눌렀을 경우
						 * System.out.println("キャンセルしました。"); professor.loginProfessor(userName);
						 * PrCheckNum = 0; continue LP1; } break; case 4:
						 * professor.deleteProfessor(userList, userPhoneNum); if
						 * (professor.getPrCheckNum() == 1) { // n 누름
						 * professor.loginProfessor(userName); PrCheckNum = 0; continue LP1; } if
						 * (professor.getPrCheckNum() == 0) { // y 누름 PrCheckNum = 1; } break; case 5:
						 * System.out.println("ログアウトしました。"); break; default:
						 * System.out.println("誤入力しました。"); continue LP1; } break Loop1; } while
						 * (PrCheckNum == 0);
						 */
					} else if (logInCheck == 2) {
						String userName;
						for(int i = 0; i < userList.size(); i++) {
							if(userList.get(i).getUniqNum().equals(userUinqNum))
								userName = userList.get(i).getName();
						}

						student.loginStudent();

						System.out.println(
								"----------------------------------------------------------------------------------");
						System.out.println("\t\t\t\t ようこそ！" + userName + "様！");
						System.out.println("\t1．講義リスト覧　　　2．情報修正　　　3．退会　　　4．ログアウト \n");
						System.out.println(
								"----------------------------------------------------------------------------------");

						int Student_S = 0;
						String check = null;

						try {
							Student_S = sc.nextInt();
						} catch (InputMismatchException e) {
							missMatchExCler();
						}

						switch (Student_S) {

						case 1:
							/*
							 * System.out.println("講義リスト一です。"); student.leadingStudent(lecList); break;
							 */
						case 2:
							/*
							 * System.out.println("情報を入力してください。");
							 * 
							 * name = inputString("名前："); password = inputString("パスワード"); do { age =
							 * inputInt("年齢 : "); } while (age == 0); phoneNum = inputString("電話番号："); major
							 * = inputString("専攻："); student_Num = inputString("学番：");
							 * 
							 * System.out.println("======================================");
							 * System.out.println("名前：" + name + "、年齢：" + age + "、電話：" + phoneNum + "、専攻：" +
							 * major + "、学番：" + student_Num);
							 * System.out.println("======================================");
							 * System.out.println("修正しますか。 (Y/N)");
							 * 
							 * check = null;
							 * 
							 * check = sc.next();
							 * 
							 * if (check.equals("y") || check.equals("Y")) { human = new StudentVO(name,
							 * age, password, phoneNum, major, student_Num); student.fixStudent(userList,
							 * human, userPhoneNum); } else { System.out.println("キャンセルしました。"); break; }
							 */
						case 3:
							/*
							 * System.out.println("탈퇴"); System.out.println("本当に退会しますか。 (Y/N)");
							 * 
							 * check = null;
							 * 
							 * check = sc.next(); if (check.equals("y") || check.equals("Y")) {
							 * student.deleteStudent(userList, userPhoneNum);
							 * System.out.println("退会が完了しました。"); break; } else { // 요우코소 부분으로 돌아가는 내용 }
							 * break;
							 */
						case 4:
							System.out.println("ログアウトしました。");
							logInCheck = 0;
							System.exit(0);
						}

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
