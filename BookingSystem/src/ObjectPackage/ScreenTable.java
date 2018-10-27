package ObjectPackage;

public class ScreenTable {
	
	private int screen_id;
	private int rows;
	private int seats;
	
	public ScreenTable(int screen_id, int rows, int seats) {
		super();
		this.screen_id = screen_id;
		this.rows = rows;
		this.seats = seats;
	}
	

	public int getscreen_id() {
		return screen_id;
	}


	public void setscreen_id(int screen_id) {
		this.screen_id = screen_id;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}

	
	@Override
	public String toString() {
		return "Screen Details [screen_id=" + screen_id + ", rows=" + rows + ", seats=" + seats + "]";
	}

}
