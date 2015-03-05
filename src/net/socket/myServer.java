package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class myServer {

	public static ArrayList<Socket> socketlist=new ArrayList<Socket>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss=new ServerSocket(10001);
		while(true){
			Socket s=ss.accept();
			socketlist.add(s);
			new Thread(new ServerThread(s)).start();
		}
	}
}

class ServerThread implements Runnable
{

	Socket s=null;
	BufferedReader br=null;
	public ServerThread(Socket s) throws IOException {
		// TODO Auto-generated constructor stub
		this.s=s;
		br=new BufferedReader(new InputStreamReader(s.getInputStream()));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String content=null;
		while((content=readFromClient())!=null){
			for(Socket s:myServer.socketlist){
				PrintStream ps=null;
				try {
					ps = new PrintStream(s.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps.println(content);
			}
		}
	}
	
	private String readFromClient(){
		try{
			return br.readLine();
		}catch(IOException e)
		{
			myServer.socketlist.remove(s);
		}
		return null;
	}
	
}
