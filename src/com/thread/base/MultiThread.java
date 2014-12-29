package com.thread.base;

public class MultiThread {
	
	public static void main(String[] args){
		 
		Target target=new Target();
		Thread thread1=new Thread(target,"thread1");
		Thread thread2=new Thread(target,"thread2");
		thread1.start();
		thread2.start();
	}

}

class Target implements Runnable{

	private int i;
	
	Target(){
		i=1;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (;i<100;i++){
			System.out.println(Thread.currentThread().getName()+ " i= "+i);
		}
	}
	
}
