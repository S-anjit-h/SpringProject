

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException ,IOException{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sanjith1", "root", "1234");
		return con;
	}
static int save(Bean b) throws SQLException, ClassNotFoundException, IOException {
		
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into table1(Name,Phone,Email,Password) values (?,?,?,?)");
		ps.setString(1,b.getName()); 
		ps.setString(2,b.getPhone());
		ps.setString(3,b.getEmail());
		ps.setString(4,b.getPass());
		int a=ps.executeUpdate();
	return a;
	}

}
