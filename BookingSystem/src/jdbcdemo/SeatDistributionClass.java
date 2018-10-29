package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SeatDistributionClass {

	HashMap<Integer, Integer> seatmap = new HashMap<Integer, Integer>();

	public HashMap seatdistributionclass(int screennum) throws SQLException {

		ConectionToDataBase connToDB = new ConectionToDataBase();
		String userName = connToDB.getUserName();
		String password = connToDB.getDataBasePassword();
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false", userName, password);
		} catch (Exception e) {
			System.out.println(" DB Query Error...!!!");
			e.printStackTrace();
		}

		Statement myState = con.createStatement();

		String query = "SELECT * FROM SCREEN WHERE screen_id = " + screennum;
		ResultSet myRes = myState.executeQuery(query);

		int rows = 0, seats = 0;

		while (myRes.next()) { // retrieve data
			rows = myRes.getInt("rows_number");
			seats = myRes.getInt("seats");

			for (int j = 1; j <= rows; j++) {
				for (int k = 1; k <= rows; k++) {
					seatmap.put(j, k);
				}
			}
		}
		return seatmap;
	}
}
