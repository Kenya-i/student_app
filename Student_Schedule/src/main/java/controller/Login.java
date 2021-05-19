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

import model.LoginLogic;
import model.StudentDto;
import model.StudentMemberLogic;
import model.UserDto;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public Login() {
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
			
			response.sendRedirect("home.jsp");
			
		} else {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			boolean validateName = validateName(name);
			boolean validatePass = validatePass(password);
			
			if(validateName == false || validatePass == false) {
				
				final String errorMsg = "ユーザーが見つかりませんでした。";
				request.setAttribute("errorMsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginPage.jsp");
				dispatcher.forward(request, response);
				
			}
			
			LoginLogic logic = new LoginLogic();
			UserDto dto = logic.executeSelect(name, password);
			
			
			if(dto.getName() != null) {
				StudentMemberLogic studentMemberLogic = new StudentMemberLogic();
				List<StudentDto> studentList = studentMemberLogic.selectStudentMember(dto);
				
				session.setAttribute("user", dto);
				session.setAttribute("studentList", studentList);

				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	    		dispatcher.forward(request, response);
	    		
			} else {
				
				final String errorMsg = "ユーザーが見つかりませんでした。";
				request.setAttribute("errorMsg", errorMsg);
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginPage.jsp");
				dispatcher.forward(request, response);
				
			}
			
		}
		
	}
	
	private boolean validateName(String name) {
		
		boolean success = false;
		
		if(name != null || name != "" || name.length() >= 1) {
			success = true;
		}
		
		return success;
	}
	
	private boolean validatePass(String password) {
		
		boolean success = false;
		
		if(password != null && password != "" && password.length() >= 6) {
			success = true;
		}
		
		return success;
	}

}
