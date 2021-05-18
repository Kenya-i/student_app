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

/**
 * Servlet implementation class StudentDelete
 */
@WebServlet("/StudentDelete")
public class StudentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session           = request.getSession();
		UserDto userWithSession = (UserDto)session.getAttribute("user");
		
		
		if(userWithSession != null) {
			
			System.out.println(session.getAttribute("studentId"));
			
			Integer number = (Integer)session.getAttribute("studentNumber");
			
			Integer studentId = (Integer)session.getAttribute("studentId");
			System.out.println(studentId);
			
//			String id = request.getParameter("studentId");
//			int studentId = Integer.parseInt(id);
			
			StudentLogic studentLogic = new StudentLogic();
			boolean success = studentLogic.executeDelete(studentId);
		
			if(success) {
				
				@SuppressWarnings("unchecked")
				List<StudentDto> studentList = (List<StudentDto>)session.getAttribute("studentList");
//				Integer num = (Integer)studentList.get(studentId).getNumber(); // 削除しようとしているstudentの配列番号
				studentList.removeIf(student -> student.getStudentId() == studentId );
				for(int i = number; i < studentList.size(); i++) {
					studentList.get(i).setNumber(i);
				}
				
				session.setAttribute("studentList", studentList);
				
				
				response.sendRedirect("home.jsp");
				
			} else {
				
				@SuppressWarnings("unchecked")
				List<StudentDto> studentList = (List<StudentDto>)session.getAttribute("studentList");
				session.setAttribute("studentList", studentList);
				
				response.sendRedirect("schedulePage.jsp");
				
			}
						
		} else {
			
			response.sendRedirect("loginPage.jsp");
		}
	}

}
