package com.controller;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.service.EmployeeServiceImpl;
import com.util.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HRUpdateAuth.do")
public class HRUpdateAuth extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		Integer id = Integer.parseInt(request.getParameter("id"));
		System.out.println("即將更新"+id+"號員工權限");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		EmployeeServiceImpl empService = new EmployeeServiceImpl(session);
		Employee updateEmp = empService.selectById2(id);//傳回一個此員工原始資料物件
		request.setAttribute("updateEmp", updateEmp);//設成request屬性丟給jsp處理
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updateAuthForm.jsp");
		dispatcher.forward(request, response);
	}
}
