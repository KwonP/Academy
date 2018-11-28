/*
	강의등록, 가입,정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public interface StaffManager {

	public void logInStaff(String userPassword, String userUinqNum);
	// 로그인

	public boolean joinProfessor(List<HumanVO> userList, HumanVO human);
	// 교수 등록

	public boolean joinStudent(List<HumanVO> userList, HumanVO human);
	// 학생 등록

	public boolean accessClass(List<LectureVO> lecList);
	// 강의승인

	public boolean viewAllClass(List<LectureVO> lecList);
	// 전체강의일람
}
