/*
	Super:名前、歳、電話番号
	this:所属学部

*/

package com.ojt.nexture.www.entity;



public class ProfessorVO extends HumanVO {
	//department 부서
	private String department;
	
	public ProfessorVO() {
		super();
	}
	public ProfessorVO(String name,int age, String phoneNum,String department) {
		super(name,age,phoneNum);
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
		return super.toString()+"|"+department;
	}		
}
