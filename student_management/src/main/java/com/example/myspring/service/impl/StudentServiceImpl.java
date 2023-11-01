package com.example.myspring.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.myspring.entity.Student;
import com.example.myspring.repository.StudentRepository;


@Service
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository studentRepository;
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	@Override
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).get();
	}
	@Override
	public void deleteStudentById(Integer id) {
		studentRepository.deleteById(id);
	}
	@Override
	public List<Student> getSerchedStudent(String name) {
		return studentRepository.findByfirstname(name);

	}
	

}
