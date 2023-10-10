package servlet_jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginClass extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		EmployeeCRUD crud=new EmployeeCRUD();
		String dbpassword;
		try {
			dbpassword = crud.login(email);
		
		PrintWriter printWriter=res.getWriter();
		if(password.equals(dbpassword))
		{
			printWriter.print("Login successful");
			RequestDispatcher dispatcher=req.getRequestDispatcher("success.html");
			dispatcher.forward(req, res);
		}
		else {
			printWriter.print("Login failed");
			RequestDispatcher dispatcher=req.getRequestDispatcher("login.html");
			dispatcher.include(req, res);
		}
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	

}
