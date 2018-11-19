package com.ojt.nexture.www.manager;

import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.main.AcademyMain;

public class ManagerClass implements StaffManager {
	int index;
	HumanVO[] humans;
	String name;

	public ManagerClass() {
		
	} //매개변수 없는 생성자
	
	public ManagerClass(int length) {
		humans = new HumanVO[length];
		// TODO Auto-generated method stub
	} //HumanVO를 배열로 만들고, 그 배열의 크기를 매개변수로 정해주는 생성자

	@Override
	public void addClass() {
		// TODO Auto-generated method stub
	}
	//강의추가 메소드 미구현

	@Override
	public boolean insertPerson(HumanVO newHuman) {
		if (humans.length == index) {
			return false; 
		} 
		//index 값이 length와 같다면, 즉 humanVO 배열이 가득 차있다면 실패
		
		for (int i = 0; i < index; i++) {
			if (humans[i].getPhoneNum() == newHuman.getPhoneNum()) {
				return false; 
			}
			// humanVO 배열을 처음부터 비교하여 전화번호가 같다면 가입 실패 (중복 방지 요소가 핸드폰번호밖에 없음)
		}
		
		humans[index] = newHuman;
		index++;
		return true;
		//모두 일치하다면 humanVO의 index번 배열에 추가 후 index값 1증가
		
	} //회원가입 기능

	public HumanVO login(String humanName, String password) {
		for (int i = 0; i < index; i++) {
			if (humans[i].getName() == humanName) {
				if (humans[i].getPassword() == password) {
					name = humanName;
					return humans[i];
				}
				//입력한 name과 password가 humanVO 배열에 있을 시 로그인, 이때 로그인 한 이름을 name 값에 저장
				
				else {
					System.out.println("비밀번호 틀림");
				}
			} else {
				System.out.println("아이디 틀림");
			}
			//이름이나 비밀번호가 틀릴 경우 false
		}
		return null;
	} //로그인

	@Override
	public boolean updatePerson(HumanVO updateHuman) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePerson(String humanName, String password) {
		for (int i = 0; i < index; i++) {
			if (humans[i].getName() == name) {
				for(int a = i; a < index; a++) {
					humans[a] = humans[a + 1];
				}
				index--;
				return true;
			}
		}
		return false;
	}

}
