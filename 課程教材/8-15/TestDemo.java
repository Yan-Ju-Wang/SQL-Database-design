package codegym;

public class TestDemo {

	public static void main(String[] args) {
		Employees emp = new Employees();
		emp.setFirstname("Wang");
		emp.setLastname("Mary");
		emp.setBirthdate("1990-07-07");
		
		DAO dao = new DAO();
		dao.insertEmp(emp);
	}

}
