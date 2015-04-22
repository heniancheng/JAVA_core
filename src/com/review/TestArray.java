package com.review;

import java.util.Arrays;
/**
 * 简单的数组测试类
 * @author hechen
 * @version 1.0
 */
public class TestArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//静态初始化一维数组arr1
		int[] arr1;
		arr1=new int[]{1,2,3};
		
		//动态初始化一维数组arr2
		int[] arr2=new int[4];
		for(int i=0;i<4;i++){
			arr2[i]=i+1;
		}
		
		//静态初始化二维数组arr3
		int[][] arr3;
		arr3=new int[][]{{1,2},{3,4,5}};
		
		//动态初始化二维数组arr4
		int[][] arr4;
		arr4=new int[2][];
		arr4[0]=new int[2];
		arr4[1]=new int[3];
		for(int i=0;i<2;i++){
			arr4[0][i]=i+1;
		}
		for(int i=0;i<3;i++){
			arr4[1][i]=i+3;
		}
		
		//JAVA提供的数组工具类java.util.Arrays
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		
	}

}
