package com.review.two;

/**
 * 垃圾回收机制的简单实例：gc的不确定性，与finalize的强制性调用
 * @author hechen
 * @version 1.2
 */

public class GCTest {
	
	public static GCTest tf=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<4;i++){
			new GCTest();
			System.out.println("新建一个无引用的对象！");
//			System.gc();
			Runtime.getRuntime().gc();
			Runtime.getRuntime().runFinalization();
			GCTest.tf.info();
		}
	}
	
	public void info(){
		System.out.println("这个对象还处于激活状态！\n");
	}
	
	public void finalize(){
		System.out.println("正在清理对象GCTest的资源！");
		tf=this;
		System.out.println("从去活状态进入激活状态！");
	}

}
