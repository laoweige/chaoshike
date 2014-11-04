package com.chaoshi.cache;


public interface IEntityFactory<T> {
	T get(String key) throws ExpiryException;
}
