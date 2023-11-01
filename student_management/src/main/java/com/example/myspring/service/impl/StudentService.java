package com.example.myspring.service.impl;

import java.util.List;

import com.example.myspring.entity.Student;

public interface StudentService {
	List<Student> getAllStudent();
	Student saveStudent(Student student);
	Student updateStudent(Student student);
	Student getStudentById(Integer id);
	void deleteStudentById(Integer id);
	List<Student> getSerchedStudent(String name);
	
}
