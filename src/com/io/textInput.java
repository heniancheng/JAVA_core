package com.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class textInput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WriteText();
		test();
	}
	
	public static void WriteText(){
		try {
			PrintWriter out=new PrintWriter(new FileWriter("./file/file2.dat"));
			PrintWriter out2=new PrintWriter(new FileOutputStream("./file/file3.dat"));
			out.println("this is a string to be written the file2.dat");
			out.print("this is a string that contatin some special charachter \n\t to be written the file2.dat");
			out2.println("this is a string to be written the file3.dat");
			out2.print("this is a string that contatin some special charachter \n\t to be written the file3.dat");
			out.close();
			out2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void test(){
		String name="Harry Hacker";
		double salary=75000;
		PrintWriter out;
		try {
			out = new PrintWriter(new File("./file/file4.dat"));
			out.print(name);
			out.print(" ");
			out.println(salary);
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
