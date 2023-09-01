package codegym;

import java.sql.Date;
import java.util.List;

import codegym.dao.EmployeesDAO;

public class Service {
	
	public void addEmp(String lastName, String firstName, String birthDate){
		birthDate = birthDate.replace("/", "-");
		Date date = Date.valueOf(birthDate);
		
		EmployeesDAO dao = new EmployeesDAO();
		dao.insert(lastName, firstName, date);
	}
	
	public List<String[]> findAllEmp(){
		EmployeesDAO dao = new EmployeesDAO();
		List<String[]> ret = dao.selectAll();
		
		return ret;
	}
}
