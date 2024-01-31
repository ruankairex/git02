package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;

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
public class HRCreateNewEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		EmployeeServiceImpl empService = new EmployeeServiceImpl(session);

		String lastName = request.getParameter("empLastName");
		String firstName = request.getParameter("empFirstName");
		String email = request.getParameter("empMail");
		String password = request.getParameter("empPwd");
		String phone = request.getParameter("empPhone");
		String hire = request.getParameter("empHire");//從表單取值
		String birth = request.getParameter("empBirth");
		String city = request.getParameter("empCity");
		String district = request.getParameter("empDistrict");
		String address = request.getParameter("empAddress");
		String department = request.getParameter("EmpDept");
		String title = request.getParameter("EmpTitle");
		String Auth = request.getParameter("EmpAuth");

		
		
		/////////////////////////////////////////////////////////////
		LocalDate localhire = LocalDate.parse(hire, DateTimeFormatter.ofPattern("yyyy/MM/dd"));
		LocalDate localbirth = LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy/MM/dd"));

        // 轉換為 Date 物件 (註:只要存 取 年月日的話 要使用 java.sql.Date)

		 java.sql.Date hireDate = java.sql.Date.valueOf(localhire);
		 java.sql.Date birthDate = java.sql.Date.valueOf(localhire);

		System.out.println("原始字串: " + hire);
		System.out.println("轉換後 Date: " + hireDate);

		/////////////////////////////////////////////////////
		// 將取到的權限加上部門英文
		String dbAuthority="";
		switch (department) {
		case "人事部":
			dbAuthority = "HR" + Auth;
			break;
		case "營業部":
			dbAuthority = "C" + Auth;
			break;
		case "客服部":
			dbAuthority = "S" + Auth;
			break;
		case "營銷部":
			dbAuthority = "M" + Auth;
			break;
		case "貨運部":
			dbAuthority = "O" + Auth;
			break;

		}

		/////////////////////////////////////////////////////

		Employee insertBean = new Employee();

		insertBean.setFirstName(firstName);
		insertBean.setLastName(lastName);
		insertBean.setEmail(email);
		insertBean.setPassword(password);
		insertBean.setPhone(phone);
		insertBean.setHireDate(hireDate);
		insertBean.setBirthDate(birthDate);
		insertBean.setCity(city);
		insertBean.setDistrict(district);
		insertBean.setAddress(address);
		insertBean.setDepartment(department);
		insertBean.setTitle(title);
		insertBean.setDbAuthority(dbAuthority);

		Employee result = empService.insert(insertBean);
		if (result != null) {
			System.out.println("SUCESS");
//			out.write("成功儲存員工success");
		}

		System.out.println("--------------------------");
		response.sendRedirect(request.getContextPath() + "/HRSystemMainPage.do");

	}

}
