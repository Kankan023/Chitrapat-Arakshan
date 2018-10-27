package ObjectPackage;

public class StaffTable {
	private String staff_name;
	private int staff_id;
	private int age;
	private String mobile;

	public StaffTable(String staff_name, int staff_id, int age, String mobile) {
		this.staff_name = staff_name;
		this.staff_id = staff_id;
		this.age = age;
		this.mobile = mobile;
	}

	public String getstaff_name() {
		return staff_name;
	}

	public void setstaff_name(String staff_name) {
		this.staff_name = staff_name;
	}

	public int getstaff_id() {
		return staff_id;
	}

	public void setstaff_id(int staff_id) {
		this.staff_id = staff_id;
	}

	public int getage() {
		return age;
	}

	public void setage(int age) {
		this.age = age;
	}

	public String getmobile() {
		return mobile;
	}

	public void setmobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString() {
		return "Staff Details [staff_name=" + staff_name + ", staff_id=" + staff_id + ", age=" + age + ", mobile=" + mobile + "]";
	}
}
