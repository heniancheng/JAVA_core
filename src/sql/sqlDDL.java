package sql;

/**
 * the three method:create,drop,alter
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class sqlDDL {
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
	
	public void DDLTable(String sql) throws Exception{
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

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		sqlDDL ddl=new sqlDDL();
		ddl.initParam("./properties/mysql.ini");
		String create="create table jdbc_test"+"(jdbc_id int primary key,"+"jdbc_name varchar(20),"+"jdbc_desc text);";
		String drop="drop table jdbc_test;";
		String alter="alter table jdbc_test add jdbc_add varchar(20);";
		Scanner in=new Scanner(System.in);
		int options=in.nextInt();
		switch(options){
		case 1:
			ddl.DDLTable(create);
			System.out.println("创建表格成功");
			break;
		case 2:
			ddl.DDLTable(drop);
			System.out.println("删除表格成功");
			break;
		case 3:
			ddl.DDLTable(alter);
			System.out.println("修改表格成功");
			break;
		default:
			break;
		}
		
	}

}
