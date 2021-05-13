package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.SignupLogic;
import model.UserDto;



@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Signup() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("hello3");
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserDto userWithSession = (UserDto)session.getAttribute("user");
		
		if(userWithSession != null) {
			
			response.sendRedirect("home.jsp");
			
		} else {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			
			UserDto dto = new UserDto();
			
			boolean validateName = validateName(name, dto, request);
			boolean validatePass = validatePass(password, dto, request);
			
			if(validateName == false || validatePass == false) {
				System.out.println("success");
				RequestDispatcher dispatcher = request.getRequestDispatcher("signupPage.jsp");
	    		dispatcher.forward(request, response);
				return;
			}
			
			dto.setName(name);
			dto.setPassword(password);
			
			System.out.println(dto.getName());
			System.out.println(dto.getPassword());
			
			SignupLogic signup = new SignupLogic();
	    	boolean[] successInserts = signup.isInsertable(dto);
	    	
	    	System.out.println("Signup.javaのboolean");
	    	System.out.println(successInserts[0]);
	    	System.out.println(successInserts[1]);
	    	
	    	if(successInserts[0]) {
	    		
	    		session.setAttribute("user", dto);
	    		
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	    		dispatcher.forward(request, response);
	    		
	    	} else if(successInserts[1] == false) {
	    		
	    		final String registerErrorMsg = "登録に失敗しました。他の入力を試してください。";
	    		dto.setRegisterError(registerErrorMsg);
	    		request.setAttribute("registerErrorMsg", (Object)dto.getRegisterError());
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("signupPage.jsp");
	    		dispatcher.forward(request, response);
	    		
//	    		request.setAttribute("registerErrorMsg", (Object)dto.getRegisterError());
	    		
//	    		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//	    		dispatcher.forward(request, response);
	    		
	    	} else if(successInserts[0] == false) {
	    		
	    		response.sendRedirect("signupPage.jsp");
	    		
	    	}
	    	
		}
		
	}
	
	private boolean validateName(String name, UserDto dto, HttpServletRequest request) {
		
		boolean success = false;
		
		if(name == null || name == "" || name.length() < 1 || name.length() > 20) {
			final String nameErrorMsg = "名前は1字以上20字以内で入力してください。";
			dto.setNameError(nameErrorMsg);
			request.setAttribute("nameErrorMsg", (Object)dto.getNameError());
			System.out.println(request.getAttribute("nameErrorMsg"));
			
			success = false;
		} else {
			
			success = true;
			
		}
		
		return success;
	}
	
	private boolean validatePass(String password, UserDto dto, HttpServletRequest request) {
		
		boolean success = false;
		
		if(password == null || password == "" || password.length() < 6 || password.length() > 20) {
			final String passErrorMsg = "パスワードは6字以上20字以内で入力してください。";
			dto.setPassError(passErrorMsg);
			request.setAttribute("passErrorMsg", (Object)dto.getPassError());
			System.out.println(request.getAttribute("passErrorMsg"));
			
			success = false;
		} else {
			
			success = true;
			
		}
		
		return success;
	}

}

