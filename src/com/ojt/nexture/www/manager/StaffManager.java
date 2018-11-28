/*
	강의등록, 가입,정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public interface StaffManager {

	public void logInStaff(String userName, String userPassword, String userUinqNum);
	// 로그인

	public boolean fixStaff(List<HumanVO> userList, HumanVO human, String userPhoneNum);
	// 정보수정

	public boolean joinStaff(List<HumanVO> userList, HumanVO human);
	// 가입
	
	public boolean joinProfessor(List<HumanVO> userList, HumanVO human);
	// 가입
	
	public boolean joinStudent(List<HumanVO> userList, HumanVO human);
	// 가입

	public boolean deleteStaff(List<HumanVO> userList, String userPhoneNum, String deleteCheck);
	// 탈퇴

	public boolean addClass(List<LectureVO> lecList, LectureVO lecture, List<HumanVO> userList);
	// 강의등록
}
