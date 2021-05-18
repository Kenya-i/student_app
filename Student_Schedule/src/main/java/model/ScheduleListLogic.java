package model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleListLogic {
	
	public List<ScheduleDto> selectScheduleList(int scheduleId) {
		
		List<ScheduleDto> scheduleList = new ArrayList<ScheduleDto>();
		
		ScheduleListDao dao = new ScheduleListDao();
		scheduleList = dao.doSelect(scheduleId);
		
		
		return scheduleList;
	}
}
