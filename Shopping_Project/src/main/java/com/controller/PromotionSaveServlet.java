package com.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PromotionSaveServlet")
public class PromotionSaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) {
		String promotionName = request.getParameter("promotionName");
        String description = request.getParameter("description");
        int promotionRole = Integer.parseInt(request.getParameter("promotionRole"));
        String promotionCategory = request.getParameter("promotionCategory");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        
        
	}

}
