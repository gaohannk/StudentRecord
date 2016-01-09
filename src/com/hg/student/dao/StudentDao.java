package com.hg.student.dao;

import com.hg.student.model.Pager;
import com.hg.student.model.Student;

public interface StudentDao {
	public Pager<Student> findStudent(Student searchModel, int pageSize, int pageNum);
}
