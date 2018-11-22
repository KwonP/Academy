/*
	Super:名前、パスワード、歳、電話番号
	this:部署
	コンストラクタ：
*/

package com.ojt.nexture.www.entity;

public class StaffVO extends HumanVO {

	private String department;

	public StaffVO() {

	}

	public StaffVO(String name, int age, String password, String phoneNum, String department) {
		super();
		this.department = department;
	}

	@Override
	public String toString() {
		return "StaffVO [department=" + department + "]";
	}
	//배열에 저장되는지 확인하기 위함
	
	

}
