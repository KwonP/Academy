package com.ojt.nexture.www.manager;

import java.util.List;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.StudentVO;

public class StudentManagerClass implements StudentManager {

	@Override
	public boolean joinStudent(List<HumanVO> userList, StudentVO student) {
		userList.add(student);
		
		return false;
	}

	@Override
	public HumanVO loginStudent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean leadingStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean fixStudent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent() {
		// TODO Auto-generated method stub
		return false;
	}

}
