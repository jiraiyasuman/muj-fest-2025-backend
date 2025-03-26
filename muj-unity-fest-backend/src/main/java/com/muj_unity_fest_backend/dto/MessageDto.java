package com.muj_unity_fest_backend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class MessageDto {

	private Integer id;

	@Schema(description = "Please enter the name of the person")
	@NotEmpty(message = "Name should not be null/blank/white-spaces")
	private String name;
	@Schema(description = "Please enter the name of the city")
	@NotEmpty(message ="City should not be null/blank/white-space")
	private String city;
	@Schema(description = "Please enter the email of the candidate")
	@NotEmpty(message="Email id should not be null/blank/white-space")
	@Email(message="Email should be in valid format")
	private String email;
	@Schema(description = "Please enter the mobile number of the candidate")
	@NotEmpty(message = "Mobile Number should not be null/blank/white-space")
	private String mobile;
	@Schema(description = "Please enter the subject of the message")
	@NotEmpty(message = "Subject should not be null/blank/white-space")
	private String subject;
	@Schema(description = "Please enter the body of the message")
	@NotEmpty(message = "Body of the message should not be null/blank/white-space")
	private String message;
	
	public MessageDto(Integer id, @NotEmpty(message = "Name should not be null/blank/white-spaces") String name,
			@NotEmpty(message = "City should not be null/blank/white-space") String city,
			@NotEmpty(message = "Email id should not be null/blank/white-space") @Email(message = "Email should be in valid format") String email,
			@NotEmpty(message = "Mobile Number should not be null/blank/white-space") String mobile,
			@NotEmpty(message = "Subject should not be null/blank/white-space") String subject,
			@NotEmpty(message = "Body of the message should not be null/blank/white-space") String message) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.mobile = mobile;
		this.subject = subject;
		this.message = message;
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
	public MessageDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
