/*
	Super：名前、パスワード、歳、電話番号
	this:学科、学籍番号

*/
package com.ojt.nexture.www.entity;

public class StudentVO extends HumanVO {

	private String major;
	private String student_Num;

	public StudentVO(String name, int age, String password, String phoneNum, int type, String uniqNum, String major,
			String student_Num) {
		super(name, age, password, phoneNum, type, uniqNum);
		this.major = major;
		this.student_Num = student_Num;
	}

	public StudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStudent_Num() {
		return student_Num;
	}

	public void setStudent_Num(String student_Num) {
		this.student_Num = student_Num;
	}

	@Override
	public String toString() {
		return "StudentVO [getName()=" + getName() + ", getAge()=" + getAge() + ", getPassword()=" + getPassword()
				+ ", getPhoneNum()=" + getPhoneNum() + ", major=" + major + ", student_Num=" + student_Num + "]";
	}

}
