package servlet_jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;




public class EmployeeCRUD {
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		
		Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	//	Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb?user=root&password=root");
		return connection;
	}
	public int signUp(Employee employee) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE_JSP1 VALUES(?,?,?,?,?,?)");
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getAddress());
		preparedStatement.setString(5, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());

		int res = preparedStatement.executeUpdate();

		connection.close();
		return res;
	}
	public String login(String email) throws SQLException, IOException, ClassNotFoundException {
		Connection connection=getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("SELECT PASSWORD FROM EMP WHERE EMAIL=?");
		preparedStatement.setString(1, email);
		ResultSet resultSet=preparedStatement.executeQuery();
		String password=null;
		while (resultSet.next()) {
			password=resultSet.getString("password");
			
		}
		connection.close();
		return password;
	}
	
	

}
