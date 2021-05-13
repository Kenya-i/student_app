package model;

public class UserDto {
	
	private String id;
	private String name;
	private String password;
	private String nameError;
	private String passError;
	private String passConfirmError;
	private String registerError;
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setNameError(String nameError) {
		this.nameError = nameError;
	}
	
	public String getNameError() {
		return nameError;
	}
	
	public void setPassError(String passError) {
		this.passError = passError;
	}
	
	public String getPassError() {
		return passError;
	}
	
	public void setPassConfirmError(String passConfirmError) {
		this.passConfirmError = passConfirmError;
	}
	
	public String getPassConfirmError() {
		return passConfirmError;
	}
	
	public void setRegisterError(String registerError) {
		this.registerError = registerError;
	}
	
	public String getRegisterError() {
		return registerError;
	}
	
}
