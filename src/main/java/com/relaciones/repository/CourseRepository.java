package com.relaciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.relaciones.entity.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {
	
	List<Course> findAll();

}
