package com.example3.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example3.conn.HibernateUtil;
import com.example3.dao.EmpDao;
import com.example3.entity.Employee;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String department=req.getParameter("department");
		String salary=req.getParameter("salary");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		Employee emp = new Employee(name, department, salary, email, password);
		
		System.out.println(emp);
		
		EmpDao dao= new EmpDao(HibernateUtil.getSessionFactory());
		
		boolean f= dao.saveEmployee(emp);
		
		HttpSession session=req.getSession();
		
		if(f)
		{
			session.setAttribute("msg", "Employee register sucessfully");
			System.out.println("Employee register sucessfully");
		}
		else
		{
			session.setAttribute("msg", "something wrong on server");
			System.out.println();
		}
		
		resp.sendRedirect("index.jsp");
	}
}

		
		
	
   
	

