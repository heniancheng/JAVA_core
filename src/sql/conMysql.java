package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conMysql {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test","root","admin");
		
//		Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
//		Connection conn=DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:1433;DatabaseName=test","root","admin");
//		
//		Class.forName("oracle.jdbc.driver.OracleDriver");
//		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:test","root","admin");
		
		Statement state=conn.createStatement();
		ResultSet rs=state.executeQuery("select * from student");
		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
		}
		if(rs!=null){
			rs.close();
		}
		if(state!=null){
			state.close();
		}
		if(conn!=null){
			conn.close();
		}
		
	}

}
