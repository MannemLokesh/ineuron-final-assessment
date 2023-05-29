package in.ineuron.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.ineuron.model.Student;
import in.ineuron.service.StudentService;

@Component
public class Performing 
{
	
	
	@Autowired
	private StudentService service;
	
	public void perform()
	{
		Student student = new Student();
		System.out.println("working...");
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Roll Number of Student : ");
		student.setRoll(scanner.nextInt());
		System.out.print("Enter Name of Student : ");
		student.setName(scanner.next());
		System.out.print("Enter College of Student : ");
		student.setCollege(scanner.next());
		
		String saveStudent = service.saveStudent(student);
		if(saveStudent.equals("StudentSaved"))
		{
			System.out.println("Insertion Successfull");
		}
		else
		{
			System.out.println("Insertion Failed");
		}
		
	}
}
