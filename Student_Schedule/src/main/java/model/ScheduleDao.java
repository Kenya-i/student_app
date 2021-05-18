package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ScheduleDao {

	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	String JDBC_URL = "jdbc:mysql://localhost/student_app?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	
	String USER_ID = "java_user";
	
	String USER_PASS = "password";
	
	public int doInsert(ScheduleDto dto) {
		
		try {
			
			Class.forName(DRIVER_NAME);
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		// 1つ目: データを登録できたかどうか(true) , 2つ目: まだ同じデータが存在しない(true)
		boolean success = true;
		int autoIncrementKey = 0;
		
		try {
			
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			con.setAutoCommit(false);
			
			System.out.println("今ここ");
			
			StringBuffer sb = new StringBuffer();
			sb.append(" INSERT INTO SCHEDULE ( ");
			sb.append(" DATE_COLUMN,           ");
			sb.append(" TIME_COLUMN,           ");
			sb.append(" SUBJECT,               ");
			sb.append(" HOMEWORK,              ");
			sb.append(" MEMO,                  ");
			sb.append(" STUDENT_ID             ");
			sb.append(" ) VALUES (             ");
			sb.append(" ?, ?, ?, ?, ?, ?     ) ");
			
			ps = con.prepareStatement(sb.toString(), java.sql.Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, dto.getDate());
			ps.setString(2,  dto.getTime());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getHomework());
			ps.setString(5, dto.getMemo());
			ps.setInt(6,  dto.getStudentId());
			
			ps.executeUpdate();
			
			rs = ps.getGeneratedKeys();
			
			if(rs.next()) {
				autoIncrementKey = rs.getInt(1);
			}
			
			System.out.println("成功しましたtたたたた");
			success = true;
		} catch(SQLException e) {
			
			e.printStackTrace();
			success = false;
			
		} finally {

			if(success) {
				
				try {

					con.commit();
					
				} catch (SQLException e) {
					System.out.println("con.commitの例外処理");
					e.printStackTrace();
					
				}
				
			} else {
				
				try {
					
					con.rollback();
					
				} catch (SQLException e) {
					System.out.println("con.rollbackの例外処理");
					e.printStackTrace();
					
				}
				
			}
			
			if(rs != null) {
				
				try {

					rs.close();
					
				} catch(SQLException e) {
					System.out.println("ps.closeの例外処理");
					e.printStackTrace();
					
				}
				
			}
			
 			
			if(ps != null) {
				
				try {

					ps.close();
					
				} catch(SQLException e) {
					System.out.println("ps.closeの例外処理");
					e.printStackTrace();
					
				}
				
			}
			
			if(con != null) {
				
				try {
					
					con.close();
					
				} catch(SQLException e) {
					System.out.println("con.closeの例外処理");
					e.printStackTrace();
					
				}
				
			}
			
		}
		
		return autoIncrementKey;
	}
	
	public boolean doDelete(int scheduleId){
		
		System.out.println("dao入った");
		
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
			
			System.out.println("delete手前shcedule");
			
			StringBuffer sb = new StringBuffer();
			sb.append(" DELETE FROM SCHEDULE       ");
			sb.append(" WHERE ID = ?;               ");
			
			System.out.println("toString後schedule");
			
			ps = con.prepareStatement(sb.toString());
					
			ps.setInt(1, scheduleId);
			
			int result = ps.executeUpdate();
			
			if(result == 1) {
				success = true;
			} else {
				success = false;
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
	
	
	public boolean doUpdate(ScheduleDto dto) {
		
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
			sb.append(" UPDATE SCHEDULE    ");
			sb.append(" SET                ");
			sb.append("   DATE_COLUMN=?,   ");
			sb.append("   TIME_COLUMN=?,   ");
			sb.append("   SUBJECT=?,       ");
			sb.append("   HOMEWORK=?,      ");
			sb.append("   MEMO=?           ");
			sb.append(" WHERE  ID=?;       ");
			
			ps = con.prepareStatement(sb.toString());
			
			ps.setString(1, dto.getDate());
			ps.setString(2, dto.getTime());
			ps.setString(3, dto.getSubject());
			ps.setString(4, dto.getHomework());
			ps.setString(5, dto.getMemo());
			ps.setInt(6, dto.getScheduleId());
			
			
			ps.executeUpdate();
			
			success = true;
			
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
			
			if(rs != null) {
				
				try {

					rs.close();
					
				} catch(SQLException e) {
					System.out.println("ps.closeの例外処理");
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
