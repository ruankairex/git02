package com.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.daoImpl.EmployeeDaoImpl;
import com.daoImpl.OrderDetailDaoImpl;
import com.daoImpl.ProductDaoImpl;
import com.util.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DataAnalysis")
public class DataAnalysis extends HttpServlet {
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
		response.setContentType("text/html;charset=UTF-8");

        SessionFactory factory = HibernateUtil.getSessionFactory();
        Session session = factory.getCurrentSession();
        
        OrderDetailDaoImpl orderDetailDao = new OrderDetailDaoImpl(session);
        List<Integer> total = orderDetailDao.selectAllQuantitiesTimesPrices();                
        int sum = 0;
        for (Integer value : total) {
            sum += value;
        }
        System.out.println("---------------------------------------------------");
        ProductDaoImpl UnitpriceStock = new ProductDaoImpl(session);
        List<Integer> total2 = UnitpriceStock.selectUnitpriceStockBycategory(3);
        int sum2 = 0;
        for (Integer value : total2) {
            sum2 += value;
        }
        System.out.println("---------------------------------------------------");
        EmployeeDaoImpl countEmployee = new EmployeeDaoImpl(session);
        long sum3 = countEmployee.countEmployeeIds();
        System.out.println("---------------------------------------------------");
        int sum4 = 0;
        String numberStr = request.getParameter("number");
        if (numberStr != null) {
            try {
                int number = Integer.parseInt(numberStr);
                ProductDaoImpl UnitpriceStock2 = new ProductDaoImpl(session);
                List<Integer> total3 = UnitpriceStock2.selectUnitpriceStockBycategory(number);            
                for (Integer value : total3) {
                    sum4 += value;
                }
            } catch (NumberFormatException e) {
                sum4 = -1; // 或者設置一個預設值，或者給出一個錯誤訊息
            }
        }
        System.out.println("---------------------------------------------------");
        int sum5 = 0;
        String numberStr2 = request.getParameter("number2");
        if (numberStr2 != null) {
        	try {
        		int number2 = Integer.parseInt(numberStr2);
        		ProductDaoImpl UnitpriceStock3 = new ProductDaoImpl(session);
        		List<Integer> total4 = UnitpriceStock3.selectUnitpriceStockBycategory(number2);            
        		for (Integer value : total4) {
        			sum5 += value;
        		}
        	} catch (NumberFormatException e) {
        		sum5 = -1; // 或者設置一個預設值，或者給出一個錯誤訊息
        	}
        }
               
        request.setAttribute("quantity", sum);
        request.setAttribute("UnitpriceStock", sum2);
        request.setAttribute("countEmployee", sum3);
        request.setAttribute("countEmployee2", sum4);
        request.setAttribute("countEmployee3", sum5);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/DataAnalysis.jsp");
    	dispatcher.forward(request, response);
	}
}
