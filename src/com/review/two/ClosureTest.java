package com.review.two;

/**
 * 闭包实现内部类回调外部类函数
 * @author hechen
 * @version 1.1
 */
public class ClosureTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeachableProgrammer tp=new TeachableProgrammer("hechen");
		tp.getCallbackReference().work();
		tp.work();
	}

}

interface Teachable{
	public void work();
}

class Programmer{
	private String name;
	public Programmer(){}
	public Programmer(String name){
		this.name=name;
	}
	public void work(){
		System.out.println(name+" click keyboard!");
	}
}

class TeachableProgrammer extends Programmer{
	public TeachableProgrammer(){};
	public TeachableProgrammer(String name){
		super(name);
	}
	private void teach(){
		System.out.println("teaching");
	}
	private class Closure implements Teachable{

		@Override
		public void work() {
			// TODO Auto-generated method stub
			teach();
		}
		
	}
	
	public Teachable getCallbackReference(){
		return new Closure();
	}
}

