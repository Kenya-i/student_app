package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	String JDBC_URL = "jdbc:mysql://localhost/student_app?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	
	String USER_ID = "java_user";
	
	String USER_PASS = "password";
	
	public Object[] doInsert(UserDto dto) {
		
		Object[] obj = new Object[2];
		
		try {
			
			Class.forName(DRIVER_NAME);
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		
		// 1つ目: データを登録できたかどうか(true) , 2つ目: まだ同じデータが存在しない(true)
		boolean success = true;
		int autoIncrementKey = 0;
		
		try {
			
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			con.setAutoCommit(false);
			
			StringBuffer sb1 = new StringBuffer();
			sb1.append(" SELECT   ");
			sb1.append(" NAME,    ");
			sb1.append(" PASSWORD ");
			sb1.append(" FROM     ");
			sb1.append(" USER     ");
			
			ps = con.prepareStatement(sb1.toString());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("NAME").equals(dto.getName()) && rs.getString("PASSWORD").equals(dto.getPassword()) ) {
					success = false; // 登録できない(false) →失敗
				}
			}
			
			if(success) { // 同じデータが存在しないなら(true)
				StringBuffer sb2 = new StringBuffer();
				sb2.append("INSERT INTO USER (");
				sb2.append(" NAME,            ");
				sb2.append(" PASSWORD         ");
				sb2.append(" ) VALUES (       ");
				sb2.append(" ?,               ");
				sb2.append(" ? )              ");
				
				ps2 = con.prepareStatement(sb2.toString(), java.sql.Statement.RETURN_GENERATED_KEYS);
				
				ps2.setString(1, dto.getName());
				ps2.setString(2, dto.getPassword());
				
				ps2.executeUpdate();
				
				rs2 = ps2.getGeneratedKeys();
				
				
				if(rs2.next()){
		             autoIncrementKey = rs2.getInt(1);
		         }
				
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
			
			if(rs2 != null) {
				
				try {
					
					rs2.close();
					
				} catch(SQLException e) {
					
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

			if(ps3 != null) {
				
				try {
					
					ps3.close();
					
				} catch(SQLException e) {
					e.printStackTrace();
					
				}
				
			}
			
			if(ps2 != null) {
				
				try {
					
					ps2.close();
					
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

		obj[0] = success;
		obj[1] = autoIncrementKey;
		
		return obj;
	}
	
	
	public UserDto doSelect(String name, String password) {
		
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		UserDto dto = new UserDto();
		
		try {
			
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			
			StringBuffer sb = new StringBuffer();
			
			sb.append("SELECT        ");
			sb.append(" ID,          ");
			sb.append(" NAME         ");
			sb.append(" FROM         ");
			sb.append(" USER         ");
			sb.append(" WHERE        ");
			sb.append(" NAME = ? AND ");
			sb.append(" PASSWORD = ? ");
			
			ps = con.prepareStatement(sb.toString());
			ps.setString(1, name);
			ps.setString(2, password);
			
			rs = ps.executeQuery();
			
			if(rs == null) {
				dto = null;
			} else if(rs.next()) {
				dto.setId(String.valueOf(rs.getString("ID")));
				dto.setName(rs.getString("NAME"));
			}
			
		} catch(SQLException e) {
			
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
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					rs.close();
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return dto;
	}
	
}
