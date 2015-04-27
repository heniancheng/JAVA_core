package com.review.two;

/**
 * 手动实现一个枚举类：构造器被私有，自身定义该类实例作为属性
 * @author hechen
 * @version 1.1
 */

public class enumSeasonTest {
	
	public enumSeasonTest(Season season){
		System.out.println("season: "+season.getName()+"\ndesc: "+season.getDesc());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new enumSeasonTest(Season.Spring);
	}

}

class Season{
	
	private final String name;
	private final String desc;
	public static final Season Spring=new Season("spring","green");
	public static final Season Summer=new Season("summer","hot");
	public static final Season Fall=new Season("season","leaf");
	public static final Season Winter=new Season("winter","cool");
	
	private Season(String name, String desc) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.desc=desc;
	}
	public static Season getSeason(int seasonNum){
		switch(seasonNum){
		case 1:
			return Spring;
		case 2:
			return Summer;
		case 3:
			return Fall;
		case 4:
			return Winter;
		default:
			return null;
		}
	}
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
}
