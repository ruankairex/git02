package com.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "coupon")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private int couponId;

    @Column(name = "coupon_code", unique = true)
    private String couponCode;

    @Column(name = "coupon_category")
    private Integer couponCategory;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "coupon_describe")
    private String couponDescribe;

    @Column(name = "discount_id")
    private Integer discountId;

    @Column(name = "usage_limit")
    private Integer usageLimit;

    @Column(name = "used_count")
    private Integer usedCount;

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name="coupon_user_map", joinColumns = @JoinColumn(name="coupon_id"),
				inverseJoinColumns = @JoinColumn(name="user_id"))
    private List<User> users;

	public Coupon() {
		super();
	}

	public Coupon(String couponCode, Integer couponCategory, Integer userId, String couponDescribe, Integer discountId,
			Integer usageLimit, Integer usedCount, Timestamp startDate, Timestamp endDate, List<User> users) {
		super();
		this.couponCode = couponCode;
		this.couponCategory = couponCategory;
		this.userId = userId;
		this.couponDescribe = couponDescribe;
		this.discountId = discountId;
		this.usageLimit = usageLimit;
		this.usedCount = usedCount;
		this.startDate = startDate;
		this.endDate = endDate;
		this.users = users;
	}

	public int getCouponId() {
		return couponId;
	}

	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public Integer getCouponCategory() {
		return couponCategory;
	}

	public void setCouponCategory(Integer couponCategory) {
		this.couponCategory = couponCategory;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getCouponDescribe() {
		return couponDescribe;
	}

	public void setCouponDescribe(String couponDescribe) {
		this.couponDescribe = couponDescribe;
	}

	public Integer getDiscountId() {
		return discountId;
	}

	public void setDiscountId(Integer discountId) {
		this.discountId = discountId;
	}

	public Integer getUsageLimit() {
		return usageLimit;
	}

	public void setUsageLimit(Integer usageLimit) {
		this.usageLimit = usageLimit;
	}

	public Integer getUsedCount() {
		return usedCount;
	}

	public void setUsedCount(Integer usedCount) {
		this.usedCount = usedCount;
	}

	public Timestamp getStartDate() {
		return startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Timestamp getEndDate() {
		return endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public void addUser(User theUser) {
		if(users == null) {
			users = new ArrayList<>();
		}
		users.add(theUser);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Coupon [couponId=");
		builder.append(couponId);
		builder.append(", couponCode=");
		builder.append(couponCode);
		builder.append(", couponCategory=");
		builder.append(couponCategory);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", couponDescribe=");
		builder.append(couponDescribe);
		builder.append(", discountId=");
		builder.append(discountId);
		builder.append(", usageLimit=");
		builder.append(usageLimit);
		builder.append(", usedCount=");
		builder.append(usedCount);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append(", users=");
		builder.append(users);
		builder.append("]");
		return builder.toString();
	}
	
	

    
}
