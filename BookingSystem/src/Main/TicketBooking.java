package Main;

import java.sql.*;
import java.util.Scanner;

import jdbcdemo.AddAllCSVtoDB;
import jdbcdemo.GetMoviesInfo;
import jdbcdemo.BookTicket;

public class TicketBooking {

	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		CreateAllRequiredTablesfromCSV.createTables();
		AddAllCSVtoDB.addAllCSVtoDB();
		
				
		System.out.println("Enter your username: ");
		Scanner scanner = new Scanner(System.in);
		String username = scanner.nextLine();
		System.out.println("Your username is " + username);
		System.out.println("Enter your mobile number");
		int mobile_number = scanner.nextInt();
		System.out.println("Your mobile number is " + mobile_number);
		
		int option;
		
		System.out.println("Enter one of the following options to execute corresponding instruction");
		System.out.println("1 Get Information of all movies");
		System.out.println("2 Book a ticket");
		
		while(scanner.hasNextLine()) {
            option=scanner.nextInt();
//			System.out.println(option);
			if(option==1) {
				System.out.println("Movies available now: " );
				GetMoviesInfo.AllMovies();	
				System.out.println("");
				System.out.println("Enter one of the following options to execute corresponding instruction");
				System.out.println("1 Get Information of all movies");
				System.out.println("2 Book a ticket");
			}
			else if(option == 2) {
				
				System.out.println("Select options that follow to book your ticket " );
				System.out.println("");
				System.out.println("Enter the movie name");
				GetMoviesInfo.MovieNames();
				
				String movie = scanner.nextLine();
				
				
				
				BookTicket.ReserveTicket(mobile_number,0,0,0,0);
				
				System.out.println("");
				System.out.println("Enter one of the following options to execute corresponding instruction");
				System.out.println("1 Get Information of all movies");
				System.out.println("2 Book a ticket");
				
				
			}
			else {
				System.out.println("Please provide the right option");
			}
		}
		
		scanner.close();
		
		
	}
}
