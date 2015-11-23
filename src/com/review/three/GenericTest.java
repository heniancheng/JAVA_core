package com.review.three;

/**
 * 基本的薄型使用，范型的继承
 * @author hechen
 * @version 1.3
 */

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apple<String> apple=new Apple<String>("apple");
		System.out.println(apple.getInfo());
		SmallAppleOne<String,Integer> smallapple=new SmallAppleOne<String,Integer>("apple",3);
		System.out.println(smallapple.getInfo()+" "+smallapple.getSize());
		SmallAppleTwo<Integer> smallappleB=new SmallAppleTwo<Integer>("apple",4);
		System.out.println(smallappleB.getInfo()+" "+smallappleB.getSize());
	}

}

class Apple<T>{
	private T info;
	
	public Apple(T info){
		this.info=info;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}	
}
/* 方式1 */
class SmallAppleOne<T,V> extends Apple<T>{

	private V size;
	
	public SmallAppleOne(T info,V size) {
		super(info);
		this.size=size;
	}
	
	public T getInfo(){
		return super.getInfo();
	}
	
	public void setInfo(T info){
		super.setInfo(info);
	}

	public V getSize() {
		return size;
	}

	public void setSize(V size) {
		this.size = size;
	}
}
/* 方式2 */
class SmallAppleTwo<V> extends Apple<String>{

	private V size;
	
	public SmallAppleTwo(String info,V size) {
		super(info);
		this.size=size;
	}
	
	public String getInfo(){
		return super.getInfo();
	}
	
	public void setInfo(String info){
		super.setInfo(info);
	}

	public V getSize() {
		return size;
	}

	public void setSize(V size) {
		this.size = size;
	}
}