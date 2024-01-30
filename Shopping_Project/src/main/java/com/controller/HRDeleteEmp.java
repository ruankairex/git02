package com.controller;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.service.EmployeeServiceImpl;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteEmp.do")
public class HRDeleteEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("即將刪除"+id+"號員工");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		EmployeeServiceImpl empService = new EmployeeServiceImpl(session);
		System.out.println("--------------------------");
		boolean result = empService.delete(id);
		System.out.println(" in DeleteEmp.do delete result: "+result);
	    response.sendRedirect(request.getContextPath() + "/HRSystemMainPage.do");
		
	}

}
