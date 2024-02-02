package com.controller;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtil;

import com.dao.PromotionDao;
import com.daoImpl.PromotionDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PromotionDeleteServlet")
public class PromotionDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processAction(req,resp);
	}

	private void processAction(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		System.out.println("In Delete Servlet");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		PromotionDao thePromotionDao = new PromotionDaoImpl(session);
		thePromotionDao.deletePromotionById(Integer.parseInt(id));
		
	    System.out.println("--------------------------");
	    resp.sendRedirect(req.getContextPath() + "/PromotionFindAllServlet");
		
		
	}

	
	
}
