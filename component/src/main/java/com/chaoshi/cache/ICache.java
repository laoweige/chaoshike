package com.chaoshi.cache;


import com.chaoshi.util.EnumTimeUnit;

//内存缓存
public interface ICache<T> {
	public T get(String key, IEntityFactory<T> dataBuilder, EnumTimeUnit timeUnit);
	
	public CacheItem<T> getCacheItem(String key, IEntityFactory<T> dataBuilder, EnumTimeUnit timeUnit);
	
	public void add(String key, T value, EnumTimeUnit timeUnit);

	public void add(String key, CacheItem<T> cacheItem);

	public void remove(String key);

	public int size();

	public void clear();
}
