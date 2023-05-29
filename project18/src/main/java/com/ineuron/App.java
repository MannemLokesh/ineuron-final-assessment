package com.ineuron;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ineuron.model.Student;
import com.ineuron.utility.HibernateUtility;

public class App 
{
    public static void main( String[] args )
    {
        Session session = HibernateUtility.getSession();
        Transaction beginTransaction = session.beginTransaction();
        Query<Student> createQuery = session.createQuery("from com.ineuron.model.Student");
        List<Student> list = createQuery.list();
        if(list.size()!=0)
        {
        	System.out.println("ROLL"+"\t"+"CITY"+"\t"+"NAME");
        }
        else
        {
        	System.out.println("No Data Present in DB.");
        }
        for(Student s:list)
        {
        	System.out.println(s.getRoll()+"\t"+s.getCity()+"\t"+s.getName());
        }
    }
}
