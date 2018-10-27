package ObjectPackage;

public class MultiplexTable {
	private int screen_id;
	private int capacity;

	public int getScreen_id() {
		return screen_id;
	}

	public void setScreen_id(int screen_id) {
		this.screen_id = screen_id;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public MultiplexTable(int screen_id, int capacity) {
		super();
		this.screen_id = screen_id;
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Multilex Details [screen_id=" + screen_id + ", capacity=" + capacity + "]";
	}

}
