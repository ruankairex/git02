package com.entity;

import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;

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
@Table(name = "promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promotion_id")
    private int promotionId;

    @Column(name = "promotion_name", length = 255)
    private String promotionName;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "promotion_role")
    private Integer promotionRole;

    @Column(name = "promotion_p_category")
    private Integer promotionPCategory; // 可以為空的外鍵

    @Column(name = "start_date")
    private Timestamp startDate;

    @Column(name = "end_date")
    private Timestamp endDate;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
    												CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name="promotion_product_map", joinColumns = @JoinColumn(name="promotion_id"),
    											inverseJoinColumns = @JoinColumn(name="product_id"))
    private List<Product> products;

    public Promotion() {
    }

	public Promotion(String promotionName, String description, Integer promotionRole, Integer promotionPCategory,
			Timestamp startDate, Timestamp endDate) {
		super();
		this.promotionName = promotionName;
		this.description = description;
		this.promotionRole = promotionRole;
		this.promotionPCategory = promotionPCategory;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPromotionRole() {
		return promotionRole;
	}

	public void setPromotionRole(Integer promotionRole) {
		this.promotionRole = promotionRole;
	}

	public Integer getPromotionPCategory() {
		return promotionPCategory;
	}

	public void setPromotionPCategory(Integer promotionPCategory) {
		this.promotionPCategory = promotionPCategory;
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
	
	

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product theProduct) {
		if(products == null) {
			products = new ArrayList<>();
		}
		products.add(theProduct);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Promotion [promotionId=");
		builder.append(promotionId);
		builder.append(", promotionName=");
		builder.append(promotionName);
		builder.append(", description=");
		builder.append(description);
		builder.append(", promotionRole=");
		builder.append(promotionRole);
		builder.append(", promotionPCategory=");
		builder.append(promotionPCategory);
		builder.append(", startDate=");
		builder.append(startDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}

    
   
}