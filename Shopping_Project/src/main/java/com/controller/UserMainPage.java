package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.daoImpl.ProductDaoImpl;
import com.entity.Employee;
import com.entity.Product;
import com.entity.UserPass;
import com.entity.empPass;
import com.service.EmployeeServiceImpl;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "UserMainPage", urlPatterns = { "/UserMainPage.do" })
public class UserMainPage extends HttpServlet {
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

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();

		HttpSession hsession = request.getSession();
		UserPass pass = (UserPass) hsession.getAttribute("UsersystemPass");
		request.setAttribute("loginPass", pass);

		ProductDaoImpl product = new ProductDaoImpl(session);
		List<Product> lists = product.selectAll();
		request.setAttribute("Product", lists);
	

		

		request.getRequestDispatcher("/UserSystemMainPage.jsp").forward(request, response);
		out.close();
	}

}
