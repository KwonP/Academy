/*
	名前、パスワード、歳、電話番号


*/
package com.ojt.nexture.www.entity;

public class HumanVO {

	private String name;
	private int age;
	private String password;
	private String phoneNum;
	private int type;
	private String uniqNum;

	public HumanVO() {
		super();
	}

	public HumanVO(String name, int age, String password, String phoneNum, int type, String uniqNum) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
		this.phoneNum = phoneNum;
		this.type = type;
		this.uniqNum = uniqNum;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUniqNum() {
		return uniqNum;
	}

	public void setUniqNum(String uniqNum) {
		this.uniqNum = uniqNum;
	}

}
