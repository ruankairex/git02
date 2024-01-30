package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProcessPromotionServlet")
public class ProcessPromotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request,response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");

        // 获取表单数据
        String promotionName = request.getParameter("promotionName");
        String description = request.getParameter("description");
        int promotionRole = Integer.parseInt(request.getParameter("promotionRole"));
        String promotionCategory = request.getParameter("promotionCategory");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        // 在实际应用中，这里应该执行与数据库交互的逻辑，将数据插入到数据库中

        // 输出响应
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Process Promotion</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>Process Promotion</h2>");
        out.println("<p>Promotion Name: " + promotionName + "</p>");
        out.println("<p>Description: " + description + "</p>");
        out.println("<p>Promotion Role: " + promotionRole + "</p>");
        out.println("<p>Promotion Category: " + promotionCategory + "</p>");
        out.println("<p>Start Date: " + startDate + "</p>");
        out.println("<p>End Date: " + endDate + "</p>");
        out.println("</body>");
        out.println("</html>");
		
	}

	

}
