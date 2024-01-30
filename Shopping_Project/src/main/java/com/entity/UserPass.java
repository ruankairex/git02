package com.entity;


public class UserPass {
	
    private int userId;

    private String lastName;

    private String firstName;

    private String userEmail;

    private Integer sellerQualified;

    private String userStatus;
	
	
	public UserPass() {
		
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getUserEmail() {
		return userEmail;
	}


	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}


	public Integer getSellerQualified() {
		return sellerQualified;
	}


	public void setSellerQualified(Integer sellerQualified) {
		this.sellerQualified = sellerQualified;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	
	
}
