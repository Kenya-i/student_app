package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleListDao {
	
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	String JDBC_URL = "jdbc:mysql://localhost/student_app?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	
	String USER_ID = "java_user";
	
	String USER_PASS = "password";
	
	public List<ScheduleDto> doSelect(int scheduleId) {
		
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<ScheduleDto> scheduleList = new ArrayList<ScheduleDto>();
		
		try {
			
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			
			StringBuffer sb = new StringBuffer();
			
			sb.append(" SELECT          ");
			sb.append("  ID,            ");
			sb.append("  DATE_COLUMN,   ");
			sb.append("  TIME_COLUMN,   ");
			sb.append("  SUBJECT,       ");
			sb.append("  HOMEWORK,      ");
			sb.append("  MEMO           ");
			sb.append("  FROM           ");
			sb.append("  SCHEDULE       ");
			sb.append(" WHERE           ");
			sb.append("  STUDENT_ID = ? ");
			
			ps = con.prepareStatement(sb.toString());
			
			ps.setInt(1, scheduleId);
			rs = ps.executeQuery();
			
			int num = 0;
			while(rs.next()) {
				ScheduleDto dto = new ScheduleDto();
				dto.setScheduleId(rs.getInt("ID"));
				dto.setDate(rs.getString("DATE_COLUMN"));
				dto.setTime(rs.getString("TIME_COLUMN"));
				dto.setSubject(rs.getString("SUBJECT"));
				dto.setHomework(rs.getString("HOMEWORK"));
				dto.setMemo(rs.getString("MEMO"));
				dto.setNumber(num);
				scheduleList.add(dto);
				num++;
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
		
		return scheduleList;
	}
}
