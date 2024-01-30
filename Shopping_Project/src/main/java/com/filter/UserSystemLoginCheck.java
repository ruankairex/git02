package com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.empPass;
import com.util.HibernateUtil;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = "/UserUpdate.do" , filterName = "C")
public class UserSystemLoginCheck implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		HttpSession hsession = ((HttpServletRequest) request).getSession();
		empPass pass = (empPass) hsession.getAttribute("HRsystemPass");// 取得通行證
//		System.out.println("filter get = "+pass.getEmail());
		String empAuth = pass.getDbAuthority();
		if (empAuth != null) {
			if (empAuth.equals("S1") || empAuth.equals("S2")) {
				System.out.println("filter:認證成功");
				chain.doFilter(request, response);
				
			} else {
				System.out.println("雖然是公司的人，但沒有權限登入");
				out.write("很抱歉，本系統僅限公司管理人員進入");
			}
		} else {
			System.out.println("就是一個外人");
			out.write("請再次確認您是否輸入正確密碼，或是否為公司管理人員");
		}

		out.close();
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.getCurrentSession();

	}
}
