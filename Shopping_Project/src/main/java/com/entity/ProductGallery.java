package com.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_gallery")
public class ProductGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "img_id")
    private int imgId;

    @Column(name = "img_path", nullable = false)
    private String imgPath;

    @Column(name = "img_description")
    private String imgDescription;

    
    @Column(name = "product_id")
    private Integer productId;

   
    public ProductGallery() {
    }


	public ProductGallery(int imgId, String imgPath, String imgDescription, int productId) {
		super();
		this.imgId = imgId;
		this.imgPath = imgPath;
		this.imgDescription = imgDescription;
		this.productId = productId;
	}


	public int getImgId() {
		return imgId;
	}


	public void setImgId(int imgId) {
		this.imgId = imgId;
	}


	public String getImgPath() {
		return imgPath;
	}


	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


	public String getImgDescription() {
		return imgDescription;
	}


	public void setImgDescription(String imgDescription) {
		this.imgDescription = imgDescription;
	}


	public Integer getProductId() {
		return productId;
	}


	public void setProductId(Integer productId) {
		this.productId = productId;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProductGallery [imgId=");
		builder.append(imgId);
		builder.append(", imgPath=");
		builder.append(imgPath);
		builder.append(", imgDescription=");
		builder.append(imgDescription);
		builder.append(", productId=");
		builder.append(productId);
		builder.append("]");
		return builder.toString();
	}

    
}
