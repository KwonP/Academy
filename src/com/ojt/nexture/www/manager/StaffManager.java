/*
	강의등록, 정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import java.util.ArrayList;

import com.ojt.nexture.www.entity.HumanVO;

public interface StaffManager {
	
	public boolean insertPerson(HumanVO newPerson);

	public boolean deletePerson(int personId);

	public ArrayList selectAllPerson();

	HumanVO logIn(String name, String password);

	HumanVO selectPerson(int personId);

}
