package com.controller;

import java.io.IOException;

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
@WebServlet("/HRUpdatePwdPage.do")
public class HRUpdatePassword  extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("empid"));
		System.out.println("即將更新"+id+"號員工密碼");
		
		String updatePwd = request.getParameter("empPwd");
		
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		EmployeeServiceImpl empService = new EmployeeServiceImpl(session);
		Employee updateEmp = empService.updatePwd(id, updatePwd);
		
		if (updateEmp != null) {
			System.out.println("SUCESS");
//			out.write("成功儲存員工success");
		}

		System.out.println("--------------------------");
		response.sendRedirect(request.getContextPath() + "/HRSystemMainPage.do");
	}

}
