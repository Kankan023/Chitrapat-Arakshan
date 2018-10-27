package Main;

import java.sql.SQLException;
import jdbcdemo.CreateTables;

public class CreateAllRequiredTablesfromCSV {

	public static void createTables() throws ClassNotFoundException, SQLException {

		CreateTables.createTable("MULTIPLEX",
				"(screen_id INTEGER not NULL, " + " capacity INTEGER, " + " PRIMARY KEY ( screen_id ))");
		CreateTables.createTable("SHOWS",
				"(show_id INTEGER not NULL, " + " screen_id INTEGER, " + " timing VARCHAR(255), "
						+ " date VARCHAR(255), " + " movie_name VARCHAR(255), " + " PRIMARY KEY ( show_id ))");
		CreateTables.createTable("MOVIE",
				"(movie_id INTEGER not NULL, " + " movie_name VARCHAR(255), " + " language VARCHAR(255), "
						+ " duration INTEGER, " + " rating float, " + " movie_genre VARCHAR(255), "
						+ " starcast VARCHAR(255), " + " director VARCHAR(255), " + " PRIMARY KEY ( movie_id ))");
		CreateTables.createTable("STAFF", "(staff_id INTEGER not NULL, " + " staff_name VARCHAR(255), "
				+ " age INTEGER, " + " mobile VARCHAR(255), " + " PRIMARY KEY ( staff_id ))");
		CreateTables.createTable("SCREEN", "(screen_id INTEGER not NULL, " + " rows_number INTEGER not NULL, "
				+ " seats INTEGER not NULL, " + " PRIMARY KEY ( screen_id ))");
		CreateTables.createTable("RESERVATION", "(ticket_id INTEGER not NULL, " + " mobile_number INTEGER not NULL, "
				+ " screen_id INTEGER not NULL, " +" timing INTEGER not NULL, " +" row_id INTEGER not NULL, "+" seat_id INTEGER not NULL, " + " PRIMARY KEY (ticket_id ))");

	}
}
