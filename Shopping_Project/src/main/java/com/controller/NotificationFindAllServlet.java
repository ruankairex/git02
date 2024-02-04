package com.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.PushNotificationDao;
import com.daoImpl.PushNotificationDaoImpl;
import com.util.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.entity.PushNotification;

@WebServlet("/NotificationFindAll")
public class NotificationFindAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
    	
    	proceaaAction(request,response);
    }

	private void proceaaAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		PushNotificationDao thePushNotificationDao = new PushNotificationDaoImpl(session);
		List<PushNotification> notificList = thePushNotificationDao.findAllPushNotifications();
		request.setAttribute("notificList", notificList);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/PushNotification.jsp");
        dispatcher.forward(request, response);
	}
}
