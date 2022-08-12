package com.mindtree.college.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.college.VO.RequestTemplate;
import com.mindtree.college.entity.College;

@Service
public interface CollegeService {
	College add(College clg);
	List<College> list();
	College update(long id,String name);
	College searchById(long id);
	List<RequestTemplate> listWithStudent();
	RequestTemplate specificCollegeStudent(long clg_id);
}
