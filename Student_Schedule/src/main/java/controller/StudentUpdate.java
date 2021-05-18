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
import model.StudentMemberLogic;
import model.UserDto;

/**
 * Servlet implementation class StudentUpdate
 */
@WebServlet("/StudentUpdate")
public class StudentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdate() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserDto userWithSession = (UserDto)session.getAttribute("user");
		
		if(userWithSession != null) {
			
			String name = request.getParameter("name");
			String schoolGrade = request.getParameter("school-grade");
			String gender = request.getParameter("gender");
			Integer studentId = (Integer)session.getAttribute("studentId");
			
			
			
			System.out.println(studentId);
			
			
			boolean validateName = validateName(name);
			
			if(validateName == false) {
				response.sendRedirect("studentUpdate.jsp");
				return;
			}
			
			StudentDto dto = new StudentDto();
			dto.setName(name);
			dto.setSchoolGrade(schoolGrade);
			dto.setGender(gender);
			dto.setStudentId(studentId);
			dto.setTeacherId(Integer.parseInt(userWithSession.getId()));
			
			StudentLogic logic = new StudentLogic();
			boolean success = logic.executeUpdate(dto);
			
			Integer num = (Integer)session.getAttribute("studentNumber");
			
			if(success) {
				if(session.getAttribute("studentList") != null) {
					
					@SuppressWarnings("unchecked")
					List<StudentDto> studentList = (List<StudentDto>)session.getAttribute("studentList");
					StudentDto studentDto = studentList.get(num);
					studentDto.setName(name);
					studentDto.setSchoolGrade(schoolGrade);
					studentDto.setGender(gender);
					studentDto.setStudentId(studentId);
					studentDto.setTeacherId(Integer.parseInt(userWithSession.getId()));
					studentDto.setNumber(num);
					studentList.set(num, studentDto);
					session.setAttribute("studentList", studentList);
					session.setAttribute("studentName", name);
//					session.getAttribute("studentNumber")
					System.out.println("Listある");
					
				} else {
					StudentMemberLogic studentMemberLogic = new StudentMemberLogic();
					List<StudentDto> studentList = studentMemberLogic.selectStudentMember(userWithSession);
					session.setAttribute("studentList", studentList);
					session.setAttribute("studentName", name);
//					session.getAttribute("studentNumber")
				}
				System.out.println("成功a!!!!");
				
				response.sendRedirect("schedulePage.jsp");
			} else {
				
				System.out.println("失敗a!!!!");
				response.sendRedirect("studentUpdate.jsp");
			}
	
			
		} else {
			
			response.sendRedirect("loginPage.jsp");
			
		}
			
			
	}
		
	
	private boolean validateName(String name) {
			
		boolean success = false;
		
		if(name != null || name != "" || name.length() >= 1 ) {
			success = true;
		}
		
		return success;
	}

}
