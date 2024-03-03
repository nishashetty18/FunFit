package Models;

public class Batches {
//	CREATE TABLE batches (
//		    id INT AUTO_INCREMENT PRIMARY KEY,
//		    batch_name VARCHAR(50),
//		    time varchar(50),
//		    instructor varchar(50)
//		);
	private int id;
	private String name;
	private String time;
	private String instructor;
	public Batches(int id, String name, String time, String instructor) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.instructor = instructor;
	}
	public Batches(String name, String time, String instructor) {
		super();
		this.name = name;
		this.time = time;
		this.instructor = instructor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	
	
}
