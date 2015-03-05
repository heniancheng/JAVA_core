package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class myClient {
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket s=new Socket("127.0.0.1",10001);
		new Thread(new ClientThread(s)).start();
		PrintStream ps=new PrintStream(s.getOutputStream());
		String line=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while((line=br.readLine())!=null){
			ps.println(line);
		}
	}
}

class ClientThread implements Runnable{

	private Socket s;
	BufferedReader br=null;
	public ClientThread(Socket s) throws IOException {
		// TODO Auto-generated constructor stub
		this.s=s;
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			String content=null;
			while((content=br.readLine())!=null){
				System.out.println(content);
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}	
	}	
}
