package com.mindtree.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.student.VO.ResponseTemplate;
import com.mindtree.student.entity.Student;
import com.mindtree.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping
	public Student add(@RequestBody Student student)
	{
		return studentService.add(student);
	}
	
	@GetMapping
	public List<Student> listStudentp(){
		return studentService.list();
	}
	
	@GetMapping("/{studentId}")
	public ResponseTemplate studentWithClg(@PathVariable long studentId)
	{
		return studentService.studentWithClg(studentId);
	}
	
	@PutMapping("/{studentId}/{clgId}")
	public String updateCollege(@PathVariable long studentId,@PathVariable long clgId)
	{
		Student student = studentService.assignCollege(studentId,clgId);
		if(student!=null)
		{
			return student.toString();
		}
		return "Sorry. College or student Not Found";
	}
	
	@GetMapping("/student-with-ascname/{clg_id}")
	public List<Student> getByClgId(@PathVariable long clg_id)
	{
		return studentService.getByClgId(clg_id);
	}
	
	@GetMapping("/student-with-desc-age/{clg_id}")
	public List<Student> getStudentByCollegeWithDescage(@PathVariable long clg_id)
	{
		return studentService.getStudentByCollegeWithDescage(clg_id);
	}
}







