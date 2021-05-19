package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.StudentDto;
import model.StudentLogic;
import model.StudentMemberLogic;
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
			
			
			boolean validateName = validateName(name);
			boolean nameLengthLimit = nameLengthLimit(name);
			
			if(validateName == false) {
				final String error = "名前の入力は必須です";
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = request.getRequestDispatcher("studentRegister.jsp");
				dispatcher.forward(request, response);
				return;
			}
			
			if(nameLengthLimit == false) {
				final String error = "名前が20文字を超えています";
				request.setAttribute("error", error);
				RequestDispatcher dispatcher = request.getRequestDispatcher("studentRegister.jsp");
				dispatcher.forward(request, response);
				
			}
			
			StudentDto dto = new StudentDto();
			dto.setName(name);
			dto.setSchoolGrade(schoolGrade);
			dto.setGender(gender);
			dto.setTeacherId(Integer.parseInt(userWithSession.getId()));
			
			StudentLogic logic = new StudentLogic();
			int studentId = logic.executeInsert(dto);
			
			if(studentId > 0) {
				if(session.getAttribute("studentList") != null) {
					
					@SuppressWarnings("unchecked")
					List<StudentDto> studentList = (List<StudentDto>)session.getAttribute("studentList");
					int num = studentList.size();
					dto.setStudentId(studentId); //データベースのインクリメントID
					dto.setNumber(num);          //studentListにおける配列番号
					studentList.add(dto);
					session.setAttribute("studentList", studentList);
					
				} else {
					StudentMemberLogic studentMemberLogic = new StudentMemberLogic();
					List<StudentDto> studentList = studentMemberLogic.selectStudentMember(userWithSession);
					session.setAttribute("studentList", studentList);
				}
				
				response.sendRedirect("home.jsp");
			} else {
				response.sendRedirect("studentRegister.jsp");
			}
			
			
		} else {
			
			response.sendRedirect("loginPage.jsp");
			
		}
		
	}

	
	private boolean validateName(String name) {
		
		boolean success = true;
		
		if(name == null || name == "" || name.length() == 0 ) {
			success = false;
		}
		
		return success;
	}
	
	private boolean nameLengthLimit(String name) {
		
		boolean success = true;
		
		if(name.length() > 20) {
			success = false;
		}
		
		return success;
	}

}
