package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentDto;
import model.StudentLogic;
import model.UserDto;


@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public Student() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserDto userWithSession = (UserDto)session.getAttribute("user");
		
		if(userWithSession != null) {
			
			String name = request.getParameter("name");
			String schoolGrade = request.getParameter("school-grade");
			String gender = request.getParameter("gender");
			
			System.out.println(name);
			System.out.println(schoolGrade);
			System.out.println(gender);
			
			boolean validateName = validateName(name);
			
			if(validateName == false) {
				response.sendRedirect("studentRegister.jsp");
				return;
			}
			
			StudentDto dto = new StudentDto();
			dto.setName(name);
			dto.setSchoolGrade(schoolGrade);
			dto.setGender(gender);
			UserDto user = (UserDto)session.getAttribute("user");
			dto.setTeacherId(Integer.parseInt(user.getId()));
			
			StudentLogic logic = new StudentLogic();
			boolean successInsert = logic.executeInsert(dto);
			
			
			if(session.getAttribute("studentList") != null) {
				
				@SuppressWarnings("unchecked")
				List<StudentDto> studentList = (List<StudentDto>)session.getAttribute("studentList");
				studentList.add(dto);
				session.setAttribute("studentList", studentList);
				
			}
			
			
			if(successInsert) {
				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("studentRegister.jsp");
			}
			
		} else {
			
			response.sendRedirect("loginPage.jsp");
			
		}
		
		
		

		
		
		
		
		
		
		
//		1
//		System.out.println(userWithSession);
//		
//		if(userWithSession != null) {
		
		
		
			
//			String name = request.getParameter("name");
//			String schoolGrade = request.getParameter("school-grade");
//			String gender = request.getParameter("gender");
//			
//			StudentDto dto = new StudentDto();
		
		
		
//			1
//			boolean validateName = validateName(name);
//			
//			if(validateName == false) {
//				response.sendRedirect("studentRegister.jsp");
//				return;
//			}
		
		
		
		
			
//			dto.setName(name);
//			dto.setSchoolGrade(schoolGrade);
//			dto.setGender(gender);
//			dto.setTeacherId((String)session.getAttribute("user"));
//			
//			System.out.println(dto.getTeacherId());
//			System.out.println(dto.getTeacherId() instanceof String);
		
		
		
		
			
//			1
//			StudentLogic logic = new StudentLogic();
//			boolean successInsert = logic.executeInsert(dto);
//			
//			if(successInsert) {
//				response.sendRedirect("home.jsp");
//			} else {
//				response.sendRedirect("studentRegister.jsp");
//			}
//			
//		} else {
//			
//			
//			response.sendRedirect("loginPage.jsp");
//		}
		
		
		
	}

	
	private boolean validateName(String name) {
		
		boolean success = false;
		
		if(name != null || name != "" || name.length() >= 1 ) {
			success = true;
		}
		
		return success;
	}

}
