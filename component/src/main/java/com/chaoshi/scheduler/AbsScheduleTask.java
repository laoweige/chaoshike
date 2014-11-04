package com.chaoshi.scheduler;


public abstract class AbsScheduleTask implements ITask,IResumeTask {


	@Override
	public abstract void Execute(TaskInfo taskInfo);
	
	@Override
	public void resumeTask(TaskInfo taskInfo) {
		if (TaskPool.ContainsTaskId(taskInfo.getTaskId())){
			//Calendar nextTime=Calendar.getInstance();
			//nextTime.add(taskInfo.timeUnit.getValue(),taskInfo.timeUnit.getInterval());
            //taskInfo.nextRunTime=nextTime;
            taskInfo.nextRunTime=taskInfo.getTimeUnit().addNextTime();
            //System.out.println("nextTime="+TimeHepler.getStringDateShort(nextTime.getTime()));
		}
	}

}
