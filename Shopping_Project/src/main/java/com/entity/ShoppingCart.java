package com.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopping_cart_id")
    private int shoppingCartId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "created_time", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdTime;

    @Column(name = "updated_time", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp updatedTime;

  
    public ShoppingCart() {
    }


	public ShoppingCart(Integer userId, Integer productId, Integer quantity, Integer unitPrice, Timestamp createdTime,
			Timestamp updatedTime) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.createdTime = createdTime;
		this.updatedTime = updatedTime;
	}


	public int getShoppingCartId() {
		return shoppingCartId;
	}


	public void setShoppingCartId(int shoppingCartId) {
		this.shoppingCartId = shoppingCartId;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Integer getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}


	public Timestamp getCreatedTime() {
		return createdTime;
	}


	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}


	public Timestamp getUpdatedTime() {
		return updatedTime;
	}


	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShoppingCart [shoppingCartId=");
		builder.append(shoppingCartId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", productId=");
		builder.append(productId);
		builder.append(", quantity=");
		builder.append(quantity);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append(", createdTime=");
		builder.append(createdTime);
		builder.append(", updatedTime=");
		builder.append(updatedTime);
		builder.append("]");
		return builder.toString();
	}


	
}
