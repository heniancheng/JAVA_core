package com.review;

/**
 * 自动装箱拆箱测试类
 * @author hechen
 * @version 1.0
 */

public class AutoBoxingUnboxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer inObj=5;
		Object boolObj=true;
		int it=inObj;
		if(boolObj instanceof Boolean){
			Boolean b=(Boolean) boolObj;
			boolean bb=b;
			System.out.println(bb);
		}
	}

}
