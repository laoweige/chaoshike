package com.zhaopin.applycv.services;


public class IndexService extends AbsRunService {

	private final static String GROUP_NAME = ApplycvConfig.KAFKA_GROUP_INDEXSERVICE;

	@Override
	public void build() {
		// 应聘简历
		this.AddTask(QueueReadTask.class, new TaskArgument(2, ApplycvConfig.TOPIC_APPLY, GROUP_NAME), EnumTimeUnit.SECOND.adjustInterval(30));
		this.AddTask(QueueConvertTask.class, new TaskArgument(ApplycvConfig.TOPIC_APPLY, ApplyLog.class), EnumTimeUnit.SECOND.adjustInterval(1));
		for (int i = 0; i < ApplycvRemoteConfig.Instance().getApplyPostTaskThreadCount(); i++) {
			this.AddTask(IndexPostTask.class, new TaskArgument(ApplycvConfig.TOPIC_APPLY, ApplyLog.class), EnumTimeUnit.SECOND.adjustInterval(1));
		}

		this.AddTask(ApplyFaultToleranceTask.class, EnumTimeUnit.SECOND.adjustInterval(10));

		// 备份
		this.AddTask(MessageBackupTask.class, new TaskArgument(GROUP_NAME), EnumTimeUnit.SECOND.adjustInterval(1));
	}
}