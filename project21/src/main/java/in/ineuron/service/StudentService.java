package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Student;
import in.ineuron.repository.StudentRepo;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepo repo;
	
	public String saveStudent(Student student)
	{
		repo.save(student);
		return "StudentSaved";
	}
}
