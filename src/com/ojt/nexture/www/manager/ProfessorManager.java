/*
	담당강의열람, 가입, 정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import java.util.List;

import com.ojt.nexture.www.entity.HumanVO;

public interface ProfessorManager {
	
	public void pj_Join();//당담강의열람

	public boolean fixProfessor();//수정

	public boolean joinProfessor(List<HumanVO> userList, HumanVO human);//회원가입

	public void loginProfessor(String userName);

	public boolean deleteProfessor(List<HumanVO> userList,String userPhoneNum);

}
