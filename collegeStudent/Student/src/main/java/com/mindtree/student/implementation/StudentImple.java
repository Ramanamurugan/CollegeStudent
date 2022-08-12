package com.mindtree.student.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.mindtree.student.VO.College;
import com.mindtree.student.VO.ResponseTemplate;
import com.mindtree.student.entity.Student;
import com.mindtree.student.repository.StudentRepository;
import com.mindtree.student.service.StudentService;

@Component
public class StudentImple implements StudentService {

	@Autowired
	private StudentRepository studentRepo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public Student add(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> list() {
		return studentRepo.findAll();
	}

	@Override
	public Student searchById(long id) {
		return studentRepo.findById(id);
	}
	

	@Override
	public ResponseTemplate studentWithClg(long studentId) {
		ResponseTemplate RT = new ResponseTemplate();
		Student student = studentRepo.findById(studentId);
		
		long clg_id = student.getClg_id();
		College clg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+clg_id, College.class);
		RT.setCollege(clg);
		RT.setStudent(student);
		return RT;
	}

	@Override
	public Student assignCollege(long studentId, long clgId) {
		Student student =studentRepo.findById(studentId);
		College clg = restTemplate.getForObject("http://COLLEGE-SERVICE/college/"+clgId, College.class);
		if(student==null ||clg==null)
		{
			return null;
		}
		student.setClg_id(clgId);
		studentRepo.save(student);
		return student;
	}

	@Override
	public List<Student> getByClgId(long clg_id) {
		return studentRepo.getByClgId(clg_id);
	}

	@Override
	public List<Student> getStudentByCollegeWithDescage(long clg_id) {
		return studentRepo.getStudentByCollegeWithDescage(clg_id);
	}
	

}
