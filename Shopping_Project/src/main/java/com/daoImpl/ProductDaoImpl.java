package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dao.ProductDao;
import com.entity.Employee;
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
	
	@Override
	public List<Product> selectAll() {
		Query<Product> query = session.createQuery("from Product",Product.class);
		List<Product> lists = query.list();
		return lists;
	}

}
