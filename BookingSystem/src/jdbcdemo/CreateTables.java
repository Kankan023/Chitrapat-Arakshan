package jdbcdemo;

import java.sql.*;

public class CreateTables {

	public static void createTable(String tableName, String columnString) throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
//		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false", "root", "1234567890");


			// Execute a create query
			System.out.println("Creating table " + tableName + " in given database...");
			stmt = conn.createStatement();

			String sql = "DROP TABLE IF EXISTS " + tableName  ;

			stmt.executeUpdate(sql);
			
			String sql1 = "CREATE TABLE " + tableName + " " + columnString;

			stmt.executeUpdate(sql1);
			System.out.println("Created table " + tableName + " in given database...");
		    System.out.println("Goodbye!");
	}// end main
}// end JDBCExample
