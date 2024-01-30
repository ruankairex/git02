package com.daoImpl;

import org.hibernate.Session;

import com.dao.ProductDao;
import com.entity.Product;

public class ProductDaoImpl implements ProductDao {
	
	private Session session;

	public ProductDaoImpl() {
	}
	
	public ProductDaoImpl(Session session) {
		this.session=session;
	}

	@Override
	public Product insertProduct(Product theProduct) {
		Product res = session.get(Product.class, theProduct.getProductId());
		if(res == null) {
			System.out.println("insert...");
			session.persist(theProduct);
			return theProduct;
		}
		return null;
	}

	@Override
	public Product findProductById(int theId) {
		Product theProduct = session.get(Product.class, theId);
		return theProduct;
	}

}
