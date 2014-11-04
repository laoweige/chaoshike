package com.chaoshi.util;

import java.util.Calendar;

public enum EnumTimeUnit {
	SECOND(13,1),
	MINUTE(12,1),
	HOUR(10,1),
	DAY(5,1);
	
	private int interval;
	public int getInterval() {
		return interval;
	}
	
	public EnumTimeUnit adjustInterval(int interval) {
		this.interval = interval;
		return this;
	}
	private int value=13;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	private EnumTimeUnit(int value,int interval){
		this.value=value;
		this.interval=interval;
	}
	public Calendar addNextTime(){
		Calendar nextTime=Calendar.getInstance();
		nextTime.add(this.getValue(),this.getInterval());
		return nextTime;
	}
	
}
