/*
	강의목록열람, 정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import com.ojt.nexture.www.entity.HumanVO;
import java.util.ArrayList;

public interface StudentManager {
	
	public void selectClass(); //강의열람

	public boolean insertStudent(HumanVO newPerson); //회원가입
	
	public boolean updateStudent(); //회원수정

	public boolean deleteStudent(int personId); //탈퇴

	HumanVO logIn(String name, String password); //로그인

}
