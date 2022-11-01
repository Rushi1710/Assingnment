package com.springBoot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@ToString
@Entity
@Table(name="teacher")

public class Teacher 
{

	@Id
	private int teacherId;
	private String teacherName;
	private String teacherSubject;
	public Teacher() {
		super();
		System.out.println("default constuctor Teacher");
	}
	public Teacher(int teacherId, String teacherName, String teacherSubject) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.teacherSubject = teacherSubject;
	}
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherSubject() {
		return teacherSubject;
	}
	public void setTeacherSubject(String teacherSubject) {
		this.teacherSubject = teacherSubject;
	}
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherSubject=" + teacherSubject
				+ "]";
	}
	
	
	
	
}
