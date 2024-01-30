package com.service;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;

import com.daoImpl.UserDaoImpl;
import com.entity.User;




public class UserBeanService implements IUserBeanService {

	private UserDaoImpl uDao;

	public UserBeanService() {
	}
	
	public UserBeanService(Session session) {
		uDao = new UserDaoImpl(session);
	}


	@Override
	public List<User> selectAll() {
		return uDao.selectAll();
	}

	@Override
	public User insert(User bean) {
		return uDao.insertUser(bean);
	}

	@Override
	public User update(int id, String lastName, String firstName, String userEmail, String userPassword,
			int buyerViolationCount, Timestamp lastLoginTime, int sellerQualified, String cardNumber,
			String cardCVCCode, Timestamp cardExpiryDate, String cardHolderName, String city, String district,
			String address, String bankAccount, Timestamp sellerDate, int sellerViolationCount, String userStatus) {
		
		return uDao.update(id, lastName, firstName, userEmail, userPassword, buyerViolationCount, lastLoginTime, sellerQualified, cardNumber, cardCVCCode
				, cardExpiryDate, cardHolderName, city, district, address, bankAccount, sellerDate, sellerViolationCount, userStatus);
		
	}

	@Override
	public User selectById(int id) {
		return uDao.selectById(id);
	}


}
