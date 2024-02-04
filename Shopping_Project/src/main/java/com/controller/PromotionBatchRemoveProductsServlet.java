package com.controller;

import java.io.IOException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.ProductDao;
import com.dao.PromotionDao;
import com.daoImpl.ProductDaoImpl;
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

@WebServlet("/PromotionBatchRemoveProductsServlet")
public class PromotionBatchRemoveProductsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}


	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String[] selectedProductIds = request.getParameterValues("selectedProducts");
		String promotionId = (String)request.getParameter("promotionId");

        if (selectedProductIds != null && selectedProductIds.length > 0) {
        	SessionFactory factory = HibernateUtil.getSessionFactory();
    		Session session = factory.getCurrentSession();
    		PromotionDao PromotionDao = new PromotionDaoImpl(session);
    		ProductDao ProductDao = new ProductDaoImpl(session);
    		
    		Promotion tmpPromotion = PromotionDao.findPromotionById(Integer.parseInt(promotionId));
            for (String productId : selectedProductIds) {  	
        		Product tmpProduct = ProductDao.findProductById(Integer.parseInt(productId));
        		
        		tmpPromotion.removeProduct(tmpProduct);
            }
            request.setAttribute("promotionId",promotionId);
    		
            RequestDispatcher dispatcher = request.getRequestDispatcher("/PromotionProductServlet");
    	    dispatcher.forward(request,response);
        } else {
            // 如果沒有選中商品，可以執行相應的處理，例如顯示錯誤訊息
            response.getWriter().println("未選擇任何商品。");
        }
		
	}
}
