/*
	담당강의열람, 가입, 정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public interface ProfessorManager {

	public void pj_Join(List<HumanVO> userList,List<LectureVO> lecList,String userUinqNum);// 担当講義閲覧

	public boolean fixProfessor(List<HumanVO> userList, HumanVO human, String userUinqNum);// 情報修正

	public boolean joinProfessor(List<HumanVO> userList, HumanVO human);//会員登録

	public void loginProfessor(List<HumanVO> userList,String userUinqNum,String userPassword);// ログイン

	public boolean deleteProfessor(List<HumanVO> userList,String userUinqNum);// 退会

	public boolean addClass(List<LectureVO> lecList, LectureVO lecture, List<HumanVO> userList);// 講義入力
}
