package com.service;

import java.sql.Timestamp;
import java.util.List;

import com.entity.Product;

public interface IProductBeanService {
	public List<Product> selectAll();
	public Product insert (Product bean);
	public Product update(int id,String name,Integer sid,Integer eid,Integer unitPrice,Integer categoryId,
			Integer stock,Integer reservedQuantity,Timestamp listingDate,Timestamp modifiedDate,
			String description,String productStatus);
	public Product selectById(int id);
}
