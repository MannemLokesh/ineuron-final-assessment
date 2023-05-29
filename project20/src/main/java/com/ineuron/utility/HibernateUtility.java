package com.ineuron.utility;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.ineuron.model.Student;

public class HibernateUtility 
{
	public static Session getSession()
	{
		Configuration configuration = new Configuration().addAnnotatedClass(Student.class);
		Session session = configuration.configure().buildSessionFactory().openSession();
		return session;
	}
}
