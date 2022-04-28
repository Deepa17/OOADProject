import java.sql.*;

//SINGLETON OBJECT FOR GLOBAL ACCESS
class DB
{
	private static Connection conn;
	
	private DB(){}
	
	public static Connection getConnection()
	{
                conn = null;
		try
		{
			if(conn==null)
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost/new","root","dee!!828");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return conn;
	}
}