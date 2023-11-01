package com.example.myspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.myspring.entity.Student;
import com.example.myspring.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
	
	@Autowired
	StudentRepository studentRepository;
	@Override
	public void run(String... args) throws Exception {
//		Student student = new Student("Mangesh","Gosavi","mangesh@gmail.com");
//		studentRepository.save(student);
	}

}
