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
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "user_email", unique = true, nullable = false)
    private String userEmail;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "hire_date")
    private Timestamp hireDate;

    @Column(name = "buyer_violation_count")
    private Integer buyerViolationCount;

    @Column(name = "last_login_time")
    private Timestamp lastLoginTime;

    @Column(name = "seller_qualified")
    private Integer sellerQualified;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_CVC_code")
    private String cardCVCCode;

    @Column(name = "card_expiry_date")
    private Timestamp cardExpiryDate;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "address")
    private String address;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "seller_date")
    private Timestamp sellerDate;

    @Column(name = "seller_violation_count")
    private Integer sellerViolationCount;

    @Column(name = "user_status")
    private String userStatus;
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE,
			CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name="coupon_user_map", joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="coupon_id"))
    private List<Coupon> coupons;

    public User() {
    	
    }

	

	public User(String lastName, String firstName, String userEmail, String userPassword, Timestamp hireDate,
			Integer buyerViolationCount, Timestamp lastLoginTime, Integer sellerQualified, String cardNumber,
			String cardCVCCode, Timestamp cardExpiryDate, String cardHolderName, String city, String district,
			String address, String bankAccount, Timestamp sellerDate, Integer sellerViolationCount, String userStatus,
			List<Coupon> coupons) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.hireDate = hireDate;
		this.buyerViolationCount = buyerViolationCount;
		this.lastLoginTime = lastLoginTime;
		this.sellerQualified = sellerQualified;
		this.cardNumber = cardNumber;
		this.cardCVCCode = cardCVCCode;
		this.cardExpiryDate = cardExpiryDate;
		this.cardHolderName = cardHolderName;
		this.city = city;
		this.district = district;
		this.address = address;
		this.bankAccount = bankAccount;
		this.sellerDate = sellerDate;
		this.sellerViolationCount = sellerViolationCount;
		this.userStatus = userStatus;
		this.coupons = coupons;
	}
	
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getUserEmail() {
		return userEmail;
	}



	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}



	public String getUserPassword() {
		return userPassword;
	}



	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}



	public Timestamp getHireDate() {
		return hireDate;
	}



	public void setHireDate(Timestamp hireDate) {
		this.hireDate = hireDate;
	}



	public Integer getBuyerViolationCount() {
		return buyerViolationCount;
	}



	public void setBuyerViolationCount(Integer buyerViolationCount) {
		this.buyerViolationCount = buyerViolationCount;
	}



	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}



	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}



	public Integer getSellerQualified() {
		return sellerQualified;
	}



	public void setSellerQualified(Integer sellerQualified) {
		this.sellerQualified = sellerQualified;
	}



	public String getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}



	public String getCardCVCCode() {
		return cardCVCCode;
	}



	public void setCardCVCCode(String cardCVCCode) {
		this.cardCVCCode = cardCVCCode;
	}



	public Timestamp getCardExpiryDate() {
		return cardExpiryDate;
	}



	public void setCardExpiryDate(Timestamp cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}



	public String getCardHolderName() {
		return cardHolderName;
	}



	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
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



	public String getBankAccount() {
		return bankAccount;
	}



	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}



	public Timestamp getSellerDate() {
		return sellerDate;
	}



	public void setSellerDate(Timestamp sellerDate) {
		this.sellerDate = sellerDate;
	}



	public Integer getSellerViolationCount() {
		return sellerViolationCount;
	}



	public void setSellerViolationCount(Integer sellerViolationCount) {
		this.sellerViolationCount = sellerViolationCount;
	}



	public String getUserStatus() {
		return userStatus;
	}



	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}



	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}
	
	public void addCoupon(Coupon theCoupon) {
		if(coupons == null) {
			coupons = new ArrayList<>();
		}
		coupons.add(theCoupon);
	}



	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [userId=");
		builder.append(userId);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", userEmail=");
		builder.append(userEmail);
		builder.append(", userPassword=");
		builder.append(userPassword);
		builder.append(", hireDate=");
		builder.append(hireDate);
		builder.append(", buyerViolationCount=");
		builder.append(buyerViolationCount);
		builder.append(", lastLoginTime=");
		builder.append(lastLoginTime);
		builder.append(", sellerQualified=");
		builder.append(sellerQualified);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", cardCVCCode=");
		builder.append(cardCVCCode);
		builder.append(", cardExpiryDate=");
		builder.append(cardExpiryDate);
		builder.append(", cardHolderName=");
		builder.append(cardHolderName);
		builder.append(", city=");
		builder.append(city);
		builder.append(", district=");
		builder.append(district);
		builder.append(", address=");
		builder.append(address);
		builder.append(", bankAccount=");
		builder.append(bankAccount);
		builder.append(", sellerDate=");
		builder.append(sellerDate);
		builder.append(", sellerViolationCount=");
		builder.append(sellerViolationCount);
		builder.append(", userStatus=");
		builder.append(userStatus);
		builder.append(", coupons=");
		builder.append(coupons);
		builder.append("]");
		return builder.toString();
	}

}