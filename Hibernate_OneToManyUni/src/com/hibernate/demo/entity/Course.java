package com.hibernate.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "course_id")
	private List<Review> reviews;

	public Course() {

	}

	public Course(String title) {
		this.title = title;
	}

	public void addReview(Review review) {
		
		if(review == null) {
			return;
		}
		
		if(reviews == null) {
			reviews = new ArrayList<>();
		}
		
		reviews.add(review);
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}

}
