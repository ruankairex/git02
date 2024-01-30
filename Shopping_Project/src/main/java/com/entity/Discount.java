package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "discount_id")
    private int discountId;

    @Column(name = "discount_code", unique = true)
    private String discountCode;

    @Column(name = "discount_type")
    private Integer discountType;

    @Column(name = "discount_percentage")
    private double discountPercentage;

    @Column(name = "order_total_price")
    private Integer orderTotalPrice;

    @Column(name = "discount_price")
    private Integer discountPrice;

	public Discount() {
		super();
	}

	public Discount(int discountId, String discountCode, Integer discountType, double discountPercentage,
			Integer orderTotalPrice, Integer discountPrice) {
		super();
		this.discountCode = discountCode;
		this.discountType = discountType;
		this.discountPercentage = discountPercentage;
		this.orderTotalPrice = orderTotalPrice;
		this.discountPrice = discountPrice;
	}

	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getDiscountCode() {
		return discountCode;
	}

	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}

	public Integer getDiscountType() {
		return discountType;
	}

	public void setDiscountType(Integer discountType) {
		this.discountType = discountType;
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public Integer getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(Integer orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public Integer getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Integer discountPrice) {
		this.discountPrice = discountPrice;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Discount [discountId=");
		builder.append(discountId);
		builder.append(", discountCode=");
		builder.append(discountCode);
		builder.append(", discountType=");
		builder.append(discountType);
		builder.append(", discountPercentage=");
		builder.append(discountPercentage);
		builder.append(", orderTotalPrice=");
		builder.append(orderTotalPrice);
		builder.append(", discountPrice=");
		builder.append(discountPrice);
		builder.append("]");
		return builder.toString();
	}

    
}