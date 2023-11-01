package com.example.myspring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myspring.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	List<Student> findByfirstname(String name);

}
	