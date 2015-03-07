package sql;

/**
 * four method:insert,update,delete,query
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class sqlDML {
	private String driver;
	private String url;
	private String user;
	private String psw;
	private Connection conn;
	private Statement state;
	
	public void initParam(String paramFile) throws Exception{
		Properties props=new Properties();
		props.load(new FileInputStream(paramFile));
		driver=props.getProperty("driver");
		url=props.getProperty("url");
		user=props.getProperty("user");
		psw=props.getProperty("psw");
	}
	
	public void DMLData(String sql) throws Exception{
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, psw);
			state=conn.createStatement();
			state.executeUpdate(sql);
		}
		finally{
			if(state!=null){
				state.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public void ResultData(String sql) throws Exception{
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, psw);
			state=conn.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(4)+"\t"+rs.getDate(6));
			}
		}
		finally{
			if(state!=null){
				state.close();
			}
			if(conn!=null){
				conn.close();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String insert="insert into user(name,password,age,sex,birthday)"+"values('李华','bbb',20,'女','2003-03-11');";
		String update="update user set name='小花',password='ccc',age=18,birthday='2005-11-12' where id=3;";
		String delete="delete from user  where id=4;";
		String query="select id,name,password,age,sex,birthday from user;";
		sqlDML ins=new sqlDML();
		ins.initParam("./properties/mysql.ini");
		Scanner in=new Scanner(System.in);
		int options=in.nextInt();
		switch(options){
		case 1:
			ins.DMLData(insert);break;
		case 2:
			ins.DMLData(update);break;
		case 3:
			ins.DMLData(delete);break;
		case 4:
			ins.ResultData(query);
			break;
		default:break;
		}
	}

}
