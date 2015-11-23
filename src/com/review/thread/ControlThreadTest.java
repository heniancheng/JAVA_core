package com.review.thread;

import java.util.Date;

public class ControlThreadTest {
	
	public static void joinMethod(){
		new JoinTest("joinOne").start();
		for(int i=0;i<100;i++){
			if(i==20){
				JoinTest jt=new JoinTest("joinTwo");
				jt.start();
				try {
					jt.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("no join");
		}	
	}
	
	public static void DeamonMethod(){
		JoinTest jt=new JoinTest("joinOne");
		jt.setDaemon(true);
		jt.start();
	}
	
	public static void SleepMethod(){
		for(int i=0;i<20;i++){
			System.out.println(new Date());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void YieldMethod(){
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ControlThreadTest.joinMethod();
//		ControlThreadTest.DeamonMethod();
		ControlThreadTest.SleepMethod();
		System.out.println("main");
	}

}

class JoinTest extends Thread{
	
	public JoinTest(String name){
		super(name);
	}
	public void run(){
		for(int i=0;i<100;i++){
			System.out.println(this.getName()+" "+i);
		}
	}
}

class YieldTest extends Thread implements Runnable{

	public YieldTest(String name){
		super(name);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println(this.getName()+" "+i);
			if(i==20){
				Thread.yield();
			}
		}
	}
	
}