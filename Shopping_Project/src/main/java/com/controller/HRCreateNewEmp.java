package com.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import com.entity.Employee;
import com.service.EmployeeServiceImpl;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/HRCreateNewEmp.do")
public class HRCreateNewEmp extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		EmployeeServiceImpl empService = new EmployeeServiceImpl(session);
		
		String lastName = request.getParameter("empLastName");
		String firstName = request.getParameter("empFirstName");
		String email = request.getParameter("empMail");
		String password = request.getParameter("empPwd");
		String phone = request.getParameter("empPhone");
		String hireDate = request.getParameter("empHire");
		String birthDate = request.getParameter("empBirth");
		String city = request.getParameter("empCity");
		String district = request.getParameter("empDistrict");
		String address = request.getParameter("empAddress");
		String department = request.getParameter("EmpDept");
		String title = request.getParameter("EmpTitle");
		String dbAuthority = request.getParameter("EmpAuth");
		
		//轉字串為timestamp
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
            // 將字串轉換為 Date 對象
            Date parsedhireDate = dateFormat.parse(hireDate);
            Date parsedbirthDate = dateFormat.parse(birthDate);

            // 將 Date 對象轉換為 Timestamp 對象
            Timestamp hireDateTimestamp = new Timestamp(parsedhireDate.getTime());
            Timestamp birthDateTimestamp = new Timestamp(parsedbirthDate.getTime());

            System.out.println("原始字符串: " + hireDate);
            System.out.println("轉換後 Timestamp: " + hireDateTimestamp);
            
            /////////////////////////////////////////////////////

            Employee insertBean = new Employee();
            
            insertBean.setFirstName(firstName);
            insertBean.setLastName(lastName);
            insertBean.setEmail(email);
            insertBean.setPassword(password);
            insertBean.setPhone(phone);
            insertBean.setHireDate(hireDateTimestamp);
            insertBean.setBirthDate(birthDateTimestamp);
            insertBean.setCity(city);
            insertBean.setDistrict(district);
            insertBean.setAddress(address);
            insertBean.setDepartment(department);
            insertBean.setTitle(title);
            insertBean.setDbAuthority(dbAuthority);
            
            Employee result = empService.insert(insertBean);
            if (result != null) {
            	System.out.println("SUCESS");
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
		
		
		System.out.println("--------------------------");
	    response.sendRedirect(request.getContextPath() + "/FindAllServlet");
		
		
	}
	
	

}
