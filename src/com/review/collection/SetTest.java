package com.review.collection;

/**
 * 集合类：HashSet,TreeSet,EnumSet,中的元素尽量为不可变对象
 * @author hechen
 * @version 1.2
 */

import java.util.EnumSet;
import java.util.HashSet;
import java.util.TreeSet;

import com.review.two.enumSeasonTest;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet set=new HashSet();
		
		/*验证加入A,B,C三个类型的元素*/
		set.add(new A());
		set.add(new A());
		set.add(new B());
		set.add(new B());
		set.add(new C());
		set.add(new C());
		System.out.println(set.size()+" "+set.toString());
		
		/*可变元素加入集合，修改元素时可能导致两元素相同*/
		HashSet setB=new HashSet();
		alterable a1=new alterable(1);
		alterable a2=new alterable(2);
		setB.add(a1);
		setB.add(a2);
		a1.count=2;
		System.out.println(setB.size()+" "+setB.toString());
		System.out.println(a1.equals(a2));
		System.out.println(a1==a2);
		System.out.println(setB.remove(new alterable(1))); //无法再去访问修改的元素
		
		/* 可变元素加入集合，修改元素时可能导致无序 */
		TreeSet setC=new TreeSet();
		alterable a3=new alterable(3);
		alterable a4=new alterable(4);
		alterable a5=new alterable(-1);
		alterable a6=new alterable(-2);
		setC.add(a3);
		setC.add(a4);
		setC.add(a5);
		setC.add(a6);
		System.out.println(setC.size()+" "+setC.toString());
		a3.count=-2;
		System.out.println(setC.size()+" "+setC.toString());
		System.out.println(setC.remove(new alterable(-2)));
		System.out.println(setC.size()+" "+setC.toString());
		
		EnumSet es1=EnumSet.allOf(Season.class);
		System.out.println(es1);
		EnumSet es2=EnumSet.noneOf(Season.class);
		es2.add(Season.Spring);
		es2.add(Season.Winter);
		System.out.println(es2);
		EnumSet es3=EnumSet.of(Season.Summer,Season.Fall);
		System.out.println(es3);
		EnumSet es4=EnumSet.range(Season.Summer, Season.Winter);
		System.out.println(es4);
		EnumSet es5=EnumSet.complementOf(es4);
		System.out.println(es5);
	}

}

/*A,B,C三个对象分别重写了一些函数，用来验证元素是否加入集合*/
/* 实现了equals()方法的类 */
class A{
	public boolean equals(Object obj){
		return true;
	}
}

/* 实现了hashCode()方法的类 */
class B{
	public int hashCode(){
		return 1;
	}
}

/* 实现了两个方法的类*/
class C{
	public int hashCode(){
		return 2;
	}
	public boolean equals(Object obj){
		return true;
	}
}

/* 一个可变的类 */
class alterable implements Comparable{
	public int count;
	public alterable(int count){
		this.count=count;
	}
	
	public String toString(){
		return ""+this.count;
	}
	
	public boolean equals(Object obj){
		if(obj instanceof alterable){
			alterable al=(alterable) obj;
			if(al.count==this.count){
				return true;
			}
		}
		return false;
	}
	
	public int hashCode(){
		return this.count;
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		alterable al=(alterable) obj;
		if(this.count>al.count){
			return 1;
		}
		else if(this.count==al.count){
			return 0;
		}
		else{
			return -1;
		}
	}
}

enum Season{
	Spring,Summer,Fall,Winter;
}
