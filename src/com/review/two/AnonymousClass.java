package com.review.two;

/**
 * 内部类的使用：一般用于一个类只使用一次
 * @author hechen
 * @version 1.1
 */

public class AnonymousClass {
	
	public void test(Product p){
		System.out.println(p.getName()+" : "+p.getPrice());
	}
	
	public void test(Device d){
		System.out.println(d.getName()+" : "+d.getPrice());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnonymousClass anony=new AnonymousClass();
		anony.test(new Product(){
			public double getPrice(){
				return 444.00;
			}
			public String getName(){
				return "AGP";
			}
		});
		anony.test(new Device("AGP"){

			@Override
			public double getPrice() {
				// TODO Auto-generated method stub
				return 67.8;
			}
			
		});
		anony.test(new Device(){

			@Override
			public double getPrice() {
				// TODO Auto-generated method stub
				return 30.2;
			}
			public String getName(){
				return "keyboard";
			}
			
		});
	}

}

interface Product{
	public double getPrice();
	public String getName();
}

abstract class Device{
	private String name;
	public abstract double getPrice();
	public String getName(){return name;}
	public Device(){}
	public Device(String name){
		this.name=name;
	}
}
