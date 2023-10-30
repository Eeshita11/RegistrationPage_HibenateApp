package com.example3.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example3.entity.Employee;

public class EmpDao 
{
	private SessionFactory sessionFactory;

	public EmpDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public boolean  saveEmployee(Employee emp)
	{
		boolean f=false;
		
		Session session=sessionFactory.openSession();
		
		Transaction tx=session.beginTransaction();
		
		int i=(Integer)session.save(emp);
		
		if(i>0)
		{
			f=true;
		}
		
		tx.commit();
		session.close();
		
        return f;
	}
	
	
	
	

}
