package com.ojt.nexture.www.managerImpl;

import java.util.List;
import com.ojt.nexture.www.entity.HumanVO;
import com.ojt.nexture.www.entity.LectureVO;
import com.ojt.nexture.www.manager.StudentManager;

public class StudentManagerImpl implements StudentManager {
	int checkNum = 0;
	int fixCheck, listNum;
	String userName;

	@Override
	public void loginStudent(List<HumanVO> userList, String uniqNum, String password) {

		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUniqNum().equals(uniqNum))
				userName = userList.get(i).getName();
		}

		System.out.println("----------------------------------------------------------------------------------");
		System.out.println("\t\t\t\t ようこそ！" + userName + "様！");
		System.out.println("\t1．全体講義一覧　　　2．自分の講義一覧　　　3．ログアウト \n");
		System.out.println("----------------------------------------------------------------------------------");

	}

	@Override
	public boolean allLeadingStudent(List<LectureVO> lecList) {
		
		
		
		
		
		return true;
	}
	
	@Override
	public boolean requestStudent(List<LectureVO> lecList, String lectNm) {
		
		return true;
	}

	@Override
	public boolean leadingStudent(List<LectureVO> lecList) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancletStudent(List<LectureVO> lecList) {
		// TODO Auto-generated method stub
		return false;
	}

}
