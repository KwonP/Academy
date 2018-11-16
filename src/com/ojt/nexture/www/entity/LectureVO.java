/*
	강의명, 담당교수, 학점

*/

package com.ojt.nexture.www.entity;

public class LectureVO {
	
	private String lectureName;
	private String professor;
	private String score;
	public LectureVO(String lectureName, String professor, String score) {
		super();
		this.lectureName = lectureName;
		this.professor = professor;
		this.score = score;
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
	@Override
	public String toString() {
		return "講義名" + lectureName +"　担当教授：" + professor + ", score=" + score + "]";
	}
	
	
	
}
