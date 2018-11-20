/*
	Super：名前、パスワード、歳、電話番号
	this:学科、学籍番号

*/
package com.ojt.nexture.www.entity;

public class StudentVO extends HumanVO {

	private String studentId;

    public StudentVO() {
        super();
    }

    public StudentVO(String name, int age, int personId, String password, String studentId, int code) {
        super(name, age, personId, password, code);
        this.studentId = studentId;
    }

    @Override
	public String toString() {
		return super.toString() + "|" + studentId;
	}

}
