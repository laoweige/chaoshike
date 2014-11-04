package com.chaoshi.scheduler;

import com.chaoshi.util.EnumTimeUnit;
import com.chaoshi.util.TimeHepler;

import java.util.Calendar;
import java.util.Date;


public abstract class AbsCronTask extends AbsScheduleTask {


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		AbsCronTask task = new AbsCronTask();
//		TaskInfo info = new TaskInfo(1,Calendar.getInstance());
//		info.setArgument(new String[]{"6:30","20:30","23:00"});
//		task.Execute(info);
	}
	
	public abstract void Execute();
	
	@Override
	public void Execute(TaskInfo taskInfo) {
		if(taskInfo.argument!=null){
			String[] times=(String[])taskInfo.argument;
			for (String t : times) {
				String[] hm=t.split(":");
				Calendar nowTime=Calendar.getInstance();
				System.out.println(TimeHepler.getStringDateShort(nowTime.getTime()) );
				nowTime.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hm[0]));
				nowTime.set(Calendar.MINUTE, Integer.parseInt(hm[1]));
				Date runTime=nowTime.getTime();
				if(TimeHepler.compare(runTime, TimeHepler.EnumCompare.LT,new Date())){
					nowTime.add(Calendar.DAY_OF_MONTH, 1);
					runTime=nowTime.getTime();
				}
				System.out.println(TimeHepler.getStringDateShort(runTime));
				TaskInfo tinfo = TaskInfoBuilder.Create(this.getClass(),null,runTime, EnumTimeUnit.DAY);
				RunTaskScheduler.getInstance().Add(tinfo);
			}			
			taskInfo.argument=null;
			TaskPool.remove(taskInfo.getTaskId());
		}else{
			Execute();
		}
	}

}
