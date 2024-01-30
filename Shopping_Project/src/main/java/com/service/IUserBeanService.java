package com.service;

import java.util.List;

import com.entity.User;

import java.sql.Timestamp;

public interface IUserBeanService {
	public List<User> selectAll();
	public User insert(User bean);
	public User update(int id, String lastName, String firstName, String userEmail, String userPassword,
			int buyerViolationCount, Timestamp lastLoginTime, int sellerQualified, String cardNumber,
			String cardCVCCode, Timestamp cardExpiryDate, String cardHolderName, String city, String district,
			String address, String bankAccount, Timestamp sellerDate, int sellerViolationCount, String userStatus);
	User selectById(int id);
}
