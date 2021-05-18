package model;

public class StudentDto {
	
	private int studentId;
	private int id;
	private String name;
	private String schoolGrade;
	private String gender;
	private int teacherId;
	private int number;
	
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	public int getStudentId() {
		return studentId;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSchoolGrade(String schoolGrade) {
		this.schoolGrade = schoolGrade;
	}
	
	public String getSchoolGrade() {
		return schoolGrade;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setTeacherId(int teahcerId) {
		this.teacherId = teahcerId;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public int getNumber() {
		return number;
	}
}
