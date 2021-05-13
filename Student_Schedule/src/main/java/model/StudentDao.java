package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
	
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	String JDBC_URL = "jdbc:mysql://localhost/student_app?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	
	String USER_ID = "java_user";
	
	String USER_PASS = "password";
	
	public boolean doInsert(StudentDto dto) {
		
		try {
			
			Class.forName(DRIVER_NAME);
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		
		boolean success = true;
		
		try {
			
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			con.setAutoCommit(false);
			
			StringBuffer sb = new StringBuffer();
			sb.append(" INSERT INTO STUDENT ( ");
			sb.append(" NAME,                 ");
			sb.append(" SCHOOL_GRADE,         ");
			sb.append(" GENDER,                  ");
			sb.append(" TEACHER_ID            ");
			sb.append(" ) VALUES (            ");
			sb.append(" ?,                    ");
			sb.append(" ?,                    ");
			sb.append(" ?,                    ");
			sb.append(" ?                   ) ");
			System.out.println("insert");
			
			ps = con.prepareStatement(sb.toString());
			
			System.out.println(ps);
			
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getSchoolGrade());
			ps.setString(3, dto.getGender());
			ps.setInt(4, dto.getTeacherId());
			
			ps.executeUpdate();
			
			System.out.println(sb.toString());
			
		} catch(SQLException e) {
			System.out.println(e);
			System.out.println("例外");
			
			e.printStackTrace();
			success = false;
			
		} finally {
			
			if(success) {
				
				try {
					con.commit();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} else {
				
				try {
					con.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return success;
	}
}
