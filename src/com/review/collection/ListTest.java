package com.review.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 列表类：ArrayList,Stack,LinkedList,PriorytyQueue，推荐用LinkedList
 * 该类实现了List，Stack，Queue的特征
 * @author hechen
 * @version 1.2
 */

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] books={"english","math","chinese"};
		
		/* ArrayList的使用 */
		System.out.println("arraylist:");
		ArrayList arrlist=new ArrayList();
		arrlist.add(books[0]);
		arrlist.add(books[1]);
		arrlist.add(books[2]);
		System.out.println(arrlist.toString());
		ListIterator listiter=arrlist.listIterator();
		while(listiter.hasNext()){
			System.out.println(listiter.next());
			listiter.add("-----分隔-----");
		}
		while(listiter.hasPrevious()){
			System.out.println(listiter.previous());
		}
		/* 向量Vector的子类Stack的使用 */
		System.out.println("stack:");
		Stack stalist=new Stack();
		stalist.push(books[0]);
		stalist.push(books[1]);
		while(!stalist.isEmpty()){
			System.out.println(stalist.pop());
		}
		/* Arrays工具类中固定长度的List */
		System.out.println("arrays:");
		List arrays=Arrays.asList(books);
		for(int i=0;i<arrays.size();i++){
			System.out.println(arrays.get(i));
		}
		/* LinkedList兼有List，Queue，Stack的特性，它实现了Deque */
		System.out.println("linkedlist:");
		LinkedList linklist=new LinkedList();
		linklist.add(books[0]);
		linklist.add(books[1]);
		while(!linklist.isEmpty()){
			System.out.println(linklist.poll());
			
		}
		/* PriorityQueue队列中的元素应该实现了Comparable接口 */
		System.out.println("priorityqueue:");
		PriorityQueue queue=new PriorityQueue();
		queue.add(2);
		queue.add(3);
		while(!queue.isEmpty()){
			System.out.println(queue.poll());
			
		}
	}

}
