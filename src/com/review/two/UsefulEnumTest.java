package com.review.two;

/**
 * 枚举类实现接口，以及方法，属性，构造方法的使用
 * @author hechen
 * @version 1.1
 */

public class UsefulEnumTest {
	
	public void judge(EnumSeason season){
		switch(season){
		case Spring:
			System.out.println("spring is green.");
			break;
		case Summer:
			System.out.println("summer is hot.");
			break;
		case Fall:
			System.out.println("fall is leaf.");
			break;
		case Winter:
			System.out.println("winter is cool.");
			break;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(EnumSeason s:EnumSeason.values()){
			System.out.println(s);
		}
		new UsefulEnumTest().judge(EnumSeason.Spring);
		EnumSeason spring=EnumSeason.valueOf(EnumSeason.class, "Spring");
		new UsefulEnumTest().judge(spring);
		EnumSeason.Spring.info();
	}

}

/*一个接口，被枚举类的不同实例实现*/
interface Desc{
	void info();
}

enum EnumSeason implements Desc{
	Spring("spring"){
		public void info(){
			System.out.println("spring is green.");
		}
	},
	Summer("summer"){
		public void info(){
			System.out.println("summer is hot.");
		}
	},
	Fall("fall"){
		public void info(){
			System.out.println("fall is leaf.");
		}
	},
	Winter("winter"){
		public void info(){
			System.out.println("winter is cool.");
		}
	};
	private final String name;
//	private String name;
	
	/*不推荐，建议应该不能改变*/
//	public void setName(String name){
//		switch(this){
//		case Spring:
//			if(name.equals("spring"))this.name=name;
//			else System.out.println("not match");
//			break;
//		case Summer:
//			if(name.equals("summer"))this.name=name;
//			else System.out.println("not match");
//			break;
//		case Fall:
//			if(name.equals("fall"))this.name=name;
//			else System.out.println("not match");
//			break;
//		case Winter:
//			if(name.equals("winter"))this.name=name;
//			else System.out.println("not match");
//			break;
//		}
//	}
	
	/*枚举类的构造函数用于初始化常量属性*/
	EnumSeason(String name){
		this.name=name;
	}
	
	public String getName() {
		return name;
	}
	
}