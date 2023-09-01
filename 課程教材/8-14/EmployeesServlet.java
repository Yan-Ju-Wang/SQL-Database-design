package codegym;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeesServlet")
public class EmployeesServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String birthdate = request.getParameter("birthdate");
		
		Service service = new Service();
		if(lastname != null && firstname != null && birthdate != null)
			service.addEmp(lastname, firstname, birthdate);
		
		List<String[]> list = service.findAllEmp();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);		
		
	}
}
