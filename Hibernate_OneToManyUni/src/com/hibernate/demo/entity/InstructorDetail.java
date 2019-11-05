package com.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String category;

	private String hobby;

	@OneToOne(mappedBy = "instructorDetail", cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	private Instructor instructor;

	public InstructorDetail() {

	}

	public InstructorDetail(String category, String hobby) {
		this.category = category;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public String getHobby() {
		return hobby;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", category=" + category + ", hobby=" + hobby + "]";
	}

}
