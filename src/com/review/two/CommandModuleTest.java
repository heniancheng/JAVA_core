package com.review.two;

/**
 * 一个命令模式的简单实例：不同命令作为参数
 * @author hechen
 * @version 1.1
 */
import java.util.Arrays;

public class CommandModuleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProcessArray pa=new ProcessArray();
		int[] target={3,-4,6,4};
		pa.process(target, new PrintCommand());
		pa.process(target, new AddCommand());
	}

}

interface Command{
	void process(int[] target);
}

class PrintCommand implements Command{

	@Override
	public void process(int[] target) {
		// TODO Auto-generated method stub
		System.out.println("Array print: "+Arrays.toString(target));
	}
	
}

class AddCommand implements Command{

	@Override
	public void process(int[] target) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<target.length;i++){
			sum+=target[i];
		}
		System.out.println("the sum: "+sum);
	}
	
}

class ProcessArray{
	public void process(int[] target, Command cmd){
		cmd.process(target);
	}
}
