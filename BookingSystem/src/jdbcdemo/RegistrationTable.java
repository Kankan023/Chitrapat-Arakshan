package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationTable {
	public void reg_table_creation() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
//		Class.forName("com.mysql.cj.jdbc.Driver");
		ConectionToDataBase connToDB = new ConectionToDataBase();
		String userName = connToDB.getUserName();
		String password = connToDB.getDataBasePassword();
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false", userName, password);
		String tableName = "RESERVATION";
		// Execute a create query
		System.out.println("Creating table " + tableName + " in given database...");
		stmt = conn.createStatement();

		String columnString = "(ticket_id INTEGER not NULL, " + " username VARCHAR(255) not NULL, "
				+ " mobile_number LONG not NULL, " + " screen_id INTEGER not NULL, " + " timing VARCHAR(255) not NULL, "
				+ " date VARCHAR(255) not NULL, " + " row_id VARCHAR(255) not NULL, " + " seat_id INTEGER not NULL, "
				+ " PRIMARY KEY (ticket_id ))";

		String sql1 = "CREATE TABLE " + tableName + " " + columnString;

		stmt.executeUpdate(sql1);
		System.out.println("Created table " + tableName + " in given database...");

	}
}
