package com.daoImpl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

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

	@Override
	public List<Product> selectAll() {
		Query<Product> query = session.createQuery("from Product", Product.class);
		List<Product> lists = query.list();
		return lists;
	}

	@Override
	public Product update(int id, String name, Integer sid, Integer eid, Integer unitPrice, Integer categoryId,
						  Integer stock, Integer reservedQuantity, Timestamp listingDate, Timestamp modifiedDate,
						  String description,String productStatus) {
		// 根據 id 獲取對應的 ProductBean 對象
		Product result = session.get(Product.class, id);
		System.out.println(result.getProductName());
		// 如果找到對應的 ProductBean 對象
		if(result!=null) {
			//更新 ProductBean 的屬性
			result.setProductName(name);
			result.setUnitPrice(unitPrice);
			result.setCategoryId(categoryId);
			result.setStock(stock);
			result.setModifiedDate(modifiedDate);
			result.setDescription(description);
			result.setProductStatus(productStatus);
		}
		// 返回更新後的 ProductBean 對象（可能為空，視更新結果而定）
		return result;
	}

}
