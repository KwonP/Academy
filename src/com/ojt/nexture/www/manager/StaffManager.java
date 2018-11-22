/*
	강의등록, 가입,정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

public interface StaffManager {
	
	public boolean fixStaff();
	//정보수정
	
	public boolean joinStaff();
	//가입
	
	public boolean deleteStaff();
	//탈퇴
	
	public void logInStaff();
	//로그인
	
	public void addClass();
	//강의등록
}
