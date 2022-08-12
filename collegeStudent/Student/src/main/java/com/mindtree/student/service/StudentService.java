package com.mindtree.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.student.VO.ResponseTemplate;
import com.mindtree.student.entity.Student;

@Service
public interface StudentService {
	
	Student add(Student student);
	List<Student> list();
	Student searchById(long id);
	ResponseTemplate studentWithClg(long studentId);
	Student assignCollege(long studentId, long clgId);
	List<Student> getByClgId(long clg_id);
	List<Student> getStudentByCollegeWithDescage(long clg_id);
}
