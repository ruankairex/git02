package com.service;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;

import com.daoImpl.ProductDaoImpl;
import com.entity.Product;

public class ProductBeanService implements IProductBeanService {

	private ProductDaoImpl pDao;
	
	public ProductBeanService() {
	}
	
	public ProductBeanService(Session session) {
		pDao = new ProductDaoImpl(session);
	}
	
	@Override
	public List<Product> selectAll() {
		return pDao.selectAll();
	}

	@Override
	public Product insert(Product bean) {
		return pDao.insertProduct(bean);
	}

	@Override
	public Product update(int id, String name, Integer sid, Integer eid, Integer unitPrice, Integer categoryId,
			Integer stock, Integer reservedQuantity, Timestamp listingDate, Timestamp modifiedDate, String description,
			String productStatus) {
		return pDao.update(id, name, sid, eid, unitPrice, categoryId,stock,
				reservedQuantity, listingDate, modifiedDate, description,productStatus);
	}

	@Override
	public Product selectById(int id) {
		
		return pDao.findProductById(id);
	}

}
