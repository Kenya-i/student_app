package model;

public class SignupLogic {
	
	public Object[] isInsertable(UserDto dto) {
		
		Object[] obj = new Object[2];
		UserDao dao = new UserDao();
		obj = dao.doInsert(dto);
		
		return obj;
		
	}
}
