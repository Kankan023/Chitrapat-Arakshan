package jdbcdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SeatbookingForShows {

	HashMap<String, HashMap<Integer, Integer>> seatmap1 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap2 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap3 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap4 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap5 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap6 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap7 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap8 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap9 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap10 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap11 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap12 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap13 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap14 = new HashMap<String, HashMap<Integer, Integer>>();
	HashMap<String, HashMap<Integer, Integer>> seatmap15 = new HashMap<String, HashMap<Integer, Integer>>();

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap1() {
		return seatmap1;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap2() {
		return seatmap2;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap3() {
		return seatmap3;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap4() {
		return seatmap4;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap5() {
		return seatmap5;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap6() {
		return seatmap6;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap7() {
		return seatmap7;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap8() {
		return seatmap8;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap9() {
		return seatmap9;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap10() {
		return seatmap10;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap11() {
		return seatmap11;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap12() {
		return seatmap12;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap13() {
		return seatmap13;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap14() {
		return seatmap14;
	}

	public HashMap<String, HashMap<Integer, Integer>> getSeatmap15() {
		return seatmap15;
	}

	public void seatbookingshows() throws SQLException {

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

		int show_id = 0;
		Statement statement = con.createStatement();
		ResultSet resultSet = statement.executeQuery("select count(*) from SHOWS");

		while (resultSet.next()) {
			show_id = resultSet.getInt(1);
			show_id++;
		}

		for (int i = 1; i < show_id; i++) {
			Statement myState = con.createStatement();
			String query = "SELECT * FROM SHOWS WHERE show_id = " + i;

			ResultSet myRes = myState.executeQuery(query);
			int screen_id = 0;
			String timing = null;

			while (myRes.next()) { // retrieve data
				screen_id = myRes.getInt("screen_id");
				timing = myRes.getString("timing");
			}
			if (i == 1) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap1.put(timing, seatmap1a);
			} else if (i == 2) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap2.put(timing, seatmap1a);
			} else if (i == 3) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap3.put(timing, seatmap1a);
			} else if (i == 4) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap4.put(timing, seatmap1a);
			} else if (i == 5) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap5.put(timing, seatmap1a);
			} else if (i == 6) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap6.put(timing, seatmap1a);
			} else if (i == 7) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap7.put(timing, seatmap1a);
			} else if (i == 8) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap8.put(timing, seatmap1a);
			} else if (i == 9) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap9.put(timing, seatmap1a);
			} else if (i == 10) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap10.put(timing, seatmap1a);
			} else if (i == 11) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap11.put(timing, seatmap1a);
			} else if (i == 12) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap12.put(timing, seatmap1a);
			} else if (i == 13) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap13.put(timing, seatmap1a);
			} else if (i == 14) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap14.put(timing, seatmap1a);
			} else if (i == 15) {
				SeatDistributionClass sdc = new SeatDistributionClass();
				HashMap<Integer, Integer> seatmap1a = sdc.seatdistributionclass(screen_id);
				seatmap15.put(timing, seatmap1a);
			}
		}
	}
}
