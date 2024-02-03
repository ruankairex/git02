package com.dao;

import java.sql.Timestamp;
import java.util.List;

import com.entity.Product;

public interface ProductDao {
	public List<Product> selectAll();
	public Product findProductById(int theId);
	public Product insertProduct(Product theProduct);
	public Product update(int id,String name,Integer sid,Integer eid,Integer unitPrice,Integer categoryId,
			Integer stock,Integer reservedQuantity,Timestamp listingDate,Timestamp modifiedDate,
			String description,String productStatus);
	public List<Integer> selectUnitpriceStockBycategory(int categoryId);
}
