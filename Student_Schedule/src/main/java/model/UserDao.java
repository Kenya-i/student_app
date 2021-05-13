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
	
	public boolean[] doInsert(UserDto dto) {
		
		
		try {
			
			Class.forName(DRIVER_NAME);
			
		} catch(ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps2 = null;
		
		// 1つ目: データを登録できたかどうか(true) , 2つ目: まだ同じデータが存在しない(true)
		boolean[] successes = {true, true};
		
		
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
				System.out.println("whileの中だよ");
				System.out.println(dto.getName());
				System.out.println(dto.getPassword());
				System.out.println(rs.getString("NAME"));
				System.out.println(rs.getString("PASSWORD"));
				System.out.println(rs.getString("NAME") == dto.getName());
				if(rs.getString("NAME").equals(dto.getName()) && rs.getString("PASSWORD").equals(dto.getPassword()) ) {
					System.out.println("whileのなかの失敗だよ");
					successes[0] = false; // 登録できない(false) →失敗
					successes[1] = false; // 同じデータが存在する(false)→失敗
				}
			}
			
			if(successes[1]) { // 同じデータが存在しないなら(true)
				StringBuffer sb2 = new StringBuffer();
				sb2.append("INSERT INTO USER (");
				sb2.append(" NAME,            ");
				sb2.append(" PASSWORD         ");
				sb2.append(" ) VALUES (       ");
				sb2.append(" ?,               ");
				sb2.append(" ? )              ");
				
				ps2 = con.prepareStatement(sb2.toString());
				
				ps2.setString(1, dto.getName());
				ps2.setString(2, dto.getPassword());
				
				ps2.executeUpdate();
				
				System.out.println("successに入ったよ");
			}
			
		} catch(SQLException e) {
			System.out.println("ayayato");
			e.printStackTrace();
			successes[0] = false;
			
		} finally {

			if(successes[0]) {
				
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
					System.out.println("rs.closeの例外処理");
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
		
		System.out.println("たどり着いたよ!");
		return successes;
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
			System.out.println(sb.toString());
			
			ps.setString(1, name);
			ps.setString(2, password);
			
			System.out.println(ps);
			
			System.out.println(sb.toString());
			
			rs = ps.executeQuery();
			
			System.out.println(rs);
			
			if(rs.next()) {
				dto.setId(String.valueOf(rs.getString("ID")));
				dto.setName(rs.getString("NAME"));
			}
			
		} catch(SQLException e) {
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
