package com.dao;

import com.entity.Product;

public interface ProductDao {
	public Product insertProduct(Product theProduct);
	public Product findProductById(int theId);
}
