package jdbcdemo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class GetMoviesInfo {

	public static void AllMovies() {
           try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false",
							"root", "1234567890");

					// the mysql insert statement
					
					Statement myState = con.createStatement();
					String query = "SELECT * FROM MOVIE";
					ResultSet myRes = myState.executeQuery(query);
					
					
					
					while(myRes.next()){
						System.out.println("");
						System.out.println(myRes.getString("movie_name")+ ", Language: "+ myRes.getString("language") + ", Duration: "+ myRes.getString("duration") +" mins" + ", Genre: "+myRes.getString("movie_genre")+ ", Cast: "+myRes.getString("starcast")+ ", Rating: "+myRes.getString("rating") );
						System.out.println("");
					}
					
					con.close();
				} catch (Exception e) {
					System.out.println(" DB Query Error...!!!");
					e.printStackTrace();
				}
						

		
	}

	public static void MovieNames() {
        try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviefun?useSSL=false",
							"root", "1234567890");

					// the mysql insert statement
					
					Statement myState = con.createStatement();
					String query = "SELECT * FROM MOVIE";
					ResultSet myRes = myState.executeQuery(query);
					
					
					
					while(myRes.next()){			
						System.out.println(myRes.getString("movie_name") );
					}
					
					con.close();
				} catch (Exception e) {
					System.out.println(" DB Query Error...!!!");
					e.printStackTrace();
				}
						
	}
}
