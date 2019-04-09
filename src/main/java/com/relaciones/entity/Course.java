package com.relaciones.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="Courses")
public class Course{

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name="className")
	private String className;
	
	@Column(name="maxStudents")
	private int maxStudents;
	
	
	@OneToMany(mappedBy = "course")
	
	private List<Student> students;
	
	public Integer getId() {
		return id;
	}
	
	public int getMaxStudents() {
		return maxStudents;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	

	
}