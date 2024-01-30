package com.dao;

import com.entity.OrderDetail;

public interface OrderDetailDao {
	public OrderDetail insertOrderDetail(OrderDetail theOrderDetail);
	public OrderDetail findOrderDetailById(int theId);

}
