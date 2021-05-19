package model;

public class ScheduleLogic {

	public int executeInsert(ScheduleDto dto) {
		
		ScheduleDao dao = new ScheduleDao();
		int key = dao.doInsert(dto);
		
		return key;
		
	}
	
	public boolean executeDelete(int scheduleId) {
		
		
		ScheduleDao dao = new ScheduleDao();
		boolean success = dao.doDelete(scheduleId);
		
		return success;
		
	}
	
	public boolean executeUpdate(ScheduleDto dto) {
		
		ScheduleDao dao = new ScheduleDao();
		
		boolean success = dao.doUpdate(dto);
		
		return success;
	}
}
