package com.entity;

import java.sql.Timestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "push_notification")
public class PushNotification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private int notificationId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Column(name = "product_link", length = 255)
    private String productLink;

    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    public PushNotification() {
    }

	public PushNotification(int notificationId, Integer userId, String message, String productLink, Timestamp createdAt) {
		super();
		this.notificationId = notificationId;
		this.userId = userId;
		this.message = message;
		this.productLink = productLink;
		this.createdAt = createdAt;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getProductLink() {
		return productLink;
	}

	public void setProductLink(String productLink) {
		this.productLink = productLink;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PushNotification [notificationId=");
		builder.append(notificationId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", message=");
		builder.append(message);
		builder.append(", productLink=");
		builder.append(productLink);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append("]");
		return builder.toString();
	}

    
}
