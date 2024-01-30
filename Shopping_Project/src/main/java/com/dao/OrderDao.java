package com.dao;

import com.entity.Order;

public interface OrderDao {
	public Order insertOrder(Order theOrder);
	public Order findOrderById(int theId);
}


