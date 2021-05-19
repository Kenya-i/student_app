package otherFunction;

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
import model.UserDto;


@WebServlet("/PreSchedulePage")
public class PreSchedulePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public PreSchedulePage() {
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
			
			String name = request.getParameter("studentName");
			String id = request.getParameter("studentId");
			String number = request.getParameter("studentNumber");
			int studentId = Integer.parseInt(id);
			int studentNumber = Integer.parseInt(number);
			session.setAttribute("studentName", name);
			session.setAttribute("studentId", studentId);
			session.setAttribute("studentNumber", studentNumber);
			
			if(session.getAttribute("scheduleList") != null) {
				ScheduleListLogic scheduleListLogic = new ScheduleListLogic();
				List<ScheduleDto> scheduleList = scheduleListLogic.selectScheduleList(studentId);
				session.setAttribute("scheduleList", scheduleList);
			} else {
				
				ScheduleListLogic scheduleListLogic = new ScheduleListLogic();
				List<ScheduleDto> scheduleList = scheduleListLogic.selectScheduleList(studentId);
				session.setAttribute("scheduleList", scheduleList);
			}
			
			response.sendRedirect("schedulePage.jsp");
			
		} else {
			response.sendRedirect("index.jsp");
		}
	}

}
