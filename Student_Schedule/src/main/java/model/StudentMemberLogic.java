package model;

import java.util.ArrayList;
import java.util.List;

public class StudentMemberLogic {

	public List<StudentDto> selectStudentMember(UserDto userDto) {
//		List<StudentDto>        ArrayList
		
		List<StudentDto> studentDtoList = new ArrayList<StudentDto>();
//		StudentMemberDto studentMemberDto = new StudentMemberDto();
		
		StudentMemberDao dao = new StudentMemberDao();
		studentDtoList = dao.doSelect(userDto);
		
		return studentDtoList;
		
	}
}
