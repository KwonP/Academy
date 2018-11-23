/*
	Super:名前、歳、電話番号
	this:所属学部

*/

package com.ojt.nexture.www.entity;



public class ProfessorVO  extends HumanVO {
	
	private String department;
	public ProfessorVO(String name, int age, String password, String phoneNum, String department) {
		super(name, age, password, phoneNum);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "ProfessorVO [getName()=" + getName() + ", getAge()=" + getAge() + ", getPassword()=" + getPassword()
		+ ", getPhoneNum()=" + getPhoneNum() + ", getDepartment()=" + getDepartment();
	}

}
