/*
	담당강의열람, 가입, 정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

public interface ProfessorManager {
	
	
	public void pj_Join();//당담강의열람

	public HumanVO loginProfessor();//로그인

	public boolean fixProfessor();//수정

	public boolean deleteProfessor();//탈퇴

	public boolean joinProfessor(List<HumanVO> userList, HumanVO human);//회원가입
}
