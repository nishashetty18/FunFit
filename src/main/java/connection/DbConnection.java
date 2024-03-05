package connection;


import java.sql.Connection;
import java.sql.DriverManager;


public class DbConnection {
	public static  Connection getConnection( )throws Exception
	{
		Connection conObj=null;
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conObj = DriverManager.getConnection("jdbc:mysql://localhost:3306/funfitmodel", "root", "32660@Ua32660@Ua");
		
	}
	catch (Exception e) 
	{
		conObj=null;
		System.out.println(e);
		
	}
	return conObj;
}
}


