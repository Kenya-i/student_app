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


@WebServlet("/ScheduleUpdate")
public class ScheduleUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ScheduleUpdate() {
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
			
			Integer num = (Integer)session.getAttribute("scheduleNumber");
			Integer id = (Integer)session.getAttribute("scheduleId");
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String subject = request.getParameter("subject");
			String homework = request.getParameter("homework");
			String memo = request.getParameter("memo");
			
			if(id == null || date == null || time == null || subject == null) {
				response.sendRedirect("scheduleUpdate.jsp");
			}
			
			
			ScheduleDto dto = new ScheduleDto();
			dto.setScheduleId(id);
			dto.setDate(date);
			dto.setTime(time);
			dto.setSubject(subject);
			dto.setHomework(homework);
			dto.setMemo(memo);
			
			ScheduleLogic logic = new ScheduleLogic();
			boolean success = logic.executeUpdate(dto);
			
			
			if(success) {
				if(session.getAttribute("studentList") != null) {
					
					@SuppressWarnings("unchecked")
					List<ScheduleDto> scheduleList = (List<ScheduleDto>)session.getAttribute("scheduleList");
					ScheduleDto scheduleDto = scheduleList.get(num);
					scheduleDto.setDate(date);
					scheduleDto.setTime(time);
					scheduleDto.setSubject(subject);
					scheduleDto.setHomework(homework);
					scheduleDto.setMemo(memo);
					scheduleDto.setNumber(num);
					scheduleList.set(num, scheduleDto);
					session.setAttribute("scheduleList", scheduleList);
					
				} else {
//					StudentMemberLogic studentMemberLogic = new StudentMemberLogic();
//					List<StudentDto> studentList = studentMemberLogic.selectStudentMember(userWithSession);
//					session.setAttribute("studentList", studentList);
//					session.setAttribute("studentName", name);
//					session.getAttribute("studentNumber")
				}
				
				response.sendRedirect("schedulePage.jsp");
			} else {
				
				response.sendRedirect("scheduleUpdate.jsp");
			}
	
			
		} else {
			
			response.sendRedirect("loginPage.jsp");
			
		}
	}

}
