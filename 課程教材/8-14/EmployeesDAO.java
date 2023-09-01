package codegym.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class EmployeesDAO {
	
	public void insert(String lastName, String firstName, Date birthDate){
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		String sql = "insert into employees(lastname, firstname, birthdate) values(?,?,?)";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, lastName);
			stmt.setString(2, firstName);
			stmt.setDate(3, birthDate);
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
	
	public List<String[]> selectAll(){
		List<String[]> ret = new ArrayList<String[]>();
		Helper helper = new Helper();
		Connection conn = helper.getConn();
		String sql = "select employeeid, lastname, firstname, birthdate from employees";
		
		try{
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()){
				String[] emp = new String[4];
				emp[0] = rs.getString("employeeid");
				emp[1] = rs.getString("lastname");
				emp[2] = rs.getString("firstname");
				
				Date date = rs.getDate("birthdate");
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				String dateStr = df.format(date);
				emp[3] = dateStr;
				
				ret.add(emp);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			helper.closeConn(conn);
		}
		
		return ret;
	}
}
