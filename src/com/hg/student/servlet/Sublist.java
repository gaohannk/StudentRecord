package com.hg.student.servlet;

import java.io.IOException;
import java.util.Stack;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hg.student.dao.Constant;
import com.hg.student.model.Pager;
import com.hg.student.model.Student;
import com.hg.student.service.StudentService;
import com.hg.student.service.SublistStudentServiceImpl;
import com.hg.student.util.StringUtil;

/**
 * Servlet implementation class Sublist
 */
@WebServlet("/Sublist")
public class Sublist extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentService studentService = new SublistStudentServiceImpl();

	/**
	 * Default constructor.
	 */
	public Sublist() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String stuName = request.getParameter("stuName");
		String genderStr = request.getParameter("gender");
		int gender = Integer.parseInt(genderStr);
		String pageNumStr = request.getParameter("pageNum");
		if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
			request.setAttribute("errorMsg", "参数传输错误");
			request.getRequestDispatcher("sublistStudent.jsp").forward(request, response);
			return;
		}
		
		int pageNum = Constant.DEFAULT_CURRENTPAGE; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			pageNum = Integer.parseInt(pageNumStr);
		}
		

		String pageSizeStr = request.getParameter("pageSize");
		int pageSize = Constant.DEFAULT_PAGESIZE;
		if (pageSizeStr != null && !"".equals(pageSizeStr.trim())) {
			pageSize = Integer.parseInt(pageSizeStr);
		}
		
		Student searchModel = new Student();
		searchModel.setStuName(stuName);
		searchModel.setGender(gender);
		
		Pager<Student> res= studentService.findStudent(searchModel, pageSize, pageNum);
		request.setAttribute(stuName, stuName);
		request.setAttribute(genderStr, gender);
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("sublist.jsp").forward(request, response);
	}

}
