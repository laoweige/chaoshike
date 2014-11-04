package com.chaoshi.scheduler;


import com.chaoshi.util.EnumTimeUnit;

import java.util.Date;

public abstract class AbsRunService {

	public void start(){
		build();
		RunTaskScheduler.getInstance().start();
	}
	
	public abstract void build();

	public <T extends ITask> void AddTask(Class<T> t,Date startTime,EnumTimeUnit timeUnit){
		TaskInfo taskInfo = TaskInfoBuilder.Create(t,null,startTime, timeUnit);
		RunTaskScheduler.getInstance().Add(taskInfo);
	}
	public <T extends ITask> void AddTask(Class<T> t,EnumTimeUnit timeUnit){
		TaskInfo taskInfo = TaskInfoBuilder.Create(t,null,new Date(), timeUnit);
		RunTaskScheduler.getInstance().Add(taskInfo);
	}
	public <T extends ITask> void AddTask(Class<T> t,Object arg,EnumTimeUnit timeUnit){
		TaskInfo taskInfo = TaskInfoBuilder.Create(t,arg,new Date(), timeUnit);
		RunTaskScheduler.getInstance().Add(taskInfo);
	}
	public <T extends ITask> void AddTask(Class<T> t,Object arg,Date startTime,EnumTimeUnit timeUnit){
		TaskInfo taskInfo = TaskInfoBuilder.Create(t,arg,startTime, timeUnit);
		RunTaskScheduler.getInstance().Add(taskInfo);
	}

}
