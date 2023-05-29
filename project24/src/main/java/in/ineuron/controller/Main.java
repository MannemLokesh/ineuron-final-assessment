package in.ineuron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Student;
import in.ineuron.service.StudentService;

@RestController
public class Main 
{
	@Autowired
	private StudentService service;
	
	@PostMapping("/insertDetails")
	ResponseEntity<String> insertDetailsToDb(Student student)
	{
		String insertToDb = service.insertToDb(student);
		return new ResponseEntity<>(insertToDb, HttpStatus.OK);
	}
}
