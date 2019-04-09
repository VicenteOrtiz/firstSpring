package com.relaciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.relaciones.entity.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	List<Student> findAll();

}
