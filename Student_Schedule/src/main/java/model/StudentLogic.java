package model;

public class StudentLogic {

	public boolean executeInsert(StudentDto dto) {
		
		boolean success = false;
		
		StudentDao dao = new StudentDao();
		success = dao.doInsert(dto);
		
		return success;
	}
}
