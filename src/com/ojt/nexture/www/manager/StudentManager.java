/*
	강의목록열람, 가입,정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.StudentVO;

public interface StudentManager {

	// 로그인
	public HumanVO loginStudent();

	// 강의목록열람
	public boolean leadingStudent();

	// 정보수정
	public boolean fixStudent();

	// 탈퇴
	public boolean deleteStudent();

	// 회원가입
	boolean joinStudent(List<HumanVO> list, StudentVO member);

}
