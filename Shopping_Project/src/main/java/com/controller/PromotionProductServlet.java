package com.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.PromotionDao;
import com.daoImpl.PromotionDaoImpl;
import com.entity.Product;
import com.entity.Promotion;
import com.util.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PromotionProductServlet")
public class PromotionProductServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   
        String promotionId = request.getParameter("promotionId");

        SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		PromotionDao promotionDao = new PromotionDaoImpl(session);
		Promotion thePromotion= promotionDao.findPromotionById(Integer.parseInt(promotionId));
		List<Product> products = thePromotion.getProducts();
		
		request.setAttribute("Products", products);
		request.setAttribute("promotionId", promotionId);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/PromotionProductList.jsp");
	    dispatcher.forward(request, response);
        
    }
}
