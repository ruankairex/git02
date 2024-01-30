package com.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_cancel")
public class OrderCancel {

    @Id
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "buyer_id")
    private Integer buyerId;

    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "cancel_person")
    private Integer cancelPerson;

    @Column(name = "cancel_reason", length = 50)
    private String cancelReason;

    @Column(name = "buyer_time")
    private Timestamp buyerTime;

    @Column(name = "seller_time")
    private Timestamp sellerTime;

    public OrderCancel() {
    }

	public OrderCancel(Integer buyerId, Integer sellerId, Integer cancelPerson, String cancelReason,
			Timestamp buyerTime, Timestamp sellerTime) {
		super();
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.cancelPerson = cancelPerson;
		this.cancelReason = cancelReason;
		this.buyerTime = buyerTime;
		this.sellerTime = sellerTime;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public Integer getSellerId() {
		return sellerId;
	}

	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getCancelPerson() {
		return cancelPerson;
	}

	public void setCancelPerson(Integer cancelPerson) {
		this.cancelPerson = cancelPerson;
	}

	public String getCancelReason() {
		return cancelReason;
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}

	public Timestamp getBuyerTime() {
		return buyerTime;
	}

	public void setBuyerTime(Timestamp buyerTime) {
		this.buyerTime = buyerTime;
	}

	public Timestamp getSellerTime() {
		return sellerTime;
	}

	public void setSellerTime(Timestamp sellerTime) {
		this.sellerTime = sellerTime;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("OrderCancel [orderId=");
		builder.append(orderId);
		builder.append(", buyerId=");
		builder.append(buyerId);
		builder.append(", sellerId=");
		builder.append(sellerId);
		builder.append(", cancelPerson=");
		builder.append(cancelPerson);
		builder.append(", cancelReason=");
		builder.append(cancelReason);
		builder.append(", buyerTime=");
		builder.append(buyerTime);
		builder.append(", sellerTime=");
		builder.append(sellerTime);
		builder.append("]");
		return builder.toString();
	}

	
}
