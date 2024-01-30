package com.controller;

import java.io.IOException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.dao.PromotionDao;
import com.daoImpl.PromotionDaoImpl;
import com.entity.Promotion;
import com.util.HibernateUtil;

@WebServlet("/PromotionDataCarrierServlet")
public class PromotionDataCarrierServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		System.out.println("In PromotionDataCarrierServlet");
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		String id = request.getParameter("id");
		System.out.println("id = "+id);
		PromotionDao PromotionDao = new PromotionDaoImpl(session);
		Promotion promotion= PromotionDao.findPromotionById(Integer.parseInt(id));
		
		request.setAttribute("promotion", promotion);
		
		request.getRequestDispatcher("/PromotionForm.jsp").forward(request, response);
	}
	
	

}
