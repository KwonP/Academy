package com.ojt.nexture.www.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.StudentVO;

public class StudentManagerClass implements StudentManager {

	Scanner sc = new Scanner(System.in);
	List<HumanVO> userList = new ArrayList<>();
	List<StudentVO> studentList = new ArrayList<>();

	@Override
	public boolean joinStudent() {
		
		String name = inputString("이름: ");
		int age = inputInt("나이: ");
		String password = inputString("비밀번호: ");
		String phoneNum = inputString("핸드폰 번호: ");
		String major = inputString("전공: ");
		String student_Num = inputString("학번: ");
		
		studentList.add(new StudentVO(name, age, password, phoneNum, major, student_Num));
		
		for(int i=0; i<studentList.size(); i++) {
			System.out.println(studentList.get(i));
		}
		return false;

	}

	@Override
	public HumanVO loginStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean leadingStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fixStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	//String값 입력
	private String inputString(String msg) {
		System.out.println(msg);
		return sc.next();
	}
	
	//int값 입력
	private int inputInt(String msg) {
		System.out.println(msg);
		return sc.nextInt();
	}
	
	//중복체크
	private HumanVO findId(String phoneNum) {
		return null;
	}


	

}
