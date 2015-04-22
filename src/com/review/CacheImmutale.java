package com.review;

/**
 * 缓存不变实例，针对需要使用相同的不可变实例
 * @author hechen
 * @version 1.0
 */
public class CacheImmutale {
	
	private final String name;
	private static CacheImmutale[] cache=new CacheImmutale[10];
	private static int pos=0;
	public CacheImmutale(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public static CacheImmutale valueOf(String name){
		for(int i=0;i<pos;i++){
			if(cache[i]!=null && cache[i].getName().equals(name)){
				return cache[i];
			}
		}
		if(pos>=10){
			cache[0]=new CacheImmutale(name);
			pos=1;
			return cache[0];
		}
		else{
			cache[pos++]=new CacheImmutale(name);
			return cache[pos-1];
		}
	}
	
	public boolean equals(Object obj){
		if(obj instanceof CacheImmutale){
			CacheImmutale ca=(CacheImmutale) obj;
			if(name.equals(ca.getName())){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CacheImmutale cache1=CacheImmutale.valueOf("hello");
		CacheImmutale cache2=CacheImmutale.valueOf("hello");
		System.out.println(cache1 == cache2);
		
	}

}
