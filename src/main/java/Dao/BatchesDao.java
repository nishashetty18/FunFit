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



public class BatchesDao {
	private String jdbcUrl="jdbc:mysql://localhost:3306/funfitmodel?useSSL=false";
	private String jdbcUsername="root";
	private String jdbcPassword="32660@Ua32660@Ua";
	private String jdbcDriver="com.mysql.cj.jdbc.Driver";
	
	private static final String insert_batches="Insert into batches(name, time, instructor) values (?,?,?);";
	private static final String select_batches_by_id="select id, name, time, instructor from batches where id=?";
	private static final String select_batches="Select*from batches";
	private static final String delete_batches="delete from batches where id=?;";
	private static final String update_batches_by_id="update batches set name=?, time=?,instructor=? where id=?";
	
	
	public BatchesDao() {
		
		
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
	public void AddParticipants2(Batches bch)throws SQLException{
		System.out.println(insert_batches);
		try(Connection connection=getConnection();
				PreparedStatement prepstmt=connection.prepareStatement(insert_batches);){
			prepstmt.setString(1, bch.getName());
			prepstmt.setString(2, bch.getTime());
			prepstmt.setString(3, bch.getInstructor());
		
			System.out.println(prepstmt);
			prepstmt.executeUpdate();
		}catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	//select participants by id
	public Batches searchParticipantsbyId2(int id) {
		Batches bch=null;
		
		try(Connection connection=getConnection();
			PreparedStatement prepstmt=connection.prepareStatement(select_batches_by_id);){
			prepstmt.setInt(1,id);
			ResultSet rs=prepstmt.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				String time=rs.getString("time");
				String instructor=rs.getString("instructor");
				
				bch=new Batches(id, name, time, instructor);	
			}
		}catch(SQLException e) {
				System.out.println(e);
		}return bch;
				
				
			
			}
	//select all participants
	public  List<Batches> viewAll2()throws Exception{
		List<Batches> bch=new ArrayList<>();
	
		try(Connection connection=getConnection();
				PreparedStatement prepstmt=connection.prepareStatement(select_batches);){
				ResultSet rs=prepstmt.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
			String name=rs.getString("name");
			String time=rs.getString("time");
			String instructor=rs.getString("instructor");
			
			bch.add(new Batches(id, name,time, instructor));	
		}
	}catch(SQLException e) {
			System.out.println(e);
	}return bch;
			
		
	}
	
	//update participants by id
	public boolean updateParticipants2(Batches bch) throws SQLException {
	
		boolean rowUpdated = false;
		try{
			Connection connection=getConnection();
				PreparedStatement prepstmt=connection.prepareStatement(update_batches_by_id);
			
		prepstmt.setString(1, bch.getName());
		prepstmt.setString(2, bch.getTime());
		prepstmt.setString(3, bch.getInstructor());
		
		
		prepstmt.setInt(4, bch.getId());
System.out.println("updated dao");
		rowUpdated=prepstmt.executeUpdate() > 0;
		System.out.println(rowUpdated);
		
		}catch(Exception e) {
			System.out.println(e);
		}
		return rowUpdated;
	}
	
	//delete participants
	
	public boolean deleteParticipants2(int id) throws SQLException {
		boolean rowDeleted;
		try(Connection connection=getConnection();
				PreparedStatement prepstmt=connection.prepareStatement(delete_batches);){
			prepstmt.setInt(1, id);
			rowDeleted=prepstmt.executeUpdate()>0;
			
		}return rowDeleted;
		
	}
	
	
}
