package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentMemberDao {
	
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	String JDBC_URL = "jdbc:mysql://localhost/student_app?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	
	String USER_ID = "java_user";
	
	String USER_PASS = "password";
	
	public List<StudentDto> doSelect(UserDto userDto) {
		
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<StudentDto> studentDtoList = new ArrayList<StudentDto>();
		
		try {
			
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			
			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT          ");
			sb.append("  ID,            ");
			sb.append("  NAME,          ");
			sb.append("  SCHOOL_GRADE,  ");
			sb.append("  GENDER         ");
//			sb.append("  TEACHER_ID     ");
			sb.append("  FROM           ");
			sb.append("  STUDENT        ");
			sb.append(" WHERE           ");
			sb.append("  TEACHER_ID = ? ");

			
			ps = con.prepareStatement(sb.toString());
			
			int id = Integer.parseInt(userDto.getId());
			
			ps.setInt(1, id);
			
			System.out.println("ここ1");
			
			System.out.println(ps);
			
			rs = ps.executeQuery();
			
			System.out.println("ここ2");
			
			System.out.println(rs);
			
			while(rs.next()) {
				System.out.println("ここ4");
				StudentDto studentDto = new StudentDto();
				studentDto.setId(rs.getInt("Id"));
				studentDto.setName(rs.getString("NAME"));
				studentDto.setSchoolGrade(rs.getString("SCHOOL_GRADE"));
				studentDto.setGender(rs.getString("GENDER"));
				studentDtoList.add(studentDto);
			}
			
		} catch(SQLException e) {
			
			System.out.println("ここ5");
			
			System.out.println("error!!!");
			e.printStackTrace();
			
		} finally {
			
			
			if(rs != null) {
				
				try {
					
					rs.close();
					
				} catch(SQLException e) {
					
					e.printStackTrace();
					
				}
			}
			
			
			if(ps != null) {
				
				try {
					
					ps.close();
					
				} catch(SQLException e) {
					
					e.printStackTrace();
					
				}
			}
			
			
			if(con != null) {
				
				try {
					
					con.close();
					
				} catch(SQLException e) {
					
					e.printStackTrace();
					
				}
				
			}
		}
		
		return studentDtoList;
	}
}
