package com.review.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 映射类：HashMap,TreeMap,EnumMap；不同的映射类的key对应不同的集合，而映射类中的值相当于List
 * @author hechen
 * @version 1.2
 */

public class MapTest {

	private static boolean Entry;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> map=new HashMap();
		map.put(2,22);
		map.put(3,33);
		Set key=map.keySet();
		Collection value=map.values();
		Iterator iter=key.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		Iterator listiter=value.iterator();
		while(listiter.hasNext()){
			System.out.println(listiter.next());
		}
		for(Entry obj : map.entrySet()){
			System.out.println(obj.getKey()+" "+obj.getValue());
		}
	}

}
