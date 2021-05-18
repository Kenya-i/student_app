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
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserDto userWithSession = (UserDto)session.getAttribute("user");
		
		if(userWithSession != null) {
			
			response.sendRedirect("home.jsp");
			
		} else {
			
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String passwordConfirmation = request.getParameter("password-confirmation");
			
			UserDto userDto = new UserDto();
			
			boolean validateName = validateName(name, request);
			boolean validatePass = validatePass(password, request);
			boolean validatePassConfirmation = validatePassConfirmation
					                           (password, passwordConfirmation, request);
			
			if(validateName == false || validatePass == false || validatePassConfirmation == false) {
				System.out.println("success");
				RequestDispatcher dispatcher = request.getRequestDispatcher("signupPage.jsp");
	    		dispatcher.forward(request, response);
				return;
			}
			
			userDto.setName(name);
			userDto.setPassword(password);
			
			SignupLogic signup = new SignupLogic();
	    	Object[] insertResults = signup.isInsertable(userDto);

	    	System.out.println("よくここまでたどり着いたらおぬしよ");
	    	
//	    	System.out.println(insertResults[1].toString());
	    	
	    	
	    	String userId;
	    	if(insertResults[1] != null) {
	    		userId = insertResults[1].toString();
	    		userDto.setId(userId);
//		    	System.out.println(objStr);
//		    	userId = Integer.parseInt(objStr);
//		    	userDto.setId(userId);
	    	}
	    	
	    	String objStr2 = insertResults[0].toString();
	    	boolean bool = Boolean.valueOf(objStr2);
	    	
	    	
	    	if(bool) {
	    		
//	    		LoginLogic logic = new LoginLogic();
//				UserDto userDto2 = logic.executeSelect(name, password);
	    		
	    		session.setAttribute("user", userDto);
	    		
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
	    		dispatcher.forward(request, response);
	    		
	    	} else if(bool == false || insertResults[1] != null) {
	    		
	    		final String registerErrorMsg = "登録に失敗しました。他の入力を試してください。";
	    		userDto.setRegisterError(registerErrorMsg);
	    		request.setAttribute("registerErrorMsg", (Object)userDto.getRegisterError());
	    		RequestDispatcher dispatcher = request.getRequestDispatcher("signupPage.jsp");
	    		dispatcher.forward(request, response);
	    		
//	    		request.setAttribute("registerErrorMsg", (Object)dto.getRegisterError());
	    		
//	    		RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
//	    		dispatcher.forward(request, response);
	    		
	    	}
	    	
		}
		
	}
	
	private boolean validateName(String name, HttpServletRequest request) {
		
		boolean success = false;
		
		if(name == null || name == "" || name.length() < 1 || name.length() > 20) {
			final String nameErrorMsg = "名前は1字以上20字以内で入力してください。";
			request.setAttribute("nameErrorMsg", nameErrorMsg);
			System.out.println(request.getAttribute("nameErrorMsg"));
			
			success = false;
		} else {
			
			success = true;
			
		}
		
		return success;
	}
	
	private boolean validatePass(String password, HttpServletRequest request) {
		
		boolean success = false;
		
		if(password == null || password == "" || password.length() < 6 || password.length() > 20) {
			final String passErrorMsg = "パスワードは6字以上20字以内で入力してください。";
			request.setAttribute("passErrorMsg", passErrorMsg);
			System.out.println(request.getAttribute("passErrorMsg"));
			
			success = false;
		} else {
			
			success = true;
			
		}
		
		return success;
	}
	
	private boolean validatePassConfirmation(String password, String passwordConfirmation, HttpServletRequest request) {
		
		boolean success = false;
		
		if(password.equals(passwordConfirmation)) {
			success = true;
			if(passwordConfirmation == null || passwordConfirmation == "") {
				success = false;
			}
		} else {
			System.out.println(password);
			System.out.println(passwordConfirmation);
			System.out.println(password == passwordConfirmation);
			final String passConfirmErrorMsg = "確認用パスワードが一致しませんでした。もう一度お試しください。";
			request.setAttribute("passConfirmErrorMsg", passConfirmErrorMsg);
			success = false;
			
			if(passwordConfirmation == null || passwordConfirmation == "") {
				request.removeAttribute("passConfirmErrorMsg");
			}
		}
		
		return success;
		
	}

}

