package model;

public class ScheduleDto {
	
	private int scheduleId;  // scheduleのincrementID
	private int studentId;
	private String date;
	private String time;
	private String subject;
	private String homework;
	private String memo;
	private int number; //一人のstudentが持つscheduleの配列番号
	
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	
	public int getScheduleId() {
		return scheduleId;
	}
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setTime(String time) {
		this.time = time;
	}
	
	public String getTime() {
		return time;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setHomework(String homework) {
		this.homework = homework;
	}
	
	public String getHomework() {
		return homework;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}
