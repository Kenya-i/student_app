package model;

public class StudentUpdateDao {

	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	String JDBC_URL = "jdbc:mysql://localhost/student_app?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	
	String USER_ID = "java_user";
	
	String USER_PASS = "password";
	
//	public boolean doUpdate(StudentDto dto) {
//		
//		try {
//			
//			Class.forName(DRIVER_NAME);
//			
//		} catch(ClassNotFoundException e) {
//			
//			e.printStackTrace();
//			
//		}
//		
//		Connection con = null;
//		PreparedStatement ps = null;
//		ResultSet rs = null;
//		
//		boolean success = false;
//		int autoIncrementKey = 0;
//		
//		try {
//			
//			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
//			con.setAutoCommit(false);
//			
//			StringBuffer sb = new StringBuffer();
//			sb.append(" UPDATE STUDENT     ");
//			sb.append(" SET                ");
//			sb.append("   NAME=?,          ");
//			sb.append("   SCHOOL_GRADE=?,  ");
//			sb.append("   GENDER=?,        ");
//			sb.append("   TEACHER_ID=?     ");
//			sb.append(" WHERE  ID=?;       ");
//			
//			ps = con.prepareStatement(sb.toString());
//			
//			ps.setString(1, dto.getName());
//			ps.setString(2, dto.getSchoolGrade());
//			ps.setString(3, dto.getGender());
//			ps.setInt(4, dto.getTeacherId());
//			ps.setInt(5, dto.getStudentId());
//			
//			System.out.println(dto.getStudentId());
//			
//			ps.executeUpdate();
//			
//			System.out.println(autoIncrementKey);
//			
//			success = true;
//			
//		} catch(SQLException e) {
//			System.out.println(e);
//			System.out.println("例外");
//			
//			e.printStackTrace();
//			success = false;
//			
//		} finally {
//			
//			if(success) {
//				
//				try {
//					con.commit();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				
//			} else {
//				
//				try {
//					con.rollback();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//				
//			}
//			
//			if(rs != null) {
//				
//				try {
//
//					rs.close();
//					
//				} catch(SQLException e) {
//					System.out.println("ps.closeの例外処理");
//					e.printStackTrace();
//					
//				}
//				
//			}
//			
//			if (ps != null) {
//				
//				try {
//					
//					ps.close();
//					
//				} catch (SQLException e) {
//					
//					e.printStackTrace();
//					
//				}
//				
//			}
//
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
//
//		return success;
//	}
}
