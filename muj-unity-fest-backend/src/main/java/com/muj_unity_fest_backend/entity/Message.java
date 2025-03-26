package com.muj_unity_fest_backend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="message")
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="city")
	private String city;
	@Column(name="email")
	private String email;
	@Column(name="mobile")
	private String mobile;
	@Column(name="subject")
	private String subject;
	@Column(name="message")
	private String message;
	
	@Override
	public String toString() {
		return "Message [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", mobile=" + mobile
				+ ", subject=" + subject + ", message=" + message + "]";
	}
	public Message(Integer id, String name, String city, String email, String mobile, String subject, String message) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.mobile = mobile;
		this.subject = subject;
		this.message = message;
	}
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
