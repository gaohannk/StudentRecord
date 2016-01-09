package com.hg.student.service;

import com.hg.student.model.Pager;
import com.hg.student.model.Student;

public interface StudentService {
	public Pager<Student> findStudent(Student searchModel, int pageSize, int pageNum);
	
}
