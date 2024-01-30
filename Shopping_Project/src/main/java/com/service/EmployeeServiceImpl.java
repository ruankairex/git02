package com.service;

import java.util.List;

import org.hibernate.Session;

import com.daoImpl.EmployeeDaoImpl;
import com.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDaoImpl empDao;

	public EmployeeServiceImpl() {
		
	}

	public EmployeeServiceImpl(Session session) {
		empDao = new EmployeeDaoImpl(session);
	}

	@Override
	public void selectById(int id) {
		empDao.selectById(id);

	}
	
	public Employee selectById2(int id) {
		return empDao.selectById2(id);
	}

	@Override
	public List<Employee> selectAll() {
		return empDao.selectAll();
	}

	@Override
	public Employee insert(Employee employee) {
		return empDao.insert(employee);
		 
	}

	@Override
	public Employee updateName(int id, String employeeFirstName, String employeeLastName) {
		return empDao.updateName(id, employeeFirstName, employeeLastName);
	}

	@Override
	public Employee updatePhone(int id, String phone) {
		return empDao.updatePhone(id, phone);
	}

	@Override
	public Employee updateAddress(int id, String city, String district, String address) {
		return empDao.updateAddress(id, city, district, address);
	}

	@Override
	public Employee updatePwd(int id, String password) {
		return empDao.updatePwd(id, password);
	}

	@Override
	public Employee updateAuthority(int id, String Authority) {
		return empDao.updateAuthority(id, Authority);
	}

	@Override
	public Employee updateTitle(int id, String title) {
		return empDao.updateTitle(id, title);
	}

	@Override
	public Employee updateDept(int id, String dept, String title) {
		return empDao.updateDept(id, dept, title);
	}

	@Override
	public boolean delete(int employeeId) {
		return empDao.delete(employeeId);
	}



}
