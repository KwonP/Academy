/*
	담당강의열람, 가입, 정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public interface ProfessorManager {

	public void pj_Join(List<HumanVO> userList,List<LectureVO> lecList,String userUinqNum);// 担当講義閲覧

	public boolean fixProfessor(List<LectureVO> lecList, LectureVO lecture, List<HumanVO> userList, String userUinqNum);// 情報修正

	public void loginProfessor(List<HumanVO> userList,String userUinqNum);// ログイン

	public boolean addClass(List<LectureVO> lecList, LectureVO lecture, List<HumanVO> userList,String userUinqNum);// 講義入力
}
