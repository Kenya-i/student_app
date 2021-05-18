package model;

public class StudentLogic {

	StudentDao dao = new StudentDao();
	
	public int executeInsert(StudentDto dto) {
				
		
		int key = dao.doInsert(dto);
		
		return key;
	}

	
	public boolean executeUpdate(StudentDto dto) {
		
		boolean success = dao.doUpdate(dto);
		
		return success;
	}
	
	
	public boolean executeDelete(int studentId) {
		
		boolean success = dao.doDelete(studentId);
		
		return success;
		
	}
}
