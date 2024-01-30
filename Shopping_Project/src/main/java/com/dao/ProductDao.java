package com.dao;

import java.util.List;

import com.entity.Employee;
import com.entity.Product;

public interface ProductDao {
	public Product insertProduct(Product theProduct);
	public Product findProductById(int theId);
	List<Product> selectAll();
}
