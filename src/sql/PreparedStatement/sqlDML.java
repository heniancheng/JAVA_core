package sql.PreparedStatement;

/**
 * four method:insert,update,delete,query
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Scanner;

public class sqlDML {
	private String driver;
	private String url;
	private String user;
	private String psw;
	private Connection conn;
	private PreparedStatement state;
	private ResultSet rs;
	
	public void initParam(String paramFile) throws Exception{
		Properties props=new Properties();
		props.load(new FileInputStream(paramFile));
		driver=props.getProperty("driver");
		url=props.getProperty("url");
		user=props.getProperty("user");
		psw=props.getProperty("psw");
	}
	
	public void insertData(String sql) throws Exception{
		try{
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, psw);
			state=conn.prepareStatement(sql);
			state.setString(1, "小强");
			state.setString(2, "ddd");
			state.setInt(3, 19);
			state.setString(4, "男");
			String birth="2007-02-28";
			java.util.Date temp=new SimpleDateFormat("yyyy-MM-dd").parse(birth);
			java.sql.Date bir=new java.sql.Date(temp.getTime());
			state.setDate(5, bir);
			state.executeUpdate();
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
			state=conn.prepareStatement(sql);
			state.setString(1, "%"+"小"+"%");
			state.setString(2, "ddd");
			state.setString(3, "男");
			rs=state.executeQuery();
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getDate(6));
			}
		}
		finally{
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
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String insert="insert into user(name,password,age,sex,birthday)"+"values(?,?,?,?,?);";
		String update="update user set name='小花',password='ccc',age=18,birthday='2005-11-12' where id=3;";
		String delete="delete from user  where id=4;";
		String query="select id,name,password,age,sex,birthday from user where name like ? or password like ? or sex like ?;";
		sqlDML ins=new sqlDML();
		ins.initParam("./properties/mysql.ini");
		Scanner in=new Scanner(System.in);
		int options=in.nextInt();
		switch(options){
		case 1:
			ins.insertData(insert);break;
		case 2:
			ins.ResultData(query);
			break;
		default:break;
		}
	}

}
