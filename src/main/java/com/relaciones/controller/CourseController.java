package com.relaciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.relaciones.entity.Course;
import com.relaciones.entity.Student;
import com.relaciones.repository.CourseRepository;
import java.util.List;

@RestController
public class CourseController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@RequestMapping(value="/courses", method= RequestMethod.GET)
	public List<Course> getCourses(){
		return courseRepository.findAll();
	}
	
	
	@RequestMapping(value="/courses/{id}", method = RequestMethod.GET)
	public Course getByIdCourse(@PathVariable int id) {
		return courseRepository.findById(id).get();
	}
	
	@RequestMapping(value="/courses", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Course createCourse(@RequestBody Course course, BindingResult result) {
		
		return courseRepository.save(course);
	}
	
	@RequestMapping(value="/courses/{id}", method = RequestMethod.PUT)
	public Course updateCourse(@PathVariable int id, @RequestBody Course course, BindingResult result) {
		Course c = courseRepository.findById(id).get();
		
		if(c != null) {
			c.setClassName(course.getClassName());
			c.setMaxStudents(course.getMaxStudents());
			
			return courseRepository.save(c);
		}
		return null;	
	}
	
	@RequestMapping(value="/courses/{id}", method = RequestMethod.DELETE)
	public void deleteCourse(@PathVariable int id) {
		
		courseRepository.deleteById(id);
		
	}
	
	@RequestMapping(value="/courses/{id}/students", method = RequestMethod.GET)
	public List<Student> getStudentsByCourse(@PathVariable int id){
		
		return courseRepository.findById(id).get().getStudents();
	}
	
	
}
