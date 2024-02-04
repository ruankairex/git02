package com.controller;

import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.dao.CouponDao;
import com.daoImpl.CouponDaoImpl;
import com.entity.Coupon;

@WebServlet("/CouponFindAllServlet")
public class CouponFindAllServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processAction(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processAction(req,resp);
	}

	private void processAction(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		CouponDao theCouponDao = new CouponDaoImpl(session);
		List<Coupon> coulist = theCouponDao.findAllCoupons();
		req.setAttribute("couponList", coulist);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("CouponPage.jsp");
	    dispatcher.forward(req, resp);
	}
	
}
