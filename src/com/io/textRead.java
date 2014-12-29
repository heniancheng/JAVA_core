package com.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class textRead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TextRead();
			TextRead2();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void TextRead() throws IOException{
		BufferedReader in=new BufferedReader(new FileReader("./file/file3.dat"));
		String line;
		try {
			line=in.readLine();
			while(line!=null){
				System.out.println(line);
				line=in.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			in.close();
		}	
	}
	
	public static void TextRead2() throws IOException{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		String line;
		try {
			line=in.readLine();
			while(line!=null){
				System.out.println(line);
				line=in.readLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			in.close();
		}
	}

}
