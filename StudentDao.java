import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class StudentDao {

	protected static Component frame;
        public static int save(String studentname,String password,String email,String studentcontact, int fine){
		int status=0;
		try{
                        
			Connection con = DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into student(studentname,password,email,studentcontact,fine) values(?,?,?,?,?)");
			ps.setString(1,studentname);
			ps.setString(2,password);
			ps.setString(3,email);
			ps.setString(4,studentcontact);
                        ps.setInt(5, fine);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static boolean checkstud(int studentid) {
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student where studentid=?");
			ps.setInt(1,studentid);
		    ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static int finer(int studentid, int fi) {
		int status=0;
		//boolean fine;
		
		try {
			Connection con=DB.getConnection();
			//PreparedStatement ps=con.prepareStatement("select fine from student where studentid=?");
			//ps.setInt(1,studentid);
			//ResultSet rs=ps.executeQuery();
			/*
                        if(fi>0) {
				fine = true;
			}
			else {
				fine=false;
			}
			if(rs.next()){
				fine=rs.getBoolean("fine");
			} */
			
			//if(fine==true){
			PreparedStatement ps2=con.prepareStatement("update student set fine=? where studentid=?");
			ps2.setInt(1,fi);
			ps2.setInt(2,studentid);
			
			status=ps2.executeUpdate();
			//}
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
			
		}	
        public static int delete(int id){
		int status=0;
		try{
			Connection con = DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from student where studentid=?");
			ps.setInt(1,id);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	     }

	public static boolean validate(int studentid, String password) {
		boolean status=false;
		try {
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from student where studentid=? and password=?");
			ps.setInt(1,studentid);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
		}
		}

