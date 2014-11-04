package com.chaoshi.cache;

import com.chaoshi.util.TimeHepler;

import java.util.Date;


public class CacheItem<T> {
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	T value;
	Date expiry;

	public CacheItem(T value, Date expiry) {
		this.value = value;
		this.expiry = expiry;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("value:%s;expiry:%s", value,
				TimeHepler.getStringDateShort(expiry));
	}
}
