package com.chaoshi.scheduler;

import com.chaoshi.util.EnumTimeUnit;

import java.util.Calendar;


public class TaskInfo {
	int taskId;
	Object argument;

	Calendar nextRunTime;
	EnumTimeUnit timeUnit;
	ITask task;

	public Object getArgument() {
		return argument;
	}

	public void setArgument(Object argument) {
		this.argument = argument;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public ITask getTask() {
		return task;
	}

	public EnumTimeUnit getTimeUnit() {
		return timeUnit;
	}

	public void setTimeUnit(EnumTimeUnit timeUnit) {
		this.timeUnit = timeUnit;
	}

	public void setTask(ITask task) {
		this.task = task;
	}

	public Calendar getNextRunTime() {
		return nextRunTime;
	}

	public void setNextRunTime(Calendar nextRunTime) {
		this.nextRunTime = nextRunTime;
	}

	public TaskInfo(int taskId, Calendar nextRunTime) {
		super();
		this.taskId = taskId;
		this.nextRunTime = nextRunTime;
		this.timeUnit = EnumTimeUnit.SECOND;
	}

}
