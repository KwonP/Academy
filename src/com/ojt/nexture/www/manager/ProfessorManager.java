/*
	담당강의열람, 가입, 정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;

public interface ProfessorManager {
	
	public void pj_Join(List<LectureVO> lecList,String userName);//당담강의열람

	public boolean fixProfessor(List<HumanVO> userList, HumanVO human, String userPhoneNum);//수정

	public boolean joinProfessor(List<HumanVO> userList, HumanVO human);//회원가입

	public void loginProfessor(String userName);

	public boolean deleteProfessor(List<HumanVO> userList,String userPhoneNum);

}
