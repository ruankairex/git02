package com.dao;

import com.entity.Coupon;

public interface CouponDao {
	public Coupon insertCoupon(Coupon theCoupon);
	public Coupon findCouponById(int theId);
}
