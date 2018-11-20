/*
	Super:名前、パスワード、歳、電話番号
	this:部署
	コンストラクタ：
*/

package com.ojt.nexture.www.entity;

public class StaffVO extends HumanVO {

	private String department;

	public StaffVO() {
		super();
	}

	public StaffVO(String name, int age, int personId, String password, String department, int code) {
		super(name, age, personId, password, code);
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString() + "|" + department;
	}
}
