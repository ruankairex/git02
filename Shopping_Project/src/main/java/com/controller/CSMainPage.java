package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.entity.User;
import com.entity.empPass;
import com.service.EmployeeServiceImpl;
import com.service.UserBeanService;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ServUserUpdate", urlPatterns = { "/CSMainPage.do" })
public class CSMainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		SessionFactory factry = HibernateUtil.getSessionFactory();
		Session session = factry.getCurrentSession();
		
		UserBeanService uService = new UserBeanService(session);
		List<User> userLists = uService.selectAll();
		
		HttpSession hsession = request.getSession();
		empPass pass = (empPass) hsession.getAttribute("HRsystemPass");
		request.setAttribute("loginPass", pass);
		
		request.setAttribute("Userslist", userLists);
		request.getRequestDispatcher("/CSSystemMainPage.jsp").forward(request, response);
		
		out.close();
	}

}
