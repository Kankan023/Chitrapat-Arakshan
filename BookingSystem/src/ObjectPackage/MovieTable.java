package ObjectPackage;

public class MovieTable {
	private int movie_id;
	private String movie_name;
	private String language;
	private int duration;
	private float rating;
	private String movie_genre;
	private String starcast;
	private String director;
	
	public MovieTable(int movie_id, String movie_name, String language, int duration, float rating, String movie_genre,
			String starcast, String director) {
		super();
		this.movie_id = movie_id;
		this.movie_name = movie_name;
		this.language = language;
		this.duration = duration;
		this.rating = rating;
		this.movie_genre = movie_genre;
		this.starcast = starcast;
		this.director = director;
	}

	
	public String getmovie_name() {
		return movie_name;
	}

	public void setmovie_name(String movie_name) {
		this.movie_name = movie_name;
	}

	public int getMovie_id() {
		return movie_id;
	}


	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}


	public String getLanguage() {
		return language;
	}


	public void setLanguage(String language) {
		this.language = language;
	}


	public String getStarcast() {
		return starcast;
	}


	public void setStarcast(String starcast) {
		this.starcast = starcast;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public int getduration() {
		return duration;
	}

	public void setduration(int duration) {
		this.duration = duration;
	}

	public float getrating() {
		return rating;
	}

	public void setrating(float rating) {
		this.rating = rating;
	}
	
	public String getmovie_genre() {
		return movie_genre;
	}

	public void setmovie_genre(String movie_genre) {
		this.movie_genre = movie_genre;
	}

	@Override
	public String toString() {
		return "Movie Details [movie_id=" + movie_id + ", movie_name=" + movie_name + ", language=" + language +", duration=" + duration + ", rating=" + rating + ", movie_genre=" + movie_genre + ", starcast=" + starcast + ", director=" + director + "]";
	}

}
