package model;

import java.util.ArrayList;
import java.util.List;

public class StudentMemberLogic {

	public List<StudentDto> selectStudentMember(UserDto userDto) {

		List<StudentDto> studentList = new ArrayList<StudentDto>();
//		StudentMemberDto studentMemberDto = new StudentMemberDto();
		
		StudentMemberDao dao = new StudentMemberDao();
		studentList = dao.doSelect(userDto);
		
		return studentList;
		
	}
}
