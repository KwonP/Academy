/*
	강의명, 담당교수, 학점

*/

package com.ojt.nexture.www.entity;

public class LectureVO {

	private String lectureName;
	private String professor;
	private String score;
	private int personnel;
	private int ok;

	public LectureVO(String lectureName, String professor, String score, int personnel, int ok) {
		super();
		this.lectureName = lectureName;
		this.professor = professor;
		this.score = score;
		this.personnel = personnel;
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

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int getPersonnel() {
		return personnel;
	}

	public void setPersonnel(int personnel) {
		this.personnel = personnel;
	}

	public int getOk() {
		return ok;
	}

	public void setOk(int ok) {
		this.ok = ok;
	}

	@Override
	public String toString() {
		return "LectureVO [lectureName=" + lectureName + ", professor=" + professor + ", score=" + score
				+ ", personnel=" + personnel + ", ok=" + ok + "]";
	}

}
