package com.ineuron;

import java.io.Serializable;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ineuron.model.Student;
import com.ineuron.utility.HibernateUtility;

public class App 
{
	static Session session=HibernateUtility.getSession();
	static Scanner scanner=new Scanner(System.in);
    public static void main( String[] args )
    {
        while(true)
        {
        	System.out.println("Choose the below options:");
            System.out.println("1. Insert data into Database");
            System.out.println("2. Retrive Data using ID from Database");
            System.out.println("3. Retrive All Data from Database");
            System.out.println("4. Update data using Id");
            Integer option;
        	option=scanner.nextInt();
        	switch(option)
        	{
        		case 1: insertData();
        		break;
        		case 2: retriveDataUsingId();
        		break;
        		case 3: retriveAllData();
        		break;
        		case 4: updateDataUsingId();
        		break;
        		default: System.exit(0);
        	}
        }
    }
    
    
    public static void updateDataUsingId()
    {
    	System.out.print("Enter Roll Number : ");
    	Student student = session.get(Student.class, scanner.nextInt());
    	if(student!=null)
    	{
    		System.out.print("Enter Name : ");
    		student.setName(scanner.next());
    		System.out.print("Enter City : ");
    		student.setCity(scanner.next());
    		session.saveOrUpdate(student);
    		System.out.println("Update Successfull");
    	}
    	else
    	{
    		System.out.println("Student not exist with entered roll number");
    	}
    }
    
    public static void insertData()
    {
    	Student student = new Student();
    	System.out.print("Enter Roll Number : ");
    	student.setRoll(scanner.nextInt());
    	System.out.print("Enter City : ");
    	student.setCity(scanner.next());
    	System.out.print("Enter Name : ");
    	student.setName(scanner.next());
    	
    	session.save(student);
    	System.out.println("Student Info Saved To DB");
    }
    public static void retriveAllData()
    {
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
    public static void retriveDataUsingId()
    {
    	System.out.print("Enter Roll Number : ");
    	Student student = session.get(Student.class, scanner.nextInt());
    	if(student!=null)
    	{
    		System.out.println(student.getRoll()+"\t"+student.getCity()+"\t"+student.getName());
    	}
    	else
    	{
    		System.out.println("Student not exist with entered roll number");
    	}
    }
}
