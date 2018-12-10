package jdbc_test;

import java.sql.*;

public class Learning_Rus {

	public static void main(String[] args) throws Exception {
		try {
			Class.forName ("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace(); // object e (exception) prints result of error if driver was not find
						
		}		
		
		
		String url = "jdbc:mysql://localhost:3306/books";
		String uname ="root";
        String passw = "root";
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		try {
		
		Connection conn = DriverManager.getConnection(url, uname, passw);
		//connecting driver with url, uname (for the specific user)
		// with the specific password (passw)
		
		
		Statement stat = conn.createStatement(); //create object that can do queries in MySQL,  
		//we will save all result of our queries in that object !!!
		ResultSet rs = stat.executeQuery("select title from books");
		
		while (rs.next()) {  //use operator next - it checks do we have any result in our query. It's boolean (true or false)
			//while it's true - print result
			System.out.println(rs.getString("title"));
					}
		stat.close();
		} catch (SQLException e) {
		 e.printStackTrace();
		}		
		
		
	}

}
