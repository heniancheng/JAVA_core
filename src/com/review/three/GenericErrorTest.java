package com.review.three;

/**
 * 不适用范弄的情况：静态修改时
 * @author hechen
 * @version 1.3
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericErrorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("一些不能使用范型 的情况");
		
		Integer[] ia=new Integer[3];
		Number[] na=ia;
//下面语句运行时错误
//		na[0]=0.5;   
		na[1]=1;
		List<Integer> iList=new ArrayList<Integer>();
//下面语句编译时错误
//Integer是Number的子类，但范型后List<Integer>不是List<Number>的子类
//		List<Number> nList=iList;
//		nList.add(0.5);
	}

}

class R<T>{
	
/*不允许静态变量使用范型*/
//	static T info;
	
/*静态块中不允许使用范型*/
//	static{
//		T info;
//	}
	
/*静态方法不允许使用范型*/
//	public static void info(T msg){
//		System.out.println(msg);
//	}
	
/* instanceof()方法中不允许使用范型*/
//	public void test(){
//		Collection cl=new ArrayList<String>();
//		if(cl instanceof List<String>){
//			
//		}
//	}
}
