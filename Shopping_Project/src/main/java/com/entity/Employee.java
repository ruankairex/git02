package com.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int employeeId;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "hire_date")
    private Date hireDate;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "city", length = 10)
    private String city;

    @Column(name = "district", length = 10)
    private String district;

    @Column(name = "address", length = 50)
    private String address;

    @Column(name = "department", length = 10)
    private String department;

    @Column(name = "title", length = 20)
    private String title;

    @Column(name = "db_authority", length = 10)
    private String dbAuthority;

    public Employee() {
    	
    }
    
	public Employee(String firstName, String lastName, String email, String password, String phone, Date hireDate,
			Date birthDate, String city, String district, String address, String department, String title,
			String dbAuthority) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.hireDate = hireDate;
		this.birthDate = birthDate;
		this.city = city;
		this.district = district;
		this.address = address;
		this.department = department;
		this.title = title;
		this.dbAuthority = dbAuthority;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
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

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDbAuthority() {
		return dbAuthority;
	}

	public void setDbAuthority(String dbAuthority) {
		this.dbAuthority = dbAuthority;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", password=" + password + ", phone=" + phone + ", hireDate=" + hireDate + ", birthDate="
				+ birthDate + ", city=" + city + ", district=" + district + ", address=" + address + ", department="
				+ department + ", title=" + title + ", dbAuthority=" + dbAuthority + "]";
	}

    
}
