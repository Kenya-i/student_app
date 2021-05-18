package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ScheduleDto;
import model.ScheduleLogic;
import model.UserDto;

/**
 * Servlet implementation class ScheduleDelete
 */
@WebServlet("/ScheduleDelete")
public class ScheduleDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleDelete() {
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
		
		HttpSession session = request.getSession();
		UserDto UserWithSession = (UserDto)session.getAttribute("user");
		
		if(UserWithSession != null) {
			

			String id = request.getParameter("scheduleId");
			String number = request.getParameter("scheduleNumber");
			int scheduleId = Integer.parseInt(id);
			int scheduleNumber = Integer.parseInt(number);
			System.out.println(scheduleId);
			System.out.println(scheduleNumber);
			
			System.out.println("logic手前aaa");
			
			ScheduleLogic scheduleLogic = new ScheduleLogic();
			System.out.println("挟まれてる");
			boolean success = scheduleLogic.executeDelete(scheduleId);
			
			if(success) {
				
				@SuppressWarnings("unchecked")
				List<ScheduleDto> scheduleList = (List<ScheduleDto>)session.getAttribute("scheduleList");
				scheduleList.removeIf(schedule -> schedule.getScheduleId() == scheduleId );
				
				for(int i = scheduleNumber; i < scheduleList.size(); i++) {
					scheduleList.get(i).setNumber(i);
				}
				
				session.setAttribute("scheduleList", scheduleList);
				
				response.sendRedirect("schedulePage.jsp");
				
			} else {
				
				@SuppressWarnings("unchecked")
				List<ScheduleDto> scheduleList = (List<ScheduleDto>)session.getAttribute("scheduleList");
				session.setAttribute("scheduleList", scheduleList);
				
				response.sendRedirect("schedulePage.jsp");
				
			}
			
			
		} else {
			
			response.sendRedirect("loginPage.jsp");
		}
		
	}

}
