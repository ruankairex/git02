package com.controller;

import java.io.IOException;

import com.dao.PushNotificationDao;
import com.daoImpl.PushNotificationDaoImpl;
import com.entity.PushNotification;
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

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


@WebServlet("/NotificationAddServlet")
public class NotificationAddServlet extends HttpServlet {

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
		
		
        String message = request.getParameter("message");
        String productLink = request.getParameter("productLink");
        
//        HttpSession hsession = request.getSession();
//        empPass emp= (empPass)hsession.getAttribute("HRsystemPass");
//        int empId = emp.getEmployeeId();
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		UserBeanService uService = new UserBeanService(session);
		List<User> userLists = uService.selectAll();
		
		 
		
		session.getTransaction().commit();
		if(userLists != null) {
			for(User user:userLists) {
				SessionFactory factory1 = HibernateUtil.getSessionFactory();
				Session session1 = factory1.getCurrentSession();
				session1.beginTransaction();
				
				PushNotification newNotification = new PushNotification(); 
				System.out.println(user.getUserId());
				PushNotificationDao thePushNotificationDao = new PushNotificationDaoImpl(session1);
				newNotification.setUserId(user.getUserId());
		        newNotification.setMessage(message);
		        newNotification.setProductLink(productLink);
		        Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		        newNotification.setCreatedAt(currentTime);
		        thePushNotificationDao.insertNotification(newNotification);
		        
		        
		        session1.getTransaction().commit();
		        
			}
		}
		
        
        
        
        
        
		
		
	
		
		response.sendRedirect(request.getContextPath() + "/NotificationFindAll");
		
	}
	
	

}
