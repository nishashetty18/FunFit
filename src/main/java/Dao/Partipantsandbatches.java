package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Participants;
import Models.Partsandbatch;

public class Partipantsandbatches {
	public class ParticipantsDao {
		private String jdbcUrl="jdbc:mysql://localhost:3306/funfitmodel?useSSL=false";
		private String jdbcUsername="root";
		private String jdbcPassword="32660@Ua32660@Ua";
		private String jdbcDriver="com.mysql.cj.jdbc.Driver";
		
		private static final String Select_Part_Bch = "SELECT p.id, p.name, p.gender,p.location,p.phone,b.name as batchname FROM Participants p JOIN batches b ON p.batch_id = b.id;";

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
	
		public List<Partsandbatch> getUserAndRoleData() throws SQLException {
	        List<Partsandbatch> dataList = new ArrayList<>();
	        try(Connection connection=getConnection();
					PreparedStatement prepstmt=connection.prepareStatement(Select_Part_Bch );){
					ResultSet rs=prepstmt.executeQuery();
				while(rs.next()) {
			Partsandbatch data = new Partsandbatch();
            data.setPart_id(rs.getInt("part_id"));
            data.setPart_name(rs.getString("part_name"));
            data.setPart_gender(rs.getString("part_gender"));
            data.setPart_location(rs.getString("part_location"));
            data.setPart_phone(rs.getString("part_phone"));
            data.setBatch_name(rs.getString("batch_name"));
            data.setBatch_time(rs.getString("batch_time"));
            data.setBatch_instructor(rs.getString("batch_instructor"));
            
            
            dataList.add(data);
        }
		
}
			return dataList;
		}}}