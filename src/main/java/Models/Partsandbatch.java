package Models;

public class Partsandbatch {
	private int part_id;
	private String part_name;
	private String part_gender;
	private String part_location;
	private String part_phone;
	private int batch_id;
	private String batch_name;
	private String batch_time;
	private String batch_instructor;
	public int getPart_id() {
		return part_id;
	}
	public void setPart_id(int part_id) {
		this.part_id = part_id;
	}
	public String getPart_name() {
		return part_name;
	}
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	public String getPart_gender() {
		return part_gender;
	}
	public void setPart_gender(String part_gender) {
		this.part_gender = part_gender;
	}
	public String getPart_location() {
		return part_location;
	}
	public void setPart_location(String part_location) {
		this.part_location = part_location;
	}
	public String getPart_phone() {
		return part_phone;
	}
	public void setPart_phone(String part_phone) {
		this.part_phone = part_phone;
	}
	public int getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(int batch_id) {
		this.batch_id = batch_id;
	}
	public String getBatch_name() {
		return batch_name;
	}
	public void setBatch_name(String batch_name) {
		this.batch_name = batch_name;
	}
	public String getBatch_time() {
		return batch_time;
	}
	public void setBatch_time(String batch_time) {
		this.batch_time = batch_time;
	}
	public String getBatch_instructor() {
		return batch_instructor;
	}
	public void setBatch_instructor(String batch_instructor) {
		this.batch_instructor = batch_instructor;
	}
	
	public Partsandbatch() {
		
	}
	public Partsandbatch(int part_id, String part_name, String part_gender, String part_location, String part_phone,
			int batch_id, String batch_name, String batch_time, String batch_instructor) {
		super();
		this.part_id = part_id;
		this.part_name = part_name;
		this.part_gender = part_gender;
		this.part_location = part_location;
		this.part_phone = part_phone;
		this.batch_id = batch_id;
		this.batch_name = batch_name;
		this.batch_time = batch_time;
		this.batch_instructor = batch_instructor;
	}
	
	

}
