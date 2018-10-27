package jdbcdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AddAllCSVtoDB {

	public static void addAllCSVtoDB() {
		String propfilelocation = "C://Users//matpadikar//Desktop//Movie-Ticket-Booking//BookingSystem//movieticketbookingsystem.properties";
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(propfilelocation);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		// load a properties file
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// get the property value and set it to usable variables
		String multiplexFileLoc = (prop.getProperty("multiplexCsvLoc"));
		String movieFileLoc = (prop.getProperty("movieCsvLoc"));
		String showsCsvLoc = (prop.getProperty("showsCsvLoc"));
		String screenFileLoc = (prop.getProperty("screenCsvLoc"));
		String staffFileLoc = (prop.getProperty("staffCsvLoc"));
//		System.out.println(showsCsvLoc);

		AddMovieCSVtoDatabase.addMovieCSVtoDatabase(movieFileLoc);
		AddMultiplexCSVtoDatabase.addMultiplexCSVtoDatabase(multiplexFileLoc);
		AddScreenCSVtoDatabase.addScreenCSVtoDatabase(screenFileLoc);
		AddStaffCSVtoDatabase.addStaffCSVtoDatabase(staffFileLoc);
		AddShowsCSVtoDatabase.addShowsCSVtoDatabase(showsCsvLoc);
	}
}
