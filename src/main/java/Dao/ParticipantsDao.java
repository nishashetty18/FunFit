package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Batches;
import Models.Participants;
import Models.Partsandbatch;



public class ParticipantsDao {
	private String jdbcUrl="jdbc:mysql://localhost:3306/funfitmodel?useSSL=false";
	private String jdbcUsername="root";
	private String jdbcPassword=;
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";
	
	private static final String insert_participants="Insert into Participants(name, gender, location, phone,batch_id) values (?,?,?,?,?);";
	private static final String select_participants_by_id="select id, name, gender, location, phone, batch_id from Participants where id=?";
	private static final String select_participants_and_batch="SELECT p.id, p.name, p.gender,p.location,p.phone,b.name as batchname FROM Participants p JOIN batches b ON p.batch_id = b.id;";
	private static final String select_participants="select*from Participants";
	private static final String delete_participants="delete from Participants where id=?;";
	private static final String update_participants_by_id="update Participants set name=?, gender=?, location=?, phone=? ,batch_id=? where id=?";
	
	
	public ParticipantsDao() {
		
		
	}

		protected Connection getConnection() {
			Connection connection=null;
			try {
				Class.forName(jdbcDriver);
				connection=DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword);
			}catch(SQLException e) {
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return connection;
		}
		
		
		//insert participants
		public void AddParticipants(Participants part)throws SQLException{
			System.out.println(insert_participants);
			try(Connection connection=getConnection();
					PreparedStatement prepstmt=connection.prepareStatement(insert_participants);){
				prepstmt.setString(1, part.getName());
				prepstmt.setString(2, part.getGender());
				prepstmt.setString(3, part.getLocation());
				prepstmt.setString(4, part.getPhone());
				prepstmt.setInt(5, part.getBatch_id());
				System.out.println(prepstmt);
				prepstmt.executeUpdate();
			}catch (SQLException e) {
				System.out.println(e);
			}
		}
		
		//select participants by id
		public Participants  searchParticipantsbyId(int id) {
			Participants part=null;
			
			try(Connection connection=getConnection();
				PreparedStatement prepstmt=connection.prepareStatement(select_participants_by_id);){
				prepstmt.setInt(1,id);
				ResultSet rs=prepstmt.executeQuery();
				while(rs.next()) {
					String name=rs.getString("name");
					String gender=rs.getString("gender");
					String location=rs.getString("location");
					String phone=rs.getString("phone");
					int batch_id=rs.getInt("batch_id");
					part=new Participants(id, name, gender, location, phone, batch_id);	
				}
			}catch(SQLException e) {
					System.out.println(e);
			}return part;
					
					
				
				}
		//select all participants
		public  List<Participants> viewAll()throws Exception{
			List<Participants> part=new ArrayList<>();
		
			try(Connection connection=getConnection();
					PreparedStatement prepstmt=connection.prepareStatement(select_participants);){
					ResultSet rs=prepstmt.executeQuery();
				while(rs.next()) {
					int id=rs.getInt("id");
				String name=rs.getString("name");
				String gender=rs.getString("gender");
				String location=rs.getString("location");
				String phone=rs.getString("phone");
				int batch_id=rs.getInt("batch_id");
				part.add(new Participants(id, name,gender,location, phone, batch_id));	
			}
		}catch(SQLException e) {
				System.out.println(e);
		}return part;
				
			
		}
		
		//update participants by id
		public boolean updateParticipants(Participants part) throws SQLException {
		
			boolean rowUpdated = false;
			try{
				Connection connection=getConnection();
					PreparedStatement prepstmt=connection.prepareStatement(update_participants_by_id);
				
			prepstmt.setString(1, part.getName());
			prepstmt.setString(2, part.getGender());
			prepstmt.setString(3, part.getLocation());
			prepstmt.setString(4, part.getPhone());
			prepstmt.setInt(5, part.getBatch_id());
			prepstmt.setInt(6, part.getId());
			System.out.println("updated dao");
			rowUpdated=prepstmt.executeUpdate() > 0;
			System.out.println(rowUpdated);
			
			}catch(Exception e) {
				System.out.println(e);
			}
			return rowUpdated;
		}
		
		//delete participants
		
		public boolean deleteParticipants(int id) throws SQLException {
			boolean rowDeleted;
			try(Connection connection=getConnection();
					PreparedStatement prepstmt=connection.prepareStatement(delete_participants);){
				prepstmt.setInt(1, id);
				rowDeleted=prepstmt.executeUpdate()>0;
				
			}return rowDeleted;
			
		}
		
}



