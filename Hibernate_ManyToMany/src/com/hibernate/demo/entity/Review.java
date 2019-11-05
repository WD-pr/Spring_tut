package com.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "comment")
	private String commment;
	
	public Review() {

	}

	public Review(String commment) {
		this.commment = commment;
	}

	public String getCommment() {
		return commment;
	}
	
	public int getId() {
		return id;
	}
	
	public void setCommment(String commment) {
		this.commment = commment;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "Review [id=" + id + ", commment=" + commment + "]";
	}
	
	
	
}
