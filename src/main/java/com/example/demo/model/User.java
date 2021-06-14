package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name="User_Services")

public class User {
	@Column
	@Id
	@GeneratedValue
	private Integer userId;
	@Column
	private String userName;
@Column(name="actives")
private Boolean active=false;
	
	@Column
	
	private String userSurname;
	@Column
	private Integer userPincode;
	@Column
	@Temporal(TemporalType.DATE)
	private Date userDob;
	
	 
	@Column
	@Temporal(TemporalType.DATE)
    
	private Date userDoj;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserSurname() {
		return userSurname;
	}
	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}
	public Integer getUserPincode() {
		return userPincode;
	}
	
	
	
	/*
	 * public boolean getActive() { return active; } public void setActive(boolean
	 * active) { this.active = active; } public void setUserPincode(Integer
	 * userPincode) { this.userPincode = userPincode; }
	 */
	
	
	
	
	
	
	

	
	
	
	
	
	public void setUserPincode(Integer userPincode) {
		this.userPincode = userPincode;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Date getUserDob() {
		return userDob;
	}
	public void setUserDob(Date userDob) {
		this.userDob = userDob;
	}
	public Date getUserDoj() {
		return userDoj;
	}
	public void setUserDoj(Date userDoj) {
		this.userDoj = userDoj;
	}
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", active=" + active + ", userSurname="
				+ userSurname + ", userPincode=" + userPincode + ", userDob=" + userDob + ", userDoj=" + userDoj + "]";
	}
	

	
	
	
	
	
}
	
	
	