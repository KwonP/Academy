/*
	강의명, 담당교수, 학점

*/

package com.ojt.nexture.www.entity;

import java.util.List;

public class LectureVO {

	private String lectureName;
	private String professor;
	private int score;
	private int personnel;
	private int ok;
	private String userUinqNum;

	public LectureVO(String lectureName, String professor, int score,  int personnel,String userUinqNum,
			int ok) {
		super();
		this.lectureName = lectureName;
		this.professor = professor;
		this.score = score;
		this.personnel = personnel;
		this.userUinqNum = userUinqNum;
		this.ok = ok;
	}

	public LectureVO() {
		super();
	}

	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getProfessor() {
		return professor;
	}

	public void setProfessor(String professor) {
		this.professor = professor;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public  int getPersonnel() {
		return personnel;
	}

	public void setPersonnel( int personnel) {
		this.personnel = personnel;
	}

	public int getOk() {
		return ok;
	}

	public void setOk(int ok) {
		this.ok = ok;
	}

	public String getUniqNum() {
		return userUinqNum;
	}

	public void setUniqNum(String userUinqNum) {
		this.userUinqNum = userUinqNum;
	}

	@Override
	public String toString() {
		return "LectureVO [lectureName=" + lectureName + ", professor=" + professor + ", score=" + score
				+ ", personnel=" + personnel + ", ok=" + ok + "]";
	}
}
