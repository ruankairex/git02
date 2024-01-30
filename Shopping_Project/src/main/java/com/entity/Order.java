package com.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "buyer_id")
    private Integer buyerId;

    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "order_date")
    private Timestamp orderDate;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Column(name = "discount")
    private Integer discount;

    @Column(name = "discount_description")
    private String discountDescription;

    @Column(name = "payment_method")
    private Integer paymentMethod;

    @Column(name = "payment_status")
    private Integer paymentStatus;

    @Column(name = "seller_confirm_date")
    private Timestamp sellerConfirmDate;

    @Column(name = "seller_ship_date")
    private Timestamp sellerShipDate;

    @Column(name = "logistics_ship_date")
    private Timestamp logisticsShipDate;

    @Column(name = "logistics_arrival_date")
    private Timestamp logisticsArrivalDate;

    @Column(name = "buyer_receive_date")
    private Timestamp buyerReceiveDate;

    @Column(name = "buyer_confirm_date")
    private Timestamp buyerConfirmDate;

    @Column(name = "order_complete_date")
    private Timestamp orderCompleteDate;

    @Column(name = "logistics_name")
    private String logisticsName;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "address")
    private String address;

    @Column(name = "freight")
    private Integer freight;
    
 
    
	public Order() {
		super();
	}



	public Order(Integer buyerId, Integer sellerId, Timestamp orderDate, Integer totalPrice, Integer discount,
			String discountDescription, Integer paymentMethod, Integer paymentStatus, Timestamp sellerConfirmDate,
			Timestamp sellerShipDate, Timestamp logisticsShipDate, Timestamp logisticsArrivalDate,
			Timestamp buyerReceiveDate, Timestamp buyerConfirmDate, Timestamp orderCompleteDate, String logisticsName,
			String city, String district, String address, Integer freight) {
		super();
		this.buyerId = buyerId;
		this.sellerId = sellerId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.discount = discount;
		this.discountDescription = discountDescription;
		this.paymentMethod = paymentMethod;
		this.paymentStatus = paymentStatus;
		this.sellerConfirmDate = sellerConfirmDate;
		this.sellerShipDate = sellerShipDate;
		this.logisticsShipDate = logisticsShipDate;
		this.logisticsArrivalDate = logisticsArrivalDate;
		this.buyerReceiveDate = buyerReceiveDate;
		this.buyerConfirmDate = buyerConfirmDate;
		this.orderCompleteDate = orderCompleteDate;
		this.logisticsName = logisticsName;
		this.city = city;
		this.district = district;
		this.address = address;
		this.freight = freight;
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



	public Timestamp getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}



	public Integer getTotalPrice() {
		return totalPrice;
	}



	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}



	public Integer getDiscount() {
		return discount;
	}



	public void setDiscount(Integer discount) {
		this.discount = discount;
	}



	public String getDiscountDescription() {
		return discountDescription;
	}



	public void setDiscountDescription(String discountDescription) {
		this.discountDescription = discountDescription;
	}



	public Integer getPaymentMethod() {
		return paymentMethod;
	}



	public void setPaymentMethod(Integer paymentMethod) {
		this.paymentMethod = paymentMethod;
	}



	public Integer getPaymentStatus() {
		return paymentStatus;
	}



	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	public Timestamp getSellerConfirmDate() {
		return sellerConfirmDate;
	}



	public void setSellerConfirmDate(Timestamp sellerConfirmDate) {
		this.sellerConfirmDate = sellerConfirmDate;
	}



	public Timestamp getSellerShipDate() {
		return sellerShipDate;
	}



	public void setSellerShipDate(Timestamp sellerShipDate) {
		this.sellerShipDate = sellerShipDate;
	}



	public Timestamp getLogisticsShipDate() {
		return logisticsShipDate;
	}



	public void setLogisticsShipDate(Timestamp logisticsShipDate) {
		this.logisticsShipDate = logisticsShipDate;
	}



	public Timestamp getLogisticsArrivalDate() {
		return logisticsArrivalDate;
	}



	public void setLogisticsArrivalDate(Timestamp logisticsArrivalDate) {
		this.logisticsArrivalDate = logisticsArrivalDate;
	}



	public Timestamp getBuyerReceiveDate() {
		return buyerReceiveDate;
	}



	public void setBuyerReceiveDate(Timestamp buyerReceiveDate) {
		this.buyerReceiveDate = buyerReceiveDate;
	}



	public Timestamp getBuyerConfirmDate() {
		return buyerConfirmDate;
	}



	public void setBuyerConfirmDate(Timestamp buyerConfirmDate) {
		this.buyerConfirmDate = buyerConfirmDate;
	}



	public Timestamp getOrderCompleteDate() {
		return orderCompleteDate;
	}



	public void setOrderCompleteDate(Timestamp orderCompleteDate) {
		this.orderCompleteDate = orderCompleteDate;
	}



	public String getLogisticsName() {
		return logisticsName;
	}



	public void setLogisticsName(String logisticsName) {
		this.logisticsName = logisticsName;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getDistrict() {
		return district;
	}



	public void setDistrict(String district) {
		this.district = district;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Integer getFreight() {
		return freight;
	}



	public void setFreight(Integer freight) {
		this.freight = freight;
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=");
		builder.append(orderId);
		builder.append(", buyerId=");
		builder.append(buyerId);
		builder.append(", sellerId=");
		builder.append(sellerId);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", totalPrice=");
		builder.append(totalPrice);
		builder.append(", discount=");
		builder.append(discount);
		builder.append(", discountDescription=");
		builder.append(discountDescription);
		builder.append(", paymentMethod=");
		builder.append(paymentMethod);
		builder.append(", paymentStatus=");
		builder.append(paymentStatus);
		builder.append(", sellerConfirmDate=");
		builder.append(sellerConfirmDate);
		builder.append(", sellerShipDate=");
		builder.append(sellerShipDate);
		builder.append(", logisticsShipDate=");
		builder.append(logisticsShipDate);
		builder.append(", logisticsArrivalDate=");
		builder.append(logisticsArrivalDate);
		builder.append(", buyerReceiveDate=");
		builder.append(buyerReceiveDate);
		builder.append(", buyerConfirmDate=");
		builder.append(buyerConfirmDate);
		builder.append(", orderCompleteDate=");
		builder.append(orderCompleteDate);
		builder.append(", logisticsName=");
		builder.append(logisticsName);
		builder.append(", city=");
		builder.append(city);
		builder.append(", district=");
		builder.append(district);
		builder.append(", address=");
		builder.append(address);
		builder.append(", freight=");
		builder.append(freight);
		builder.append("]");
		return builder.toString();
	}

	
}
