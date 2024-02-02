package com.controller;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.dao.ProductDao;
import com.dao.PromotionDao;
import com.daoImpl.ProductDaoImpl;
import com.daoImpl.PromotionDaoImpl;
import com.entity.Product;
import com.entity.Promotion;

@WebServlet("/PromotionProductDeleteServlet")
public class PromotionProductDeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processAction(req,resp);
	}

	private void processAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String productId = (String)req.getParameter("id");
		String promotionId = (String)req.getParameter("promotionId");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		PromotionDao PromotionDao = new PromotionDaoImpl(session);
		ProductDao ProductDao = new ProductDaoImpl(session);
		
		Promotion tmpPromotion = PromotionDao.findPromotionById(Integer.parseInt(promotionId));
		Product tmpProduct = ProductDao.findProductById(Integer.parseInt(productId));
	
		boolean res = tmpPromotion.removeProduct(tmpProduct);
		req.setAttribute("promotionId",promotionId);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/PromotionProductServlet");
	    dispatcher.forward(req, resp);
	}

	
}
