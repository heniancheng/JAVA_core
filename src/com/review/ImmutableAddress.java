package com.review;

/**
 * 不可变类，不提供修改成员变量的方法
 * @author hechen
 * @version 1.0
 */
public class ImmutableAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1=new String("Hello");
		String str2=new String("Hello");
		Address add1=new Address("abc","111");
		Address add2=new Address("abc","111");
		System.out.println(add1==add2);
		System.out.println(add1.equals(add2));
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.println(str1.hashCode());
		System.out.println(str2.hashCode());
	}

}

class Address{
	
	private final String detail;
	private final String postCode;
	
	public Address(){
		detail="";
		postCode="";
	}
	public Address(String detail,String postCode ){
		this.detail=detail;
		this.postCode=postCode;
	}
	public String getDetail(){
		return this.detail;
	}
	public String getPostCode(){
		return this.postCode;
	}
	public boolean equals(Object obj){
		if(obj instanceof Address){
			Address add=(Address)obj;
			if(this.getDetail().equals(add.getDetail())&&this.getPostCode().equals(add.getPostCode())){
				return true;
			}
		}
		return false;
	}
	public int hashCode(){
		return detail.hashCode()+postCode.hashCode();
	}
}
