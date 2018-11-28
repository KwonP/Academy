/*
	강의목록열람, 가입,정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public interface StudentManager {

	// 로그인
	public void loginStudent(List<HumanVO> userList, String uniqNum, String password);

	// 강의목록열람
	public boolean leadingStudent(List<LectureVO> lecList);

	// 정보수정
	public boolean fixStudent(List<HumanVO> userList, HumanVO human, String userPhoneNum);

	// 탈퇴
	public boolean deleteStudent(List<HumanVO> userList,String userPhoneNum);

	// 회원가입
	boolean joinStudent(List<HumanVO> list, HumanVO human);

}
