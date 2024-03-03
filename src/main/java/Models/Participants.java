package Models;

public class Participants {
//	CREATE TABLE Participants (
//		    id INT AUTO_INCREMENT PRIMARY KEY,
//		    name VARCHAR(50),
//		    gender VARCHAR(50),
//		    location varchar(50),
//		    phone varchar(100),
//		    batch_id INT,
//		    FOREIGN KEY (batch_id) REFERENCES batches(id)
//		);
	private int id;
	private String name;
	private String gender;
	private String location;
	private String phone;
	private int batch_id;
	public Participants(int id, String name, String gender, String location, String phone, int batch_id) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.location = location;
		this.phone = phone;
		this.batch_id = batch_id;
	}
	public Participants(String name, String gender, String location, String phone, int batch_id) {
		super();
		this.name = name;
		this.gender = gender;
		this.location = location;
		this.phone = phone;
		this.batch_id = batch_id;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	
	
	
}