package com.example.myspring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.myspring.entity.Student;
import com.example.myspring.service.impl.StudentService;

@Controller
public class StudentController {
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	String name;
	@GetMapping("/students")
	public String listStudent(Model model) {
		
//		model.addAttribute("students",studentService.getAllStudent());
		if(name==null || name == "") {
			model.addAttribute("students",studentService.getAllStudent());
		}
		else {
			model.addAttribute("students",studentService.getSerchedStudent(name));
		}
		return "students";
	}
	
	@GetMapping("/students/new")
	public String  createStudentForm(Model model){
		Student student = new Student();
		model.addAttribute("student",student);
		return "create_student";
	}
	
	@RequestMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
		
	}
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Integer id,Model model) {
		model.addAttribute("student",studentService.getStudentById(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Integer id, @ModelAttribute("student") Student student,Model model) {
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstname(student.getFirstname());
		existingStudent.setLastname(student.getLastname());
		existingStudent.setEmail(student.getEmail());
		
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
	@RequestMapping("/students/search")
	public String serachStudent(Model model) {
		if(name!=null) {
			model.addAttribute("students",studentService.getSerchedStudent(name));
		}
		else {
			model.addAttribute("students",studentService.getAllStudent());
		}
		return "student_search";
	}
	@RequestMapping("/students/search/search_students")
	public String serachStudentByName(Model model,@RequestParam(name= "searchInput") String name) {
//		 searchedStudent =  model.addAttribute("students",studentService.getSerchedStudent(name));
		this.name = name;
		
		return "redirect:/students";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	
}
