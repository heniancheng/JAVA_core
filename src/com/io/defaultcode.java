package com.io;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 这里采用默认的Unicode编码与字节流联系起来
 */

public class defaultcode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		defaultcode CODE=new defaultcode();
		char[] chars=new char[6];
		char[] chars2=new char[3];
		try {
			chars=CODE.getChar1();
			chars2=CODE.getChar2();
			System.out.println(Arrays.toString(chars));
			System.out.println(Arrays.toString(chars2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public char[] getChar1() throws IOException{
		char[] chars=new char[6];
		FileReader infile=new FileReader("./file/file1.dat");
		infile.read(chars);
		infile.close();
		return chars;
	}
	
	public char[] getChar2() throws IOException{
		InputStreamReader in=new InputStreamReader(System.in);
		char[] chars=new char[3];
		in.read(chars);
		in.close();
		return chars;
	}

}
