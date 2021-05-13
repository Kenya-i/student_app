package model;

public class SignupLogic {
	
	public boolean[] isInsertable(UserDto dto) {
		
		System.out.println("signupLogic");
		
		boolean[] successes = new boolean[2];
		UserDao dao = new UserDao();
		successes = dao.doInsert(dto);
		
		System.out.println(successes[0]);
		System.out.println(successes[1]);
		return successes;
		
	}
}
