package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "review_failed")
public class ReviewFailed {

    @Id
    @Column(name = "product_id")
    private int productId;

    @Column(name = "failed_reason", length = 255)
    private String failedReason;

    public ReviewFailed() {
    }

	public ReviewFailed(int productId, String failedReason) {
		super();
		this.productId = productId;
		this.failedReason = failedReason;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getFailedReason() {
		return failedReason;
	}

	public void setFailedReason(String failedReason) {
		this.failedReason = failedReason;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReviewFailed [productId=");
		builder.append(productId);
		builder.append(", failedReason=");
		builder.append(failedReason);
		builder.append("]");
		return builder.toString();
	}

    
}