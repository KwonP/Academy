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

	// 전체강의목록열람 및 강의 신청
	public boolean allLeadingStudent(List<LectureVO> lecList, int lectNum1);
	public boolean requestStudent(List<String[]> classStudent, List<LectureVO> lecList, String userUinqNum, int lectNumCheck1);
	// 전체강의목록열람 및 강의 취소
	public boolean leadingStudent(List<String[]> classStudent, List<LectureVO> lecList, String userUinqNum, int lectNum2);
	public boolean cancleStudent(List<String[]> classStudent, List<LectureVO> lecList, String userUinqNum,
			int lectNumCheck2);

}
