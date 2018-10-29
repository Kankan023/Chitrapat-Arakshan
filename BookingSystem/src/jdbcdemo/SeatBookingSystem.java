package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SeatBookingSystem {

	HashMap<Integer, Integer> seatmap1 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> seatmap2 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> seatmap3 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> seatmap4 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> seatmap5 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> seatmap6 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> seatmap7 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> seatmap8 = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> seatmap9 = new HashMap<Integer, Integer>();

	public void seatbookingsystem() throws SQLException {

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

		int screennum = 0;
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("select count(*) from RESERVATION");

		while (resultSet.next()) {
			screennum = resultSet.getInt(1);
			screennum++;
		}

		for (int i = 1; i <= screennum; i++) {

			if (i == 1) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				seatmap1 = sdc.seatdistributionclass(i);
			} else if (i == 2) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				seatmap2 = sdc.seatdistributionclass(i);
			} else if (i == 3) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				seatmap3 = sdc.seatdistributionclass(i);
			} else if (i == 4) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				seatmap4 = sdc.seatdistributionclass(i);
			} else if (i == 5) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				seatmap5 = sdc.seatdistributionclass(i);
			} else if (i == 6) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				seatmap6 = sdc.seatdistributionclass(i);
			} else if (i == 7) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				seatmap7 = sdc.seatdistributionclass(i);
			} else if (i == 8) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				seatmap8 = sdc.seatdistributionclass(i);
			} else if (i == 9) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				seatmap9 = sdc.seatdistributionclass(i);
			}
		}

	}

	public HashMap<Integer, Integer> getSeatmap1() {
		return seatmap1;
	}

	public HashMap<Integer, Integer> getSeatmap2() {
		return seatmap2;
	}

	public HashMap<Integer, Integer> getSeatmap3() {
		return seatmap3;
	}

	public HashMap<Integer, Integer> getSeatmap4() {
		return seatmap4;
	}

	public HashMap<Integer, Integer> getSeatmap5() {
		return seatmap5;
	}

	public HashMap<Integer, Integer> getSeatmap6() {
		return seatmap6;
	}

	public HashMap<Integer, Integer> getSeatmap7() {
		return seatmap7;
	}

	public HashMap<Integer, Integer> getSeatmap8() {
		return seatmap8;
	}

	public HashMap<Integer, Integer> getSeatmap9() {
		return seatmap9;
	}
}
