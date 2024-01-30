package com.daoImpl;

import org.hibernate.Session;

import com.dao.OrderDetailDao;
import com.entity.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao {
	
	private Session session;

	public OrderDetailDaoImpl() {
	}
	
	public OrderDetailDaoImpl(Session session) {
		this.session=session;
	}

	@Override
	public OrderDetail insertOrderDetail(OrderDetail theOrderDetail) {
		OrderDetail res = session.get(OrderDetail.class, theOrderDetail.getOrderDetailId());
		if(res == null) {
			System.out.println("insert...");
			session.persist(theOrderDetail);
			return theOrderDetail;
		}
		return null;
	}

	@Override
	public OrderDetail findOrderDetailById(int theId) {
		OrderDetail theOrderDetail = session.get(OrderDetail.class, theId);
		return theOrderDetail;
	}

}
