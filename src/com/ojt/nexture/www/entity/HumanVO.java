/*
	名前、パスワード、歳、電話番号


*/
package com.ojt.nexture.www.entity;

public class HumanVO {

	private String name;
	private int age;
	private int personId;
	private String password;
	private int age;
	private String phoneNum;
	public HumanVO(String name, String password,int age, String phoneNum) {
		super();
	}

	public HumanVO(String name, int age, int personId, String password, int code) {
		this.name = name;
		this.password = password;
		this.age = age;
		this.personId = personId;
		this.password = password;
		this.code = code;
	}

	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getPersonId() {
		return personId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
