package com.example.demo.modal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document
public class User {

	@Id
	@ApiModelProperty(notes = "Add user id")
	private String userId;
	@ApiModelProperty(notes = "Add user name")
	private String name;
	@ApiModelProperty(notes = "Add(Auto Add) Date id")
	private Date creationDate = new Date();
	@ApiModelProperty(notes = "Add Bikwe Name")
	private String bike;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getBike() {
		return bike;
	}

	public void setBike(String bike) {
		this.bike = bike;
	}
}

