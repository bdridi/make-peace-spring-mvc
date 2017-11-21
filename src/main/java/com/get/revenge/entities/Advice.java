package com.get.revenge.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@Entity
@Table(name="STS_ADVICES")
public class Advice {
	
	@Id @GeneratedValue
	private Long id;
	private String advice;
	@OneToOne
	private User user;
	@Basic
	@Temporal(TemporalType.DATE)
	private java.util.Date creationDate;
	 
	
	public Advice(String advice, User user) {
	
		this.advice = advice;
		this.user = user;
		this.creationDate = new Date();
		
	}

	public Advice() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}




	public Date getDate() {
		return creationDate;
	}

	public void setDate(Date date) {
		this.creationDate = date;
	}
	
	
	
	
	

}
