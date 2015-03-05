package net.socket;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	
	public static void main(String[] arg) throws IOException{
		@SuppressWarnings("resource")
		ServerSocket ss=new ServerSocket(10001);
		while(true){
			System.out.println("等待客户端连接");
			Socket s=ss.accept();
			System.out.println("连接客户");
			PrintStream ps=new PrintStream(s.getOutputStream());
			ps.println("hello");
			ps.close();
			s.close();
		}
	}

}
