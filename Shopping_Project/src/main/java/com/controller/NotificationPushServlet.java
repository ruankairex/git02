package com.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dao.PushNotificationDao;
import com.daoImpl.PushNotificationDaoImpl;
import com.entity.PushNotification;
import com.entity.User;
import com.service.UserBeanService;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/NotificationPushServlet")
public class NotificationPushServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proceaaAction(request,response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proceaaAction(request,response);
	}

	private void proceaaAction(HttpServletRequest request, HttpServletResponse response) {
		String notificationId = request.getParameter("notificationId");
		
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		UserBeanService uService = new UserBeanService(session);
		PushNotificationDao thePushNotificationDao = new PushNotificationDaoImpl(session);
		PushNotification thePushNotification = thePushNotificationDao.findPushNotificationById(Integer.parseInt(notificationId));
		
		List<User> userLists = uService.selectAll();
		
		
		
		
	}
	
	
}
