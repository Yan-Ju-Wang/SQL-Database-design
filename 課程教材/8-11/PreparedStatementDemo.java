package codegym;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

public class PreparedStatementDemo {
	
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://127.0.0.1/orders";
	public static final String USER = "root";
	public static final String PASS = "1234";

	public static void main(String[] args) {
		Connection conn = null;
		try{
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			String sql = "select * from employees where employeeid = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 2);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				int id = rs.getInt("employeeid");
				String lastname = rs.getString("lastname");
				String firstname = rs.getString("firstname");
				System.out.println(id + "," + lastname + "," + firstname);
			}
			
		} catch(Exception e){
			e.printStackTrace();
		} finally{
			try{
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
}
