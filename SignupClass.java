package servlet_jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SignupClass extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		Employee employee = new Employee();
		
		
		EmployeeCRUD crud = new EmployeeCRUD();
		
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		long phone = Long.parseLong(req.getParameter("phone"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		employee.setId(id);
		employee.setName(name);
		employee.setPhone(phone);
		employee.setAddress(address);
		employee.setEmail(email);
		employee.setPassword(password);

		try {
			int result = crud.signUp(employee);
			PrintWriter printwriter = res.getWriter();
			if (result != 0) {
				printwriter.print("Signup Successful");
			} else {
				printwriter.print("Signup Failed");
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}

	}

}
