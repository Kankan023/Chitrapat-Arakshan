package jdbcdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.LinkedList;
import ObjectPackage.ShowsTable;

public class AddShowsCSVtoDatabase {
	
	public static void addShowsCSVtoDatabase(String csvfileloc) {
		LinkedList<ShowsTable> priceTables = readPriceEntriesFromCSV(csvfileloc);
		for (ShowsTable pt : priceTables) {
			System.out.println(pt);
		}
	}
	
	private static ShowsTable createShowsEntry(String[] metadata) {
		int shows_id = Integer.parseInt(metadata[0]);
		int screen_id = Integer.parseInt(metadata[1]);
		String timing = metadata[2];
		String date = metadata[3];
		String movie_name = metadata[4];
		
		return new ShowsTable(shows_id, screen_id, timing, date, movie_name);
	}

	private static LinkedList<ShowsTable> readPriceEntriesFromCSV(String fileName) {
		LinkedList<ShowsTable> PriceTables = new LinkedList<>();
		Path pathToFile = Paths.get(fileName);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) {
			// read the first line from the text file
			String line = br.readLine();
			// loop until all lines are read
			while (line != null) {
				// use string.split to load a string array with the values from // each line of
				// // the file, using a comma as the delimiter
				String[] attributes = line.split(",");
				ShowsTable priceTable = createShowsEntry(attributes);
				
				// Adding Entries into DB:
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false",
							"root", "1234567890");

					// the mysql insert statement
					String query = " insert into SHOWS (show_id, screen_id, timing, date, movie_name)"
							+ " values (?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.setInt(1, Integer.parseInt(attributes[0]));
					preparedStmt.setInt(2, Integer.parseInt(attributes[1]));
					preparedStmt.setString(3, attributes[2]);
					preparedStmt.setString(4, attributes[3]);
					preparedStmt.setString(5, attributes[4]);

					// execute the prepared statement
					preparedStmt.execute();
					con.close();
				} catch (Exception e) {
					System.out.println(" DB Query Error...!!!");
					e.printStackTrace();
				}
				
				// adding book into ArrayList
				PriceTables.add(priceTable);
				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return PriceTables;
	}
}
