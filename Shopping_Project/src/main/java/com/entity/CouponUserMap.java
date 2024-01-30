package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "coupon_user_map")
public class CouponUserMap {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_user_map")
	private int CouponUserMapId;
    
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "coupon_id")
    private Integer couponId;

    @Column(name = "user_used")
    private Integer userUsed;

    
    public CouponUserMap() {
    }


	public CouponUserMap(Integer userId, Integer couponId, Integer userUsed) {
		super();
		this.userId = userId;
		this.couponId = couponId;
		this.userUsed = userUsed;
	}


	public int getCouponUserMapId() {
		return CouponUserMapId;
	}


	public void setCouponUserMapId(int couponUserMapId) {
		CouponUserMapId = couponUserMapId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getCouponId() {
		return couponId;
	}


	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}


	public Integer getUserUsed() {
		return userUsed;
	}


	public void setUserUsed(Integer userUsed) {
		this.userUsed = userUsed;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CouponUserMap [CouponUserMapId=");
		builder.append(CouponUserMapId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", couponId=");
		builder.append(couponId);
		builder.append(", userUsed=");
		builder.append(userUsed);
		builder.append("]");
		return builder.toString();
	}
    
    

    
    
    
}
