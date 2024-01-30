package com.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.daoImpl.PromotionDaoImpl;
import com.dao.PromotionDao;
import com.util.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.entity.Promotion;

@WebServlet("/PromotionFindAllServlet")
public class PromotionFindAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		PromotionDao thePromotionDao = new PromotionDaoImpl(session);
		List<Promotion> promotions = thePromotionDao.findAll();
		request.setAttribute("promotions", promotions);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/PromotionPage.jsp");
        dispatcher.forward(request, response);
	}
}
