package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDao {
	
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	String JDBC_URL = "jdbc:mysql://localhost/student_app?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	
	String USER_ID = "java_user";
	
	String USER_PASS = "password";
	
	public int doInsert(StudentDto dto) {
		
		try {
			
			Class.forName(DRIVER_NAME);
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		boolean success = true;
		int autoIncrementKey = 0;
		
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
			
			ps = con.prepareStatement(sb.toString(), java.sql.Statement.RETURN_GENERATED_KEYS);
			
			
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getSchoolGrade());
			ps.setString(3, dto.getGender());
			ps.setInt(4, dto.getTeacherId());
			
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				autoIncrementKey = rs.getInt(1);
				success = true;
			}
			
			
		} catch(SQLException e) {
			
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
			
			if(rs != null) {
				
				try {

					rs.close();
					
				} catch(SQLException e) {
					
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

		return autoIncrementKey;
	}
	
	
	public boolean doDelete(int studentId){
		
		try {
			
			Class.forName(DRIVER_NAME);
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		
		boolean success = false;
		
		try {
			
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			con.setAutoCommit(false);
			

			
			StringBuffer sb = new StringBuffer();
			sb.append(" DELETE STUDENT, SCHEDULE            ");
			sb.append(" FROM STUDENT                        ");
			sb.append(" LEFT JOIN SCHEDULE                  ");
			sb.append(" ON STUDENT.ID = SCHEDULE.STUDENT_ID ");
			sb.append(" WHERE STUDENT.ID = ?;               ");
			
			ps = con.prepareStatement(sb.toString());
					
			ps.setInt(1, studentId);
			
			ps.executeUpdate();
			
			success = true;
			
		} catch(SQLException e) {
			
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
	
	
	public boolean doUpdate(StudentDto dto) {
		
		try {
			
			Class.forName(DRIVER_NAME);
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		boolean success = false;

		
		try {
			
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			con.setAutoCommit(false);
			
			StringBuffer sb = new StringBuffer();
			sb.append(" UPDATE STUDENT     ");
			sb.append(" SET                ");
			sb.append("   NAME=?,          ");
			sb.append("   SCHOOL_GRADE=?,  ");
			sb.append("   GENDER=?,        ");
			sb.append("   TEACHER_ID=?     ");
			sb.append(" WHERE  ID=?;       ");
			
			ps = con.prepareStatement(sb.toString());
			
			ps.setString(1, dto.getName());
			ps.setString(2, dto.getSchoolGrade());
			ps.setString(3, dto.getGender());
			ps.setInt(4, dto.getTeacherId());
			ps.setInt(5, dto.getStudentId());
			
			ps.executeUpdate();
			
			success = true;
			
		} catch(SQLException e) {
			
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
			
			if(rs != null) {
				
				try {

					rs.close();
					
				} catch(SQLException e) {

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
