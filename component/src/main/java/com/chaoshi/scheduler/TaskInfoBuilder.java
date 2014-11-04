package com.chaoshi.scheduler;

import com.chaoshi.util.EnumTimeUnit;

import java.util.Calendar;
import java.util.Date;


public class TaskInfoBuilder{
	
	static int taskId=-1;
	
	public static <T extends ITask> TaskInfo Create(Class<T> t,EnumTimeUnit timeUnit){
		return Create(t,null,new Date(),timeUnit);
	}
	
	public static <T extends ITask> TaskInfo Create(Class<T> t, Date runTime){
		return Create(t,null,runTime,EnumTimeUnit.SECOND);
	}
	
	public static <T extends ITask> TaskInfo Create(Class<T> t, Date runTime,EnumTimeUnit timeUnit){
		
		return Create(t,null,runTime,timeUnit);
	}
	
	
	public static <T extends ITask> TaskInfo Create(Class<T> t, Object argument,EnumTimeUnit timeUnit){
		
		return Create(t,argument,new Date(),timeUnit);
	}
	
	public static <T extends ITask> TaskInfo Create(Class<T> t,Object argument, Date runTime,EnumTimeUnit timeUnit){
		Calendar runNextTime=Calendar.getInstance();
		runNextTime.setTime(runTime);
		TaskInfo info =  new TaskInfo(++taskId, runNextTime);
		info.setArgument(argument);
		info.setTimeUnit(timeUnit);
		try {
			info.setTask(t.newInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

}
