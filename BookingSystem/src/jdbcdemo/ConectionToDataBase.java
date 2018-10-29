package jdbcdemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConectionToDataBase {
	private String dataBasePassword = null;
	private String userName = null;
	
	{
		String propfilelocation = "C://Users//ljoshi//eclipse-workspace//MovieTicketBookingSystem//movieticketbookingsystem.properties";
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
		dataBasePassword = (prop.getProperty("DBPassword"));
		userName = (prop.getProperty("DBUsername"));
	}

	public String getDataBasePassword() {
		return dataBasePassword;
	}

	public String getUserName() {
		return userName;
	}

}
