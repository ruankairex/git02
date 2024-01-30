package com.controller;
import java.text.ParseException;
import com.dao.PromotionDao;
import com.daoImpl.PromotionDaoImpl;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.IOException;
import com.entity.Promotion;
import com.util.HibernateUtil;

import java.sql.Timestamp;

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
		try {
			processAction(request,response);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processAction(request,response);
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ParseException {
		
		
		
		String promotionId = request.getParameter("promotionId");
        String promotionName = request.getParameter("promotionName");
        String description = request.getParameter("description");
        int promotionRole = Integer.parseInt(request.getParameter("promotionRole"));
        String promotionCategory = request.getParameter("promotionPCategory");
        
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        LocalDateTime startDateTime = LocalDateTime.parse(startDateStr, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(endDateStr, formatter);
        Timestamp startTimestamp = Timestamp.valueOf(startDateTime);
        Timestamp endTimestamp = Timestamp.valueOf(endDateTime);

        Promotion thePormotion = new Promotion();
        thePormotion.setPromotionName(promotionName);
        thePormotion.setDescription(description);
        thePormotion.setPromotionRole(promotionRole);
        thePormotion.setPromotionPCategory(Integer.parseInt(promotionCategory));
        thePormotion.setStartDate(startTimestamp);
        thePormotion.setEndDate(endTimestamp);
        System.out.println(thePormotion.toString());
        
        SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
        PromotionDao thePromotionDao = new PromotionDaoImpl(session);
        
        
        
		
	}

	

}
