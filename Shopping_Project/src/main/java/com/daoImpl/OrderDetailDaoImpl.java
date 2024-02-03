package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

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
	
	@Override     
	public List<OrderDetail> selectAll() {
		Query<OrderDetail> query = session.createQuery("from HouseBean", OrderDetail.class);
		List<OrderDetail> lists = query.list();
		return lists;
	}
	
	@Override  //尋找quantity
	public List<Integer> selectAllQuantities() {
	    Query<Integer> query = session.createQuery("SELECT quantity FROM OrderDetail", Integer.class);
	    List<Integer> quantities = query.list();
	    return quantities;
	}
	
	@Override //尋找quantity*price
	public List<Integer> selectAllQuantitiesTimesPrices() {
	    Query<Integer> query = session.createQuery("SELECT quantity * price FROM OrderDetail", Integer.class);
	    List<Integer> quantitiesTimesPrices = query.list();
	    return quantitiesTimesPrices;
	}

}
