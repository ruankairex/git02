package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.entity.Employee;
import com.entity.User;
import com.entity.UserPass;
import com.entity.empPass;
import com.util.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/HRSystemLogin.do")
public class HRSystemLogin extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}
	
	
	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.getCurrentSession();
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String usermail = request.getParameter("usermail");//抓取欄位
		String password = request.getParameter("password");//抓取欄位
		
		System.out.println("人事部系統登入嘗試");
		System.out.println("login info usermail:"+usermail);
		System.out.println("login info password:"+password);
		
		HttpSession hsession = request.getSession();
		
		
		String hql = "FROM Employee E where E.email = :email AND E.password = :password";
		Query<Employee> empQuery = session.createQuery(hql, Employee.class);
		empQuery.setParameter("email", usermail);
		empQuery.setParameter("password", password);
		List<Employee> rs = empQuery.getResultList();
		empPass empPass = new empPass();
		
	
		if (rs.isEmpty()) {
			String hqlUser = "FROM User E where E.userEmail = :userEmail AND E.userPassword = :userPassword";
			Query<User> userQuery = session.createQuery(hqlUser, User.class);
			userQuery.setParameter("userEmail", usermail);
			userQuery.setParameter("userPassword", password);
			// 這個List只有一個東西
			List<User> user = userQuery.getResultList();
			UserPass userPass = new UserPass();
			if(!user.isEmpty()) {
				System.out.println("非公司員工");
				
				for (User users : user) {
					userPass.setUserId(users.getUserId());
					userPass.setLastName(users.getLastName());
					userPass.setFirstName(users.getFirstName());
					userPass.setUserEmail(users.getUserEmail());
					userPass.setSellerQualified(users.getSellerQualified());
					userPass.setUserStatus(users.getUserStatus());
					
				    
				    
				    System.out.println("--------------------------");
				    hsession.setAttribute("UsersystemPass", userPass);//傳空的物件
					response.sendRedirect(request.getContextPath() + "/UserSystemMainPage.do");	
				}
				
			}else {
				out.write("登入失敗");
				out.write("<a href='HRSystemLoginPage.html'>Go to Homepage</a> <hr>");				
			}
		} else {
			System.out.println("認證成功，將打包資訊當通行證："); // 可以再修
			for (Employee emp : rs) {
				empPass.setEmployeeId(emp.getEmployeeId());
				empPass.setFirstName(emp.getFirstName());
				empPass.setLastName(emp.getLastName());
				empPass.setEmail(emp.getEmail());
				empPass.setDepartment(emp.getDepartment());
				empPass.setTitle(emp.getTitle());
				empPass.setDbAuthority(emp.getDbAuthority());
				hsession.setAttribute("HRsystemPass", empPass);
				

				
				String empAuth = emp.getDbAuthority();
				
				System.out.println("--------------------------");
				if(empAuth.equals("HR1") || empAuth.equals("HR2") ){
					response.sendRedirect(request.getContextPath() + "/HRSystemMainPage.do");	
				}else if(empAuth.equals("S1") || empAuth.equals("S2")) {
					response.sendRedirect(request.getContextPath() + "/UserUpdate.do");	
				}else if(empAuth.equals("M1") || empAuth.equals("M2")) {
					response.sendRedirect(request.getContextPath() + "/MarketingMainPage.jsp");	
				}
			}
			out.close();
		}
	}
}
