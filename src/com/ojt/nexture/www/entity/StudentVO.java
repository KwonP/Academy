/*
	Super：名前、パスワード、歳、電話番号
	this:学科、学籍番号

*/
package com.ojt.nexture.www.entity;

public class StudentVO extends HumanVO {

	private String major;
	private String student_Num;

	public StudentVO(String name, int age, String password, String phoneNum, String major, String student_Num) {
		super();
		this.major = major;
		this.student_Num = student_Num;
	}

	public StudentVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		super.setName(name);
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return super.getAge();
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		super.setAge(age);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return super.getPassword();
	}

	@Override
	public void setPassword(String password) {
		// TODO Auto-generated method stub
		super.setPassword(password);
	}

	@Override
	public String getPhoneNum() {
		// TODO Auto-generated method stub
		return super.getPhoneNum();
	}

	@Override
	public void setPhoneNum(String phoneNum) {
		// TODO Auto-generated method stub
		super.setPhoneNum(phoneNum);
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
