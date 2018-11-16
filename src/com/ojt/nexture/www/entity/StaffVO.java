/*
	Super:名前、パスワード、歳、電話番号
	this:部署
	コンストラクタ：
*/

package com.ojt.nexture.www.entity;

public class StaffVO extends HumanVO {

	private String department;
	
	public StaffVO(String name, int age, String phoneNum, String department) {
		super(name, age, phoneNum);
		this.department = department;
	}
	
	public StaffVO() {
        super();
    }

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "所属学部=" + department + "]";
	}

}
