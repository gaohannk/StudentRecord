package com.hg.student.service;

import com.hg.student.dao.StudentDao;
import com.hg.student.dao.SublistStudentDaoImpl;
import com.hg.student.model.Pager;
import com.hg.student.model.Student;

public class SublistStudentServiceImpl implements StudentService {
	public StudentDao studentDao;

	public SublistStudentServiceImpl() {
		studentDao = new SublistStudentDaoImpl();
	}

	@Override
	public Pager<Student> findStudent(Student searchModel, int pageSize, int pageNum) {
		Pager<Student> result= studentDao.findStudent(searchModel, pageSize, pageNum);
		return result;
	}

}
