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

@WebServlet("/HRSaveAuth.do")
public class HRSaveAuth extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("=============in HRSaveAuth=============");
		int employeeId =Integer.parseInt(request.getParameter("employeeId"));
		String authNum = request.getParameter("dbAuthority");
		String authOriginal = request.getParameter("dbAuthorityOriginal");
		String dept = authOriginal.substring(0, authOriginal.length() - 1);
		String updateAuth=dept+authNum;
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		EmployeeServiceImpl empService = new EmployeeServiceImpl(session);
		Employee updateResult = empService.updateAuthority(employeeId, updateAuth);
		if(updateResult!=null) {
			System.out.println(updateResult);
		}else {
			System.out.println("no target");
		}
		response.sendRedirect(request.getContextPath() + "/HRSystemMainPage.do");
		
	}

}
