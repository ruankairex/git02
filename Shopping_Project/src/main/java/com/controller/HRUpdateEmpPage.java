package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.entity.empPass;
import com.service.EmployeeServiceImpl;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HRUpdateEmpPage.do")
public class HRUpdateEmpPage extends HttpServlet {
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
		System.out.println("In FindAllServlet");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
	
		HttpSession hsession = request.getSession();
		empPass pass = (empPass) hsession.getAttribute("HRsystemPass");
		
		String dept = pass.getDepartment();
//		String title = pass.getTitle();
		
		request.setAttribute("dept", dept);
//		hsession.setAttribute("title", title);

		EmployeeServiceImpl empService = new EmployeeServiceImpl(session);
		List<Employee> lists = empService.selectAll();
		request.setAttribute("allEmp", lists);
		
		
		//Iterator<Employee> emps = lists.iterator();
		
		

		request.getRequestDispatcher("HRUpdateEmpForm.jsp").forward(request, response);
		out.close();

	}

}
