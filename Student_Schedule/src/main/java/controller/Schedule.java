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
import model.ScheduleListLogic;
import model.ScheduleLogic;
import model.UserDto;


@WebServlet("/Schedule")
public class Schedule extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Schedule() {
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
		
		if(userWithSession == null) {
			
			response.sendRedirect("index.jsp");
			
		} else {
			
			Integer studentId = (Integer)session.getAttribute("studentId");
			System.out.println(studentId);
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String subject = request.getParameter("subject");
			String homework = request.getParameter("homework");
			String memo = request.getParameter("memo");
			
			if(studentId == null || date == null || time == null || subject == null) {
				response.sendRedirect("scheduleRegisterPage.jsp");
			}
			
			ScheduleDto dto = new ScheduleDto();
			dto.setStudentId(studentId);
			dto.setDate(date);
			dto.setTime(time);
			dto.setSubject(subject);
			dto.setHomework(homework);
			dto.setMemo(memo);
			
			ScheduleLogic logic = new ScheduleLogic();
			int scheduleId = logic.executeInsert(dto);
			
			// scheduleIdは今追加したscheduleのID
			if(scheduleId > 0) {
				
				if(session.getAttribute("scheduleList") != null) {
					
					@SuppressWarnings("unchecked")
					List<ScheduleDto> scheduleList = (List<ScheduleDto>)session.getAttribute("scheduleList");
					dto.setScheduleId(scheduleId);
					dto.setNumber(scheduleList.size());
					scheduleList.add(dto);
					session.setAttribute("scheduleList", scheduleList);

				} else {
					
					ScheduleListLogic scheduleListLogic = new ScheduleListLogic();
					List<ScheduleDto> scheduleList = scheduleListLogic.selectScheduleList(scheduleId);
					dto.setScheduleId(scheduleId);
					dto.setNumber(0);
					scheduleList.add(dto);
					session.setAttribute("scheduleList", scheduleList);
					
				}
				
				response.sendRedirect("schedulePage.jsp");
			} else {

				response.sendRedirect("scheduleRegisterPage.jsp");
			}
			
		}
		
		
		
	}

}
