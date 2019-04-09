package com.relaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.relaciones.entity.Student;
import com.relaciones.repository.StudentRepository;
import java.util.List;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@RequestMapping(value="/students", method= RequestMethod.GET)
	public List<Student> getStudent(){
		return studentRepository.findAll();
	}
	
	
	@RequestMapping(value="/students/{id}", method = RequestMethod.GET)
	public Student getByIdStudent(@PathVariable int id) {
		return studentRepository.findById(id).get();
	}
}