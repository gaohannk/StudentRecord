package com.hg.student.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hg.student.model.Pager;
import com.hg.student.model.Student;
import com.hg.student.util.JdbcUtil;

public class SublistStudentDaoImpl implements StudentDao {
	@Override
	public Pager<Student> findStudent(Student searchModel, int pageSize, int pageNum) {
		List<Student> allStudentList = getAllStudent(searchModel);
		Pager<Student> pager = new Pager<Student>(allStudentList, pageSize, pageNum);
		return pager;
	}

	public List<Student> getAllStudent(Student searchModel) {
		List<Student> result = new ArrayList<Student>();
		List<Object> paraList = new ArrayList<Object>();

		String stuName = searchModel.getStuName();
		int gender = searchModel.getGender();
		StringBuilder sql = new StringBuilder();
		sql.append("select * from t_student where 1=1");
		if (stuName != null && stuName.equals("")) {
			sql.append("and stuName like ?");
			paraList.add("%" + stuName + "%");
		}
		if (gender == Constant.GENDER_MALE || gender == Constant.GENDER_FEMALE) {
			sql.append("and gender = ?");
			paraList.add(gender);
		}
		JdbcUtil jdbc = new JdbcUtil();
		jdbc.getConnection();
		try {
			List<Map<String, Object>> maplist = jdbc.findResult(sql.toString(), paraList);
			for (Map<String, Object> map : maplist) {
				Student stu = new Student(map);
			}
		} catch (SQLException e) {
			throw new RuntimeException("查询所有数据异常！", e);
		} finally {
			if (jdbc != null) {
				jdbc.releaseConn();
			}
		}

		return result;
	}

}
