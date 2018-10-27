package Main;

import java.sql.*;

import jdbcdemo.AddAllCSVtoDB;
import jdbcdemo.CreateTables;

public class TicketBooking {

	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		try {
//			
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false", "root",
//					"1234567890");
//			Statement stmt = con.createStatement();
//			String query = "SELECT * FROM Movies_Table";
//			// the mysql insert statement
//			String query1 = " insert into Movies_Table (duration, movie_name, screen_id, rating, movie_genre)"
//					+ " values (?, ?, ?, ?, ?)";
//			PreparedStatement preparedStmt = con.prepareStatement(query1);
//			preparedStmt.setInt(1, 145);
//			preparedStmt.setString(2, "Street");
//			preparedStmt.setInt(3, 6);
//			preparedStmt.setFloat(4, (float) 4);
//			preparedStmt.setString(5, "Horror");
//
//			// execute the prepared statement
//			preparedStmt.execute();
//
//			ResultSet rs = stmt.executeQuery(query);
//			// iterate through the java result-set
//			while (rs.next()) {
//				int duration = rs.getInt("duration");
//				String movie_name = rs.getString("movie_name");
//				int screen_id = rs.getInt("screen_id");
//				float rating = rs.getFloat("rating");
//				String genre = rs.getString("movie_genre");
//
//				// print the results
//				System.out
//						.println(movie_name + " " + duration + " " + screen_id + " " + rating + " " + genre + "\n");
//			}
//			con.close();
//		} catch (Exception e) {
//			System.out.println(" DB Query Error...!!!");
//			e.printStackTrace();
//		}
		CreateAllRequiredTablesfromCSV.createTables();
		AddAllCSVtoDB.addAllCSVtoDB();
		
		
	
		//CreateTables.createTable("REGISTRATION", "(id INTEGER not NULL, " + " first VARCHAR(255), " + " last VARCHAR(255), " + " age INTEGER, "
		//		+ " mobile INTEGER, " + " PRIMARY KEY ( id ))");
	}
}
