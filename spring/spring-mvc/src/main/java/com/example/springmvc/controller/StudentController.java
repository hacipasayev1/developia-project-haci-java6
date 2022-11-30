package com.example.springmvc.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springmvc.model.Student;

@Controller
public class StudentController {
@GetMapping(path="/students")
public String showStudent(Model model) {
	ArrayList<Student> studentObject=new ArrayList<>();
	studentObject.add(new Student(1,"Perviz","Veliyev","perviz@gmail.com"));
	studentObject.add(new Student(2,"Adil","Eliyev","adil@gmail.com"));
	studentObject.add(new Student(3,"Cavid","Hesenov","cavid@gmail.com"));
	model.addAttribute("telebeler", studentObject);
	return "students";
	
}
@GetMapping(path="/my-books")
public String showBooks() {
	return "books";
}
}
