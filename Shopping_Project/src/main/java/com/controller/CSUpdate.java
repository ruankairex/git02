package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.User;
import com.entity.empPass;
import com.service.UserBeanService;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "UpdateUserServlet", urlPatterns = { "/S2Update.do" })
public class CSUpdate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processAction(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processAction(request, response);
    }

    private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


		SessionFactory factry = HibernateUtil.getSessionFactory();
		Session session = factry.getCurrentSession();
		
		
		HttpSession hsession = request.getSession();
		empPass pass = (empPass) hsession.getAttribute("HRsystemPass");
		
		// 拿到登入者的title
		
		String dept = pass.getDepartment();
		String title = pass.getTitle();
		
		request.setAttribute("dept", dept);
		hsession.setAttribute("title", title);
		
		
		UserBeanService uService = new UserBeanService(session);
        
		int userId = Integer.parseInt(request.getParameter("userId"));
        Integer buyerViolationCount = Integer.parseInt(request.getParameter("buyerViolationCount"));
		Integer sellerViolationCount = Integer.parseInt(request.getParameter("sellerViolationCount"));
		Integer sellerQualified = Integer.parseInt(request.getParameter("userSellerQualified"));
        String userStatus = request.getParameter("userStatus");
        
       
        User u = uService.selectById(userId);

//            UserBean user = new UserBean();
//
//            user.setId(userId);
//            user.setName(username);
//            user.setUserPassword(userPassword);
//            user.setBuyerViolationCount(buyerViolationCount);
//            user.setSellerViolationCount(sellerViolationCount);
//            user.setSellerQualified(sellerQualified);
//            user.setUserStatus(userStatus);
            User updatedUser = uService.update(userId, u.getLastName(), u.getFirstName(), u.getUserEmail(), 
            		u.getUserPassword(), buyerViolationCount, u.getLastLoginTime(), sellerQualified, u.getCardNumber(), u.getCardCVCCode()
    				, u.getCardExpiryDate(), u.getCardHolderName(), u.getCity(), u.getDistrict(), u.getAddress(), u.getBankAccount(), 
    				u.getSellerDate(), sellerViolationCount, userStatus);

            if (updatedUser != null) {
                response.sendRedirect("CSMainPage.do");
            } else {
                out.println("updatedUser == null");
            }
            out.close();
        }

}
