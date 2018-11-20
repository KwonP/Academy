package com.ojt.nexture.www.manager;

import java.util.ArrayList;

import com.ojt.nexture.www.entity.HumanVO;

/**
 * 배열을 이용한 Manager
 * 
 * @author david
 * @jdkVersion 1.8.0_162
 * @date 2018. 4. 8.
 */
public class ManagerClass implements StaffManager {

	int index;
	HumanVO[] persons;

	/**
	 * Default Constructor
	 */
	public ManagerClass() {

	}

	/**
	 * 생성자. 길이를 받아 그 길이만큼의 배열을 초기화 한다.
	 * 
	 * @param length 생성할 배열의 길이
	 */
	public ManagerClass(int length) {
		persons = new HumanVO[length];
	}

	/**
	 * Person 저장
	 */
	@Override
	public boolean insertPerson(HumanVO newPerson) {
		if (persons.length == index) {
			return false;
		}
		for (int i = 0; i < index; i++) {
			if (persons[i].getPersonId() == newPerson.getPersonId()) {
				return false;
			}
		}
		persons[index] = newPerson;
		index++;
		return true;
	}

	/**
	 * Person 삭제
	 */
	@Override
	public boolean deletePerson(int personId) {
		for (int i = 0; i < index; i++) {
			if (persons[i].getPersonId() == personId) {
				persons[i] = persons[i + 1];
				index--;
				return true;
			}
		}
		return false;
	}

	/**
	 * Person 조회
	 */

	/**
	 * 저장소 반환 배열을 ArrayList로 Wrapping하여 return 배열 전체를 담을 경우, 빈 공간이 남아
	 * NullPointerException 발생 index까지 돌면서 ArrayList에 추가
	 */
	@Override
	public ArrayList selectAllPerson() {
		ArrayList result = new ArrayList();
		for (int i = 0; i < index; i++) {
			result.add(persons[i]);
		}
		return result;
	}

	@Override
	public HumanVO selectPerson(int personId) {
		for (int i = 0; i < index; i++) {
			if (persons[i].getPersonId() == personId) {
				return persons[i];
			}
		}
		return null;
	}

	@Override
	public HumanVO logIn(String name, String password) {
		int i, j;
		for (i = 0; i < index; i++) {
			if (persons[i].getPassword().equals(password)) {
				return persons[i];
			}
		}
		for (j = 0; j < index; j++) {
			if (persons[j].getName().equals(name)) {
				return persons[j];
			}
		}
		if (persons[i].equals(persons[j])) {
			return persons[i];
		}
		return null;
	}

}