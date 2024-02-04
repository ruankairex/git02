package com.dao;

import java.util.List;

import com.entity.Coupon;

public interface CouponDao {
	public Coupon insertCoupon(Coupon theCoupon);
	public Coupon findCouponById(int theId);
	public List<Coupon> findAllCoupons();
}
