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

import ObjectPackage.MultiplexTable;

public class AddMultiplexCSVtoDatabase {

	public static void addMultiplexCSVtoDatabase(String csvfileloc) {
		LinkedList<MultiplexTable> multiplexTables = readMultiplexEntriesFromCSV(csvfileloc);
		for (MultiplexTable mlt : multiplexTables) {
			System.out.println(mlt);
		}
	}

	private static MultiplexTable createMultiplexEntry(String[] metadata) {
		int screen_id = Integer.parseInt(metadata[0]);
		int capacity = Integer.parseInt(metadata[1]);

		return new MultiplexTable(screen_id, capacity);
	}

	private static LinkedList<MultiplexTable> readMultiplexEntriesFromCSV(String fileName) {
		LinkedList<MultiplexTable> MultiplexTables = new LinkedList<>();
		Path pathToFile = Paths.get(fileName);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.ISO_8859_1)) {
			// read the first line from the text file
			String line = br.readLine();
			// loop until all lines are read
			while (line != null) {
				// use string.split to load a string array with the values from // each line of
				// // the file, using a comma as the delimiter
				String[] attributes = line.split(",");
				MultiplexTable multiplexTable = createMultiplexEntry(attributes);

				// Adding Entries into DB:
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false",
							"root", "1234567890");

					// the mysql insert statement
					String query = " insert into MULTIPLEX (screen_id, capacity)" + " values (?, ?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.setInt(1, Integer.parseInt(attributes[0]));
					preparedStmt.setInt(2, Integer.parseInt(attributes[1]));
					// execute the prepared statement
					preparedStmt.execute();
					con.close();
				} catch (Exception e) {
					System.out.println(" DB Query Error...!!!");
					e.printStackTrace();
				}

				// adding book into ArrayList
				MultiplexTables.add(multiplexTable);
				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return MultiplexTables;

	}

}
