package jdbcdemo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookTicket {
	static int ticketId= 0;
	public static void ReserveTicket(int number,int screen_id,int timing,int row_id, int seat_id) throws SQLException, ClassNotFoundException {
		
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = null;
	try {
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false",
				"root", "1234567890");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		Statement myState = null;

//			myState = con.createStatement();
			// the mysql insert statement
			// create the mysql insert preparedstatement
			String query = " insert into RESERVATION (ticket_id,mobile_number,screen_id,timing,row_id,seat_id)"
					+ " values (?, ?, ?, ?, ?,?)";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setInt (1, ticketId);
			preparedStmt.setInt (2, number);
			preparedStmt.setInt   (3, screen_id);
			preparedStmt.setInt(4,timing);
			preparedStmt.setInt    (5,row_id);
			preparedStmt.setInt    (6, seat_id);


//		String query = "INSERT INTO RESERVATION (ticket_id,mobile_number,screen_id,timing,row_id,seat_id)" + 
//				"VALUES ("+ ticketId +","+number+","+screen_id+","+ timing + ","+row_id+","+seat_id+")";

		
		

			preparedStmt.execute();

	}
}
