package com.chaoshi.scheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RunTaskScheduler {
	
	private RunTaskScheduler(){
		//System.out.println("=============thread.size="+BaseConfig.THREAD_SIZE);
	}
	public static RunTaskScheduler taskScheduler = new RunTaskScheduler();
	public static RunTaskScheduler getInstance(){
		return taskScheduler;
	}
	
	ScheduledExecutorService schedule = Executors.newScheduledThreadPool(2);
	
	public void start(){
		schedule.scheduleWithFixedDelay(new TaskExecuter(), 0, 1, TimeUnit.SECONDS);
	}
	
	public void Add(TaskInfo taskInfo){
		//TaskInfo taskInfo = TaskInfoBuilder.Create(t,startTime, timeUnit);
		TaskPool.add(taskInfo);
	}
	
//	public <T extends ITask> void Add(Class<T> t,Date startTime,EnumTimeUnit timeUnit){
//		TaskInfo taskInfo = TaskInfoBuilder.Create(t,startTime, timeUnit);
//		TaskPool.add(taskInfo);
//	}
//	
//	public <T extends ITask> void Add(Class<T> t,Object arg,Date startTime,EnumTimeUnit timeUnit){
//		TaskInfo taskInfo = TaskInfoBuilder.Create(t,arg,startTime, timeUnit);
//		TaskPool.add(taskInfo);
//	}
	
	
	
	public void stop(){
		//schedule.
	}
	public void clearTask(){
		List<Future<TaskInfo>> newList=new ArrayList<Future<TaskInfo>>();
		for (Future<TaskInfo> future : futureList) {
			if(!future.isDone())
				newList.add(future);
		}
		synchronized (futureList) {
			futureList=newList;
		}
	}
	
	public List<Future<TaskInfo>> futureList=new ArrayList<Future<TaskInfo>>();
	class TaskCallable implements Callable<TaskInfo>{
		public TaskCallable(TaskInfo info){
			taskInfo=info;
		}
		TaskInfo taskInfo;
		@Override
		public TaskInfo call() throws Exception {
			try{
				taskInfo.getTask().Execute(taskInfo);
			}catch(Exception ex){
//				ex.printStackTrace();
				System.out.println(ex.toString());
			}
			
			if(taskInfo.getTask() instanceof IResumeTask ){
				IResumeTask iaddtask = (IResumeTask)taskInfo.getTask();
				iaddtask.resumeTask(taskInfo);
			}
			return taskInfo;
		}
		
	}
	ExecutorService testExecutor = Executors.newFixedThreadPool(2);
	class TaskExecuter implements Runnable{
		@Override
		public void run() {
			RunTaskScheduler.this.clearTask();
				
			List<TaskInfo> _tasks = TaskPool.getWaitRunTasks();
			if(_tasks.size()>0){
				synchronized (futureList) {
					for (TaskInfo taskInfo : _tasks) {
						Future<TaskInfo> future= testExecutor.submit(new TaskCallable(taskInfo));
						futureList.add(future);
					}
				}
			}
			//System.out.println("系统调度  end ++++++++++++++++++++++++++");
		}
		
		
	}
	
	public static void main(String[] args) {
		
		
		
	}
		
		
}
