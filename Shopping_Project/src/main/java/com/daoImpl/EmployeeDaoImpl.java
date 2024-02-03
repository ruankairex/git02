package com.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.dao.EmployeeDao;
import com.entity.Employee;



public class EmployeeDaoImpl implements EmployeeDao {

	private Session session;
	
	public EmployeeDaoImpl() {

	}

	public EmployeeDaoImpl(Session session) {
		this.session = session;
	}

	
//////////////////////////////////////R //////////////////////////////////////////////
	@Override
	public void selectById(int id) {
		Employee resultBean = session.get(Employee.class, id);
		if(resultBean!=null) {
			System.out.println(resultBean);
		}else {
			System.out.println("no result");
		}

	}
	
	@Override
	public Employee selectById2(int id) {
		Employee resultBean = session.get(Employee.class, id);
		if(resultBean!=null) {
			return resultBean;
		}else {
			return null;			
		}
	}

	@Override
	public List<Employee> selectAll() {
		Query<Employee> query = session.createQuery("from Employee",Employee.class);
		List<Employee> lists = query.list();
		return lists;
	}

	
//////////////////////////////////////C //////////////////////////////////////////////
	@Override
	public Employee insert(Employee employeebean) {
		if(employeebean!=null) { //如果沒有的話
			session.save(employeebean);// 就新增物件進去
		}
		return employeebean;// 回傳帶有id的物件
	}
	
//////////////////////////////////////U //////////////////////////////////////////////

	@Override
	public Employee updateName(int id, String employeeFirstName, String employeeLastName) {
		Employee result = session.get(Employee.class, id);
		if(result!=null) {
			result.setFirstName(employeeFirstName);
			result.setLastName(employeeLastName);
		}
		return result;
	}


	@Override
	public Employee updatePhone(int id, String phone) {
		Employee result = session.get(Employee.class, id);
		if(result!=null) {
			result.setPhone(phone);
		}
		return result;
	}

	@Override
	public Employee updateAddress(int id, String city, String district, String address) {
		Employee result = session.get(Employee.class, id);
		if(result!=null) {
			result.setCity(city);
			result.setDistrict(district);
			result.setAddress(address);
		}
		return result;
	}

	@Override
	public Employee updatePwd(int id, String password) {
		Employee result = session.get(Employee.class, id);
		if(result!=null) {
			result.setPassword(password);
		}
		return result;
	}

	@Override
	public Employee updateAuthority(int id, String Authority) {
		Employee result = session.get(Employee.class, id);
		if(result!=null) {
			result.setDbAuthority(Authority);
		}
		return result;
	}

	@Override
	public Employee updateTitle(int id, String title) {
		Employee result = session.get(Employee.class, id);
		if(result!=null) {
			result.setTitle(title);
		}
		return result;
	}

	@Override
	public Employee updateDept(int id, String dept, String title) {
		Employee result = session.get(Employee.class, id);
		if(result!=null) {
			result.setDepartment(dept);
			result.setTitle(title);
		}
		return result;
	}

//////////////////////////////////////D //////////////////////////////////////////////
	@Override
	public boolean delete(int employeeId) {
		Employee deleteBean = session.get(Employee.class, employeeId);
		if(deleteBean!=null) {
			session.remove(deleteBean);
			return true;
		}
		return false;
	}
	
	 @Override  //統計員工數量
	    public long countEmployeeIds() {
		 Query<Number> query = session.createQuery("SELECT COUNT(e.employeeId) FROM Employee e", Number.class);
	        return query.uniqueResult().intValue();
	    }


}
