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
 * Servlet implementation class ScheduleUpdate
 */
@WebServlet("/ScheduleUpdate")
public class ScheduleUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		UserDto userWithSession = (UserDto)session.getAttribute("user");
		
		if(userWithSession != null) {
			
//			Integer num = (Integer)request.getAttribute("scheduleNumber");
//			Integer id = (Integer)request.getAttribute("scheduleId");
			Integer num = (Integer)session.getAttribute("scheduleNumber");
			Integer id = (Integer)session.getAttribute("scheduleId");
			System.out.println(id);
			String date = request.getParameter("date");
			String time = request.getParameter("time");
			String subject = request.getParameter("subject");
			String homework = request.getParameter("homework");
			String memo = request.getParameter("memo");
			
			System.out.println("if前");
			
			if(id == null || date == null || time == null || subject == null) {
				response.sendRedirect("scheduleUpdate.jsp");
			}
			
			System.out.println("hogehogehogeohoe");
			
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
//					session.setAttribute("studentName", name);
//					session.getAttribute("studentNumber")
					System.out.println("Listある");
					
				} else {
//					StudentMemberLogic studentMemberLogic = new StudentMemberLogic();
//					List<StudentDto> studentList = studentMemberLogic.selectStudentMember(userWithSession);
//					session.setAttribute("studentList", studentList);
//					session.setAttribute("studentName", name);
//					session.getAttribute("studentNumber")
				}
				System.out.println("成功a!!!!");
				
				response.sendRedirect("schedulePage.jsp");
			} else {
				
				System.out.println("失敗a!!!!");
				response.sendRedirect("scheduleUpdate.jsp");
			}
	
			
		} else {
			
			response.sendRedirect("loginPage.jsp");
			
		}
	}

}
