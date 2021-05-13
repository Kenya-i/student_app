package model;

public class StudentDto {
	
	private String name;
	private String schoolGrade;
	private String gender;
	private Integer teacherId;
	
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
	
	public void setTeacherId(Integer teahcerId) {
		this.teacherId = teahcerId;
	}
	
	public Integer getTeacherId() {
		return teacherId;
	}
}
