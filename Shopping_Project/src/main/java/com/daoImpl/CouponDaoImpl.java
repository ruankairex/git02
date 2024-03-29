package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dao.CouponDao;
import com.entity.Coupon;


public class CouponDaoImpl implements CouponDao {
	
	private Session session;

	public CouponDaoImpl() {
	}
	
	public CouponDaoImpl(Session session) {
		this.session=session;
	}

	@Override
	public Coupon insertCoupon(Coupon theCoupon) {
		Coupon res = session.get(Coupon.class, theCoupon.getCouponId());
		if(res == null) {
			System.out.println("insert...");
			session.persist(theCoupon);
			return theCoupon;
		}
		return null;
	}

	@Override
	public Coupon findCouponById(int theId) {
		Coupon theCoupon = session.get(Coupon.class, theId);
		
		return theCoupon;
	}

	@Override
	public List<Coupon> findAllCoupons() {
		Query<Coupon> query = session.createQuery("from Coupon",Coupon.class);
		List<Coupon> lists = query.list();
		return lists;
	}

}
