package com.review.two;

/**
 * 含抽象方法的枚举类：加减乘除
 * @author hechen
 * @version 1.1
 */
public class EnumOperationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a=3,b=4;
		System.out.println(Operation.PLUS.eval(a, b));
	}

}

enum Operation{
	PLUS("plus"){
		public double eval(double a,double b){
			return a+b;
		}
	},
	MINUS("minus"){
		public double eval(double a,double b){
			return a-b;
		}
	},
	TIMES("times"){
		public double eval(double a,double b){
			return a*b;
		}
	},
	DIVIDE("divide"){
		public double eval(double a,double b){
			return a/b;
		}
	};
	private final String desc;
	Operation(String desc){
		this.desc=desc;
	}
	public abstract double eval(double a,double b);
	public String getDesc() {
		return desc;
	}
}
