package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import com.entity.UserPass;
import com.entity.empPass;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/UserSystemMainPage.jsp" , filterName = "C")
public class UserSystemLoginCheck implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		System.out.println("Main filter");
		
		HttpSession hsession = ((HttpServletRequest) request).getSession();
		UserPass pass = (UserPass) hsession.getAttribute("UsersystemPass");// 取得通行證
//		System.out.println("filter get = "+pass.getEmail());
		if (pass != null) {
			out.write("成功登入");
		} 

		out.close();
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.getCurrentSession();

	}
}
