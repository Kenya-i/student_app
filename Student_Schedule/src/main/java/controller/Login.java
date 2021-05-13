package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
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
		
		System.out.println("hoge10");
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserDto userWithSession = (UserDto)session.getAttribute("user");
		
		System.out.println(userWithSession);
		
		if(userWithSession != null) {
			
			response.sendRedirect("home.jsp");
			
		} else {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			boolean validateName = validateName(name);
			boolean validatePass = validatePass(password);
			
			if(validateName == false || validatePass == false) {
				System.out.println("success");
				response.sendRedirect("signupPage.jsp");
				return;
			}
			
			LoginLogic logic = new LoginLogic();
			UserDto dto = logic.executeSelect(name, password);
			
			if(dto.getName() != null) {
				
				session.setAttribute("user", dto);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	    		dispatcher.forward(request, response);
	    		
			} else {
				
				response.sendRedirect("loginPage.jsp");
			}
			
		}
		
	}
	
	private boolean validateName(String name) {
		
		boolean success = false;
		
		if(name != null && name != "" && name.length() >= 1) {
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
