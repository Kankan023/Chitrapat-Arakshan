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
import ObjectPackage.MovieTable;

public class AddMovieCSVtoDatabase {

	public static void addMovieCSVtoDatabase(String csvfileloc) {
		LinkedList<MovieTable> movieTables = readMovieEntriesFromCSV(csvfileloc);
		for (MovieTable mt : movieTables) {
			System.out.println(mt);
		}
	}

	private static MovieTable createMovieEntry(String[] metadata) {
		int movie_id = Integer.parseInt(metadata[0]);
		String movie_name = metadata[1];
		String language = metadata[2];
		int duration = Integer.parseInt(metadata[3]);
		float rating = Float.parseFloat(metadata[4]);
		String movie_genre = metadata[5];
		String starcast = metadata[6];
		String director = metadata[7];

		return new MovieTable(movie_id, movie_name, language, duration, rating, movie_genre, starcast, director);
	}

	private static LinkedList<MovieTable> readMovieEntriesFromCSV(String fileName) {
		LinkedList<MovieTable> MovieTables = new LinkedList<>();
		Path pathToFile = Paths.get(fileName);

		try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.ISO_8859_1)) {
			// read the first line from the text file
			String line = br.readLine();
			// loop until all lines are read
			while (line != null) {
				// use string.split to load a string array with the values from // each line of
				// // the file, using a comma as the delimiter
				String[] attributes = line.split(",");
				MovieTable movieTable = createMovieEntry(attributes);
				
				// Adding Entries into DB:
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false",
							"root", "1234567890");

					// the mysql insert statement
					String query = " insert into MOVIE (movie_id, movie_name, language, duration, rating, movie_genre, starcast, director)"
							+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
					PreparedStatement preparedStmt = con.prepareStatement(query);
					preparedStmt.setInt(1, Integer.parseInt(attributes[0]));
					preparedStmt.setString(2, attributes[1]);
					preparedStmt.setString(3, attributes[2]);
					preparedStmt.setInt(4, Integer.parseInt(attributes[3]));
					preparedStmt.setFloat(5, Float.parseFloat(attributes[4]));
					preparedStmt.setString(6, attributes[5]);
					preparedStmt.setString(7, attributes[6]);
					preparedStmt.setString(8, attributes[7]);

					// execute the prepared statement
					preparedStmt.execute();
					con.close();
				} catch (Exception e) {
					System.out.println(" DB Query Error...!!!");
					e.printStackTrace();
				}
				
				// adding book into ArrayList
				MovieTables.add(movieTable);
				// read next line before looping
				// if end of file reached, line would be null
				line = br.readLine();
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return MovieTables;
	}
}
