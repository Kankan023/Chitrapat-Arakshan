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
import ObjectPackage.StaffTable;

public class AddStaffCSVtoDatabase {

	public static void addStaffCSVtoDatabase(String csvfileloc) {
		LinkedList<StaffTable> staffTables = readStaffEntriesFromCSV(csvfileloc);
		for (StaffTable st : staffTables) {
			System.out.println(st);
		}
	}

	private static StaffTable createStaffEntry(String[] metadata) {
		String staff_name = metadata[0];
		int staff_id = Integer.parseInt(metadata[1]);
		int age = Integer.parseInt(metadata[2]);
		String mobile = metadata[3];

		return new StaffTable(staff_name, staff_id, age, mobile);
	}

	private static LinkedList<StaffTable> readStaffEntriesFromCSV(String fileName) {
		LinkedList<StaffTable> StaffTables = new LinkedList<>();
		Path pathToFile = Paths.get(fileName);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.ISO_8859_1)) {
			// read the first line from the text file
			String line = br.readLine();
			// loop until all lines are read
			while (line != null) {
				// use string.split to load a string array with the values from // each line of
				// // the file, using a comma as the delimiter
				String[] attributes = line.split(",");
				StaffTable staffTable = createStaffEntry(attributes);

				// Adding Entries into DB:
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false",
							"root", "1234567890");

					// the mysql insert statement
					String query = " insert into STAFF (staff_name, staff_id, age, mobile)"
							+ " values (?, ?, ?, ?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.setString(1, attributes[0]);
					preparedStmt.setInt(2, Integer.parseInt(attributes[1]));
					preparedStmt.setInt(3, Integer.parseInt(attributes[2]));
					preparedStmt.setString(4, attributes[3]);

					// execute the prepared statement
					preparedStmt.execute();
					con.close();
				} catch (Exception e) {
					System.out.println(" DB Query Error...!!!");
					e.printStackTrace();
				}

				// adding book into ArrayList
				StaffTables.add(staffTable);
				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return StaffTables;

	}
}
