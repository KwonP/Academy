/*
	名前、パスワード、歳、電話番号


*/
package com.ojt.nexture.www.entity;

public class HumanVO {
	
	private String name;
	private String password;
	private int age;
	private String phoneNum;
	public HumanVO(String name, int age, String phoneNum) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNum = phoneNum;
	}
	public HumanVO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
	
}
