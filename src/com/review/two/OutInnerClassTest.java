package com.review.two;

/**
 * 内部类与外部类的简单实例：成员内部类
 * @author hechen
 * @version 1.1
 */

public class OutInnerClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Out.Inner inner=new Out().new Inner("test");
		Out.Inner inner2;
		Out out=new Out();
		inner2=out.new Inner("test2");
		Out.StaticInner Sinner=new Out.StaticInner("test");
	}

}

/*
 * 一个外部类(Out)中包括一个非静态内部类(Inner)，静态内部类(StaticInner)
 */
class Out{
	class Inner{
		public Inner(String msg){
			System.out.println("inner:"+msg);
		}
	}
	static class StaticInner{
		public StaticInner(String msg){
			System.out.println("static inner:"+msg);
		}
	}

}

/*
 * 一个类(SubInner)继承了一个内部类(Inner)
 */
class SubInner extends Out.Inner{
	public SubInner(Out out){
		out.super("hello");
	}
}
