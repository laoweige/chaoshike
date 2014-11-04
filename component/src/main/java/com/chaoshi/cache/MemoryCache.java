package com.chaoshi.cache;

import com.chaoshi.util.EnumTimeUnit;
import com.chaoshi.util.TimeHepler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MemoryCache<T> implements ICache<T> {
	private static final String KEY_SUFFIX = "AJPG-14AG-HGHA65-HHPYOI";

	private HashMap<String, CacheItem<T>> cache;
	private Queue<String> expiryQueue;
//	private final Object DATA_LOCK = new Object();
	private final static int MAX_SIZE = 10000;

	public MemoryCache() {
		cache = new HashMap<String, CacheItem<T>>();
		expiryQueue = new LinkedList<String>();
	}

	@Override
	public void add(String key, T value, EnumTimeUnit timeUnit) {

		CacheItem<T> item = new CacheItem<T>(value, timeUnit.addNextTime().getTime());

		this.add(key, item);
	}

	@Override
	public void add(String key, CacheItem<T> cacheItem) {
		this.cache.put(key, cacheItem);
		this.addExpiry(key);
	}

	@Override
	public T get(String key, IEntityFactory<T> dataBuilder, EnumTimeUnit timeUnit) {
		CacheItem<T> item = getCacheItem(key, dataBuilder, timeUnit);

		return item.getValue();
	}

	@Override
	public void remove(String key) {
		if (cache.containsKey(key))
			cache.remove(key);
	}

	@Override
     public int size() {
        return cache.size();
    }

	private void addExpiry(String key) {
		String deleteKey;
		while (expiryQueue.size() >= MAX_SIZE) {
			deleteKey = expiryQueue.poll();
			if (cache.containsKey(deleteKey) && !expiryQueue.contains(deleteKey))
				cache.remove(deleteKey);
		}
		expiryQueue.offer(key);
	}

	@Override
	public CacheItem<T> getCacheItem(String key, IEntityFactory<T> dataBuilder, EnumTimeUnit timeUnit) {
		CacheItem<T> item = cache.get(key);
		if (item == null || TimeHepler.compare(item.getExpiry()) == TimeHepler.EnumCompare.GT) {
			Object lock = (key + KEY_SUFFIX).intern();
			synchronized (lock) {
				item = cache.get(key); // 二次查询缓存
				if (item == null || TimeHepler.compare(item.getExpiry()) == TimeHepler.EnumCompare.GT) { // 仍旧无结果
					T value = null;
					try {
						value = dataBuilder.get(key);
						if (value != null) {
							if (item == null) {
								item = new CacheItem<T>(value, timeUnit.addNextTime().getTime());
							}
							add(key, item);
						} else {
							item = new CacheItem<T>(null, timeUnit.addNextTime().getTime());
						}
					} catch (ExpiryException e) {
						if (item != null) {
							item.setExpiry(timeUnit.addNextTime().getTime());
							value = item.getValue();
						} else {
							return null;
						}

					}
				}
			}
		}
		return item;
	}

	@Override
	public void clear() {
		synchronized (cache) {
			expiryQueue.clear();
			cache.clear();
		}
	}

}
