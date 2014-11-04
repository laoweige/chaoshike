package com.chaoshi.scheduler;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskPool {
	
	static Map<Integer,TaskInfo> _tasks = new HashMap<Integer,TaskInfo>();
	//static Map<Integer,ITask> _executers = new HashMap<Integer,ITask>();
	public static synchronized boolean ContainsTaskId(int taskId){
		return _tasks.containsKey(taskId);
	}
	public static synchronized void add(TaskInfo taskInfo){
		_tasks.put(taskInfo.taskId, taskInfo);
		//_executers.put(key, value)
	}
	
	public static synchronized void remove(int taskId){
		_tasks.remove(taskId);
		//_executers.remove(taskId);
	}
	
	public static synchronized void clear(){
		_tasks.clear();
		//_executers.clear();
	}
	
	public static synchronized List<TaskInfo> getWaitRunTasks(){
		List<TaskInfo> tasks = new ArrayList<TaskInfo>();
		Calendar now = Calendar.getInstance();
		for (int tid : _tasks.keySet()) {
			TaskInfo task = _tasks.get(tid);
			int i=now.compareTo(task.nextRunTime);
			if(i>=0){
				tasks.add(task);
				task.nextRunTime.add(Calendar.YEAR, 30);
			}
		}
		return tasks;
	}
	
	public static void main(String[] args) {
		Calendar next=Calendar.getInstance();
		next.add(Calendar.MINUTE, 2);
		TaskPool.add(new TaskInfo(1,next));
		List<TaskInfo> _tasks = getWaitRunTasks();
		System.out.println(_tasks);
	}
	
}
