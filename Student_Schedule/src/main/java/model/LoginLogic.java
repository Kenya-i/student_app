package model;

public class LoginLogic {

	public UserDto executeSelect(String name, String password) {
				
		UserDto dto = new UserDto();
		
		UserDao dao = new UserDao();
		dto = dao.doSelect(name, password);
		
		return dto;
		
	}
	
}
