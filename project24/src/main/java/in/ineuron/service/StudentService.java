package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.model.Student;
import in.ineuron.repository.StudentRepository;

@Service
public class StudentService 
{
	@Autowired
	private StudentRepository repository;
	
	public String insertToDb(Student student)
	{
		repository.save(student);
		return "Saved";
	}
}
