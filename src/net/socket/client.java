package net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket socket=new Socket("127.0.0.1",10001);
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line = br.readLine();
		System.out.println(line);
		br.close();
		socket.close();

	}

}
