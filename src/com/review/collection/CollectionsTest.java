package com.review.collection;

import java.util.*;


/**
 * Collections工具类提供的方法：排序操作，线程安全集合，只读集合
 * @author hechen
 * @version 1.2
 */

public class CollectionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 排序等操作 */
		ArrayList arrlist=new ArrayList();
		arrlist.add(2);
		arrlist.add(5);
		arrlist.add(4);
		System.out.println("初始集合");
		System.out.println(arrlist);
		Collections.sort(arrlist);
		System.out.println("排序集合");
		System.out.println(arrlist);
		Collections.reverse(arrlist);
		System.out.println("逆序集合");
		System.out.println(arrlist);
		Collections.shuffle(arrlist);
		System.out.println("洗牌集合");
		System.out.println(arrlist);
		
		/* 线程安全集合 */
		Collection syncollection=Collections.synchronizedCollection(new ArrayList());
		List synlist=Collections.synchronizedList(new LinkedList());
		Set synset=Collections.synchronizedSet(new HashSet());
		Map synmap=Collections.synchronizedMap(new HashMap());
		
		/* 只读集合 */
		List readlist= Collections.emptyList();
		System.out.println(readlist);
		Set singleton=Collections.singleton(new String("abc"));
		System.out.println(singleton);
		Map map=new HashMap();
		map.put(2,22);
		map.put(3,33);
		Map readmap=Collections.unmodifiableMap(map);
		System.out.println(readmap);
		
		
	}

}
