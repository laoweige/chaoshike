package com.chaoshi.cache;

import com.chaoshi.util.EnumTimeUnit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CacheTester {
	static HashMap<Class<?>, Object> instances=new HashMap<Class<?>, Object>();
	static{
		instances.put(String.class, new MemoryCache<String>());
	}
	public static <T> T get(Class<T> tc,String key,IEntityFactory<T> dataBuilder,EnumTimeUnit timeUnit){
		if(!instances.containsKey(tc)){
			System.out.println("错误");
		}
		@SuppressWarnings("unchecked")
		MemoryCache<T> cache = (MemoryCache<T>)instances.get(tc);
		return cache.get(key, dataBuilder, timeUnit);
	}
	
	
	static int aa=0;
	public static void main(String[] args) {
	
		MemoryCache<List<String>> cache = new MemoryCache<>();
		List<String> aa=cache.get("1", new IEntityFactory<List<String>>(){
			@Override
			public List<String> get(String key) throws ExpiryException {
				System.out.println("没有缓存");
				List<String> list = new ArrayList<String>();
				list.add("1");
				list.add("2");
				
				return list;
			}
			
		}, EnumTimeUnit.SECOND.adjustInterval(10));
		System.out.println(aa);
		
		
		aa=cache.get("1", new IEntityFactory<List<String>>(){
			@Override
			public List<String> get(String key) throws ExpiryException {
				System.out.println("没有缓存");
				List<String> list = new ArrayList<String>();
				list.add("1");
				list.add("2");
				return list;
			}
			
		}, EnumTimeUnit.SECOND.adjustInterval(10));
		System.out.println(aa);
		try {
			TimeUnit.SECONDS.sleep(11);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		aa=cache.get("1", new IEntityFactory<List<String>>(){
			@Override
			public List<String> get(String key) throws ExpiryException {
				System.out.println("没有缓存");
				List<String> list = new ArrayList<String>();
				list.add("1");
				list.add("2");
				return list;
			}
			
		}, EnumTimeUnit.SECOND.adjustInterval(10));
		System.out.println(aa);
	}
}
