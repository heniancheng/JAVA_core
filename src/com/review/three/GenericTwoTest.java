package com.review.three;

/**
 * 通配符在范弄中使用，限制范型的元素
 * @author hechen
 * @version 1.3
 */
import java.util.*;

public class GenericTwoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<?> list=new ArrayList<String>();
        //不允许在使用通配符的集合中加入元素
   	    //list.add(new String("abc"));
		
		GenericApple<Integer> apple=new GenericApple<Integer>(3);
		GenericApple<Double> appleB=new GenericApple<Double>(3.5);
		
		String str=GenericMethod.test("string");
		System.out.println(str);
	}

}

class GenericApple<T extends Number & java.io.Serializable>{
	private T col;
	
	public GenericApple(T col){
		this.col=col;
	}

	public T getCol() {
		return col;
	}

	public void setCol(T col) {
		this.col = col;
	}
	
}

class GenericMethod{
	
	//泛型方法的简单使用
	public static <T> T test(T arg1){
		return arg1;
	}
	
	//类型通配符的下限的设定：下限为源
	public static <T> T copy(Collection<? super T> dest,Collection<T> src){
		T last=null;
		for(T a:src){
			last=a;
			dest.add(a);
		}
		return last;
	}
	
	//类型通配符的上限的设定：上限为目的
	public static <T> void copyTwo(Collection<T> dest,Collection<? extends T> src){
		for(T o:src){
			dest.add(o);
		}
	}
}
