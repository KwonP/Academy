/*
	Super:名前、歳、電話番号
	this:所属学部

*/

package com.ojt.nexture.www.entity;

public class ProfessorVO extends HumanVO {
	private String department;

	public ProfessorVO() {
		super();
	}

	public ProfessorVO(String name, int age, int personId, String password, String department, int code) {
		super(name, age, personId, password, code);
		this.department = department;
	}

	@Override
	public String toString() {
		return super.toString() + "|" + department;
	}
}
