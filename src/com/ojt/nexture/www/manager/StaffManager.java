/*
	강의등록, 정보수정, 탈퇴
*/
package com.ojt.nexture.www.manager;

import com.ojt.nexture.www.entity.HumanVO;

/**
 * Human 객체와 저장소와의 통신을 담당한다. 주요 기능은 강의등록, 로그인, 회원가입, 정보수정, 탈퇴, 로그아웃 addClass,
 * addClass, insertPerson, login, updatePerson, deletePerson, logout
 */
public interface StaffManager {

	public void addClass();
	/*
	 *
	 */

	public boolean insertPerson(HumanVO newHuman);

	/**
	 * Person 객체를 받아 저장소에 저장하고, 저장 결과를 리턴한다.
	 * 
	 * @param newPerson 저장할 Person 객체
	 * @return 저장 성공 시 true, 저장 실패 시 (PersonId 중복 시) false
	 */

	public boolean updatePerson(HumanVO updateHuman);

	/**
	 * personId를 받아 해당하는 Person 객체를 삭제하고, 결과를 리턴한다.
	 * 
	 * @param personId 삭제할 Person의 personId
	 * @return 삭제 성공하면 true, 실패하면(해당하는 Person 없을 시) false 반환
	 */

	public boolean deletePerson(String humanName, String password);

	/**
	 * personId를 받아 해당하는 Person 객체를 삭제하고, 결과를 리턴한다.
	 * 
	 * @param personId 삭제할 Person의 personId
	 * @return 삭제 성공하면 true, 실패하면(해당하는 Person 없을 시) false 반환
	 */

	public HumanVO login(String humanName, String password);

	/**
	 * personId를 받아 해당하는 사람을 찾아 return 한다.
	 * 
	 * @param PersonId 찾을 사람의 personId
	 * @return 해당하는 사람이 있을 경우 그 Person 객체, 없을 시 null 반환
	 */
}
