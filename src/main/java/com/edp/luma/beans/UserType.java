package com.edp.luma.beans;

import java.util.List;

public class UserType implements Validator{
	private int userTypeId;
	private String userType;
	
	public UserType(int userTypeId, String userType) {
		super();
		this.userTypeId = userTypeId;
		this.userType = userType;
	}
	public UserType() {
		super();
	}
	
	public int getUserTypeId() {
		return userTypeId;
	}
	public void setUserTypeId(int userTypeId) {
		this.userTypeId = userTypeId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public List<String> validationErrors() {
		return null;
	}

	@Override
	public boolean checkValidation() {
		return false;
	}
}
