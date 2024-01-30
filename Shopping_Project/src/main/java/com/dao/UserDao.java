package com.dao;

import java.sql.Timestamp;
import java.util.List;

import com.entity.User;

public interface UserDao {
	public User insertUser(User user);
	public User findUserById(int theId);
	public List<User> selectAll();
	
	public User update(int id, String lastName, String firstName, String userEmail, String userPassword,
				int buyerViolationCount, Timestamp lastLoginTime, int sellerQualified, String cardNumber,
				String cardCVCCode, Timestamp cardExpiryDate, String cardHolderName, String city, String district,
				String address, String bankAccount, Timestamp sellerDate, int sellerViolationCount, String userStatus);
	User selectById(int id);


	}
