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
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "unit_price")
    private Integer unitPrice;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "reserved_quantity")
    private Integer reservedQuantity;

    @Column(name = "listing_date")
    private Timestamp listingDate;

    @Column(name = "modified_date")
    private Timestamp modifiedDate;

    @Column(name = "description")
    private String description;

    @Column(name = "product_status")
    private String productStatus;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name="promotion_product_map", joinColumns = @JoinColumn(name="product_id"),
				inverseJoinColumns = @JoinColumn(name="promotion_id"))
    private List<Promotion> promotions;
    

	public Product() {
	}

	

	
	public Product(String productName, Integer sellerId, Integer employeeId, Integer unitPrice, Integer categoryId,
			Integer stock, Integer reservedQuantity, Timestamp listingDate, Timestamp modifiedDate, String description,
			String productStatus, List<Promotion> promotions) {
		super();
		this.productName = productName;
		this.sellerId = sellerId;
		this.employeeId = employeeId;
		this.unitPrice = unitPrice;
		this.categoryId = categoryId;
		this.stock = stock;
		this.reservedQuantity = reservedQuantity;
		this.listingDate = listingDate;
		this.modifiedDate = modifiedDate;
		this.description = description;
		this.productStatus = productStatus;
		this.promotions = promotions;
	}




	public int getProductId() {
		return productId;
	}




	public void setProductId(int productId) {
		this.productId = productId;
	}




	public String getProductName() {
		return productName;
	}




	public void setProductName(String productName) {
		this.productName = productName;
	}




	public Integer getSellerId() {
		return sellerId;
	}




	public void setSellerId(Integer sellerId) {
		this.sellerId = sellerId;
	}




	public Integer getEmployeeId() {
		return employeeId;
	}




	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}




	public Integer getUnitPrice() {
		return unitPrice;
	}




	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}




	public Integer getCategoryId() {
		return categoryId;
	}




	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}




	public Integer getStock() {
		return stock;
	}




	public void setStock(Integer stock) {
		this.stock = stock;
	}




	public Integer getReservedQuantity() {
		return reservedQuantity;
	}




	public void setReservedQuantity(Integer reservedQuantity) {
		this.reservedQuantity = reservedQuantity;
	}




	public Timestamp getListingDate() {
		return listingDate;
	}




	public void setListingDate(Timestamp listingDate) {
		this.listingDate = listingDate;
	}




	public Timestamp getModifiedDate() {
		return modifiedDate;
	}




	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public String getProductStatus() {
		return productStatus;
	}




	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}




	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}
	
	public void addProduct(Promotion thePromotion) {
		if(promotions == null) {
			promotions = new ArrayList<>();
		}
		promotions.add(thePromotion);
	}




	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [productId=");
		builder.append(productId);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", sellerId=");
		builder.append(sellerId);
		builder.append(", employeeId=");
		builder.append(employeeId);
		builder.append(", unitPrice=");
		builder.append(unitPrice);
		builder.append(", categoryId=");
		builder.append(categoryId);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", reservedQuantity=");
		builder.append(reservedQuantity);
		builder.append(", listingDate=");
		builder.append(listingDate);
		builder.append(", modifiedDate=");
		builder.append(modifiedDate);
		builder.append(", description=");
		builder.append(description);
		builder.append(", productStatus=");
		builder.append(productStatus);
		builder.append(", promotions=");
		builder.append(promotions);
		builder.append("]");
		return builder.toString();
	}

	

    
}
