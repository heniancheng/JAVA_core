package com.io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

/*
 * 编码与解码的操作
 */

public class code {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		//先进行一次编码，再进行解码
		code CODE=new code();
		byte[] bytes=CODE.encode("hechen", Charset.forName("ISO-8859-1"));
		String myName=CODE.decode(bytes, Charset.forName("ISO-8859-1"));
		System.out.println(myName);
		
		//ISO-8891-1的别名
		System.out.println("ISO-8891-1的别名如下");
		Charset cset=Charset.forName("ISO-8859-1");
		Set<String> aliases=cset.aliases();
		for(String alias:aliases){
			System.out.println(alias);
		}
		
		//系统字符集
		System.out.println("字符集如下：");
		Map<String,Charset> charsets=Charset.availableCharsets();
		for(String name:charsets.keySet()){
			System.out.println(name);
		}
		
	}
	
	public byte[] encode(String str,Charset rule){
		
		ByteBuffer buffer=rule.encode(str);
		byte[] bytes=buffer.array();
		return bytes;
		
	}
	
	public String decode(byte[] bytes,Charset rule){
		ByteBuffer bbuf=ByteBuffer.wrap(bytes);
		CharBuffer cbuf=rule.decode(bbuf);
		String str=cbuf.toString();
		return str;
	}

}
