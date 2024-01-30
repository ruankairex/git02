package com.daoImpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dao.UserDao;
import com.entity.User;



public class UserDaoImpl implements UserDao{
	
	private Session session;

	public UserDaoImpl() {
	}
	
	public UserDaoImpl(Session session) {
		this.session=session;
	}
	

	@Override
	public User insertUser(User user) {
		User res = session.get(User.class, user.getUserId());
		if(res == null) {
			System.out.println("insert...");
			session.persist(user);
			return user;
		}
		return null;
	}

	@Override
	public User findUserById(int theId) {
		User res = session.get(User.class, theId);
		return res;
	}
	
	@Override
	public List<User> selectAll() {
		Query<User> query = session.createQuery("from User", User.class);
		List<User> lists = query.list();
		return lists;
	}
	
	@Override
	public User update(int id, String lastName, String firstName,String userEmail, String userPassword, 
						   int buyerViolationCount,Timestamp lastLoginTime, int sellerQualified, String cardNumber, 
						   String cardCVCCode, Timestamp cardExpiryDate, String cardHolderName, String city, String district, 
						   String address, String bankAccount, Timestamp sellerDate, int sellerViolationCount, String userStatus) {
	    // 根據 id 獲取對應的 UserBean 對象
	    User result = session.get(User.class, id);
	    System.out.println(result.getFirstName());
	    // 如果找到對應的 UserBean 對象
	    if(result != null) {
	        // 更新 UserBean 的屬性
	        result.setFirstName(firstName); 
	        result.setLastName(lastName);
	        result.setUserPassword(userPassword);
	        result.setBuyerViolationCount(buyerViolationCount);
	        result.setSellerViolationCount(sellerViolationCount);
	        result.setSellerQualified(sellerQualified);
	        result.setUserStatus(userStatus);
	    }
	    
	    // 返回更新後的 UserBean 對象（可能為空，視更新結果而定）
	    return result;
	}

	@Override
	public User selectById(int id) {
		User resultBean = session.get(User.class, id);
		if(resultBean!=null) {
			System.out.println(resultBean.getUserId() + " " + resultBean.getFirstName());
		}else {
			System.out.println("no result2");
		}
		return resultBean;
	}

}
