package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Product;
import com.entity.empPass;
import com.service.ProductBeanService;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet( urlPatterns = { "/ProductVerify.do" }, name = "UpdateProductServlet")
public class ProductVerifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
		
		SessionFactory factry = HibernateUtil.getSessionFactory();
		Session session = factry.getCurrentSession();
		
		HttpSession hsession = request.getSession();
		empPass pass = (empPass) hsession.getAttribute("HRsystemPass");
		
		int eId = pass.getEmployeeId();
		
		ProductBeanService pbService = new ProductBeanService(session);
		
		int pId = Integer.parseInt(request.getParameter("pId"));
		String status = request.getParameter("verification");
		
		Product pd = pbService.selectById(pId);
		
		Product productUpdate = pbService.update(pId, pd.getProductName(), pd.getSellerId(), eId, pd.getUnitPrice(), pd.getCategoryId(),
												pd.getStock(), pd.getReservedQuantity(), pd.getListingDate(), pd.getModifiedDate(),
												pd.getDescription(), status);
		if(productUpdate!=null) {
			response.sendRedirect(request.getContextPath() + "/ProductInformation.do");
		}else {
			out.println("updatedUser == null");
		}
		out.close();
		
	}
	
}
