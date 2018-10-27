package ObjectPackage;

public class ShowsTable {
	private int show_id;
	private int screen_id;
	private String timing;
	private String date;
	private String movie_name;
	
	public ShowsTable(int show_id, int screen_id, String timing, String date, String movie_name) {
		super();
		this.show_id = show_id;
		this.screen_id = screen_id;
		this.timing = timing;
		this.date = date;
		this.movie_name = movie_name;
	}

    

	public int getShow_id() {
		return show_id;
	}



	public void setShow_id(int show_id) {
		this.show_id = show_id;
	}



	public int getScreen_id() {
		return screen_id;
	}



	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}



	public String getTiming() {
		return timing;
	}



	public void setTiming(String timing) {
		this.timing = timing;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public String getMovie_name() {
		return movie_name;
	}



	public void setMovie_name(String movie_name) {
		this.movie_name = movie_name;
	}



	@Override
	public String toString() {
		return "Shows Details [show id=" + show_id + ", screen_id=" + screen_id + ", timing=" + timing + ", date=" + date + ", movie_name=" + movie_name + "]";
	}

}
