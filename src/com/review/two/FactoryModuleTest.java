package com.review.two;

import java.util.Scanner;

/**
 * 一个简单的工厂模式实例：电脑，打印机组合
 * @author hechen
 * @version 1.1
 */

public class FactoryModuleTest {
	
	public Output getOutput(){
		return new Print();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FactoryModuleTest factory=new FactoryModuleTest();
		Print print= (Print) factory.getOutput();
		Computer com=new Computer(print);
		com.keyIn();
		com.print();
	}

}

class Computer{
	
	private Output output;
	public Computer(Output out){
		this.output=out;
	}
	public void keyIn(){
		Scanner in=new Scanner(System.in);
		String msg=in.nextLine();
		while(!msg.equals("exit")){
			output.getData(msg);
			msg=in.nextLine();
		}
	}
	public void print(){
		output.out();
	}
}

interface Output{
	
	public final int MAX_CHAR_LINE=3;

	public void out();

	public void getData(String msg);
	
}

class Print implements Output{

	private String[] printdata=new String[MAX_CHAR_LINE];
	private int dataNum=0;
	
	@Override
	public void out() {
		// TODO Auto-generated method stub
		while(dataNum>0){
			System.out.println(printdata[0]);
			System.arraycopy(printdata,1,printdata,0,--dataNum);
		}
	}

	@Override
	public void getData(String msg) {
		// TODO Auto-generated method stub
		if(dataNum>=MAX_CHAR_LINE){
			System.out.println("队列已满！");
		}else{
			printdata[dataNum++]=msg;
		}
	}
	
}

class BetterPrint implements Output{

	private String[] printdata=new String[MAX_CHAR_LINE*2];
	private int dataNum=0;
	
	@Override
	public void out() {
		// TODO Auto-generated method stub
		while(dataNum>0){
			System.out.println(printdata[0]);
			System.arraycopy(printdata,1,printdata,0,--dataNum);
		}
	}

	@Override
	public void getData(String msg) {
		// TODO Auto-generated method stub
		if(dataNum>=MAX_CHAR_LINE){
			System.out.println("队列已满！");
		}else{
			printdata[dataNum++]=msg;
		}
	}
}

