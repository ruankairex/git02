package com.daoImpl;

import org.hibernate.Session;

import com.dao.OrderDao;
import com.entity.Order;

public class OrderDaoImpl implements OrderDao{
	
	private Session session;

	public OrderDaoImpl() {
	}
	
	public OrderDaoImpl(Session session) {
		this.session=session;
	}

	@Override
	public Order insertOrder(Order theOrder) {
		Order res = session.get(Order.class, theOrder.getOrderId());
		if(res == null) {
			System.out.println("insert...");
			session.persist(theOrder);
			return theOrder;
		}
		return null;
	}

	@Override
	public Order findOrderById(int theId) {
		Order theOrder = session.get(Order.class, theId);
		return theOrder;
	}

}
