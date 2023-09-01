package codegym;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class FirstDemo {
	
	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://127.0.0.1/orders";
	public static final String USER = "root";
	public static final String PASS = "1234";

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		try{
			Class.forName(JDBC_DRIVER);
			
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			String sql = "select * from employees";
			ResultSet rs = stmt.executeQuery(sql);
			
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
