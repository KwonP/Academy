package com.ojt.nexture.www.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.ProfessorVO;
import com.ojt.nexture.www.entity.StaffVO;
import com.ojt.nexture.www.entity.StudentVO;
import com.ojt.nexture.www.manager.ManagerClass;
import com.ojt.nexture.www.manager.StaffManager;

public class AcademyUI {
	private String doubleLine = "=========================================================";
	private String singleLine = "---------------------------------------------------------";
	private String listFormat = "%10s%10s%10s%20s%20s\n";
	private String personName, personPassword;

	Scanner scanner = new Scanner(System.in);
	StaffManager manager = new ManagerClass(10);

	public AcademyUI() {
		while (true) {
			printTitle();
			printSubTitle("메 인 메 뉴");
			int mainTask = inputFromList(new String[] { " ", "회원가입", "로그인" });
			switch (mainTask) {
			case 1:
				insertPerson();
				break;
			case 2:
				logIn();
				break;
			default:
				System.out.println("뭘 입력한거니?");
				break;
			}

		} // while
	} // TUI()

	public void insertPerson() {
		while (true) {
			printTitle();
			printSubTitle("직 업 선 택");
			int occupation = inputFromList(new String[] { "", "학생", "교사", "임직원", "이전메뉴" });
			if (occupation == 4) {
				return;
			}

			HumanVO newPerson = null;

			String name = inputString(" 이름 : ");
			int age = inputInt(" 나이 :");
			String password = inputString(" 비밀번호 : ");
			int personId = inputInt(" 주민번호 :");
			int code;

			String additionalInfo = "";

			switch (occupation) {
			case 1:
				code = 1; //학생 = 1
				additionalInfo = inputString(" 학번 : ");
				newPerson = new StudentVO(name, age, personId, password, additionalInfo, code);
				break;
			case 2:
				code = 2; //교수 =2
				additionalInfo = inputString(" 교과목 : ");
				newPerson = new ProfessorVO(name, age, personId, password, additionalInfo, code);
				break;
			case 3:
				code = 3; //staff=3
				additionalInfo = inputString(" 부서 : ");
				newPerson = new StaffVO(name, age, personId, password, additionalInfo, code);
				break;
			} // switch
			System.out.println("====================================== \n");
			System.out.println("이름 : " + name + ",    나이 : " + age + ",    비밀번호 : " + password);
			System.out.println("======================================");
			System.out.print("ここまま会員登録を進めましょうか。");
			String check = inputString("(Y/N)");
			if (check.equals("y")) {
				if (manager.insertPerson(newPerson)) {
					printSystemMessage("등록되었습니다.", true);
				} else {
					printSystemMessage("등록할 수 없습니다.", true);
				}
			} else {

			}
		} // while
	} // insertPerson()

	public void deletePerson() {
		while (true) {
			printTitle();
			printSubTitle(" 삭 제 하 기");
			int personId = inputInt(" 삭제할 사람의 주민번호를 입력하여 주십시오. (0 : 이전메뉴) ");
			if (personId == 0) {
				return;
			}

			if (manager.deletePerson(personId)) {
				printSystemMessage("삭제되었습니다.", true);
			} else {
				printSystemMessage("존재하는 ID가 없습니다.", true);
			}
		}
	} // deletePerson()

	public void logIn() {

		personName = inputString(" 이름 : ");
		System.out.println(personName);
		personPassword = inputString(" 비밀번호 : ");
		System.out.println(personPassword);
		HumanVO persons = manager.logIn(personName, personPassword);
		printTitle();
		printSubTitle(" 로그인");
		if (persons != null) {
//			printSystemMessage("로그인에 성공했습니다.", true);
			mainLogin();
		} else {
			printSystemMessage("존재하는 ID가 없습니다.", true);
		}

	} // selectPerson()

	public int inputFromList(String[] lists) {
		int result = 0;
		for (int i = 1; i < lists.length; i++) {
			System.out.printf(" %d. %s\n", i, lists[i]);
		}
		System.out.println(singleLine);
		while (true) {
			result = inputInt("무엇을 하시겠습니까 ?");
			if (result > lists.length - 1) {
				printSystemMessage("잘못된 번호입니다.");
				continue;
			}
			return result;
		}

	} // inputFromList

	public String personToString(HumanVO person) {
		StringTokenizer st = new StringTokenizer(person.toString(), "|");
		return String.format(listFormat, st.nextToken(), st.nextToken(), st.nextToken(), st.nextToken(),
				st.nextToken());
	}

	public int inputInt(String inputMessage) {
		while (true) {
			try {
				System.out.print(inputMessage + " ");
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				printSystemMessage("숫자를 입력하여 주십시오.");
				scanner.next();
			} // try
		} // while
	} // inputInt()

	public String inputString(String inputMessage) {
		System.out.print(inputMessage);
		return scanner.next();
	} // inputString()

	public void printTitle() {
		clearScreen();
		System.out.println(doubleLine);
		System.out.println(" 학 사 관 리 ");
		System.out.println(doubleLine);
	} // printTitle()

	public void printSubTitle(String subTitle) {
		System.out.println(singleLine);
		System.out.println(" " + subTitle);
		System.out.println(singleLine);
	} // printSubTitle

	public void printSystemMessage(String message) {
		System.out.println(" System : " + message);
	}

	public void printSystemMessage(String message, boolean isPause) {
		System.out.println(singleLine);
		printSystemMessage(message);
		System.out.println(singleLine);
		if (isPause) {
			System.out.println(" 계속하시려면 아무거나 입력하여 주십시오.");
			// scanner.skip("[\\n\\r]");
			scanner.next();
			// System.out.println("DEBUG @22222");
		}
	}
	
	public void mainLogin() {
		while (true) {
			System.out.println(" \n\n" + "\t\tようこそ！" + personName + "様!\n\n");
			int mainTask = inputFromList(new String[] { " ", "担当講義一覧", "情報修正 ", "退会", "ログアウト" });
			if (mainTask == 4) {
				printSystemMessage("로그아웃 되었습니다.", true);
				return;
			}
			switch (mainTask) {
			case 1:
				insertPerson();
				break;
			case 2:
				updatePerson();
				break;
			case 3:
				deletePerson();
				break;
			default:
				System.out.println("뭘 입력한거니?");
				break;
			}

		} // while
	} // TUI()

	private void updatePerson() {
		// TODO Auto-generated method stub
		
	}

	private void logOut() {
		// TODO Auto-generated method stub
		
	}

	public void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	} // clearScreen

}
