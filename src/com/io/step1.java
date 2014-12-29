package com.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 如何使用字节流，主要是四个抽象类:InputStream,OutputStream,Reader,Writer.
 * 前两者以一个字节为单位，后两者以两个字节为单位
 * 重要的实现类有：FileInputStream,FileOutputStream,DataInputStream,DataOutputStream,PrintStream.
 * FileReader(->InputStreamReader),FileWriter(->OutputStreamWriter),PrintWriter.除了后面的一个外
 * 前面的四个实现了字符码（特殊编码的字节流与Unicode字符编码）的过渡
 */

public class step1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="abc\ndef";
		step1 strIO=new step1();
		try {
			strIO.WriteString(str);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("resource")
	public void WriteString(String str) throws IOException{
		try {
			FileOutputStream out_i=new FileOutputStream("./file/file1.dat");
			out_i.write(str.getBytes());
			out_i.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
	}

}
