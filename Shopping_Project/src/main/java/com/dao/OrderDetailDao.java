package com.dao;

import java.util.List;

import com.entity.OrderDetail;

public interface OrderDetailDao {
	public OrderDetail insertOrderDetail(OrderDetail theOrderDetail);
	public OrderDetail findOrderDetailById(int theId);
	public List<OrderDetail> selectAll();
	public List<Integer> selectAllQuantities();
	public List<Integer> selectAllQuantitiesTimesPrices();
}
