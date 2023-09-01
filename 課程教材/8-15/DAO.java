package codegym;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import codegym.Helper;

public class DAO {
	
	public void insertEmp(Employees emp){
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		String sql = "insert into employees(lastname, firstname, birthdate) values(?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.getLastname());
			stmt.setString(2, emp.getFirstname());
			stmt.setDate(3, emp.getBirthdate());
			stmt.execute();
			conn.commit();
			
		}catch(Exception e){
			e.printStackTrace();
			try{
				conn.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}finally{
			helper.closeConn(conn);
		}
	}
}
