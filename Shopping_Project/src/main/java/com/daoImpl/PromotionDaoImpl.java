package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dao.PromotionDao;
import com.entity.Promotion;

public class PromotionDaoImpl implements PromotionDao{
	
	private Session session;

	public PromotionDaoImpl() {
	}
	
	public PromotionDaoImpl(Session session) {
		this.session=session;
	}

	@Override
	public Promotion insertPromotion(Promotion thePromotion) {
		Promotion res = session.get(Promotion.class, thePromotion.getPromotionId());
		if(res == null) {
			System.out.println("insert...");
			session.persist(thePromotion);
			return thePromotion;
		}
		return null;
	}

	@Override
	public Promotion findPromotionById(int theId) {
		Promotion thePromotion = session.get(Promotion.class, theId);
		return thePromotion;
	}
	
	@Override
	public List<Promotion> findAll() {
		
        String hql = "FROM Promotion";
        Query<Promotion> query = session.createQuery(hql, Promotion.class);
        List<Promotion> lis = query.list();
        return lis;   
       
	}

	@Override
	public Promotion updatePromotion(Promotion thePromotion) {
		session.merge(thePromotion);
		return thePromotion;
	}

	@Override
	public void deletePromotionById(Integer theId) {
		Promotion thePromotion = session.get(Promotion.class, theId);
		session.remove(thePromotion);
	}

}

