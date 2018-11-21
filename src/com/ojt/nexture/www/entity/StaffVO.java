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

}
