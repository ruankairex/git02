package com.dao;

import java.util.List;

import com.entity.Employee;

public interface EmployeeDao {

	//R
	public void selectById(int id);//get
	
	public Employee selectById2(int id);
	
	public List<Employee> selectAll();
	
	//C
	public Employee insert(Employee employee);
	
	
	//U
	//1.員工改名
	public Employee updateName(int id, String employeeFirstName, String employeeLastName);//改名

	//2.員工更改電話
	public Employee updatePhone(int id, String phone);
	
	//3.員工更改住址
	public Employee updateAddress(int id, String city,String district,String address);
	
	//4.員工更改密碼
	public Employee updatePwd(int id, String password);

	//5.主管更改員工權限
	public Employee updateAuthority(int id, String Authority);
	
	//6.人事部更改員工職位
	public Employee updateTitle(int id, String title);
	
	//7.人事部更改員工調換部門及職位
	public Employee updateDept(int id, String dept,String title);
	
	
	
	//D
	public boolean delete(int employeeId);

	
	
	
}
