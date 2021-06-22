package com.example.demo.quartz;

/**
 * quartz api
 */

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class QuartzSchedulerConfig {

    @Autowired
    private Scheduler scheduler;

    /**
     * 开始执行所有任务
     */
    public void startAllJob() throws SchedulerException {
        startJob(scheduler);
        startJob2(scheduler);
        scheduler.start();
    }

    /**
     * 获取 job 信息
     *
     * @param name
     * @param group
     * @return
     * @throws SchedulerException
     */
    public String getJobInfo(String name,String group) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        System.out.println(String.format("time:%s,state:%s",cronTrigger.getCronExpression(),scheduler.getTriggerState(triggerKey).name()));
        return String.format("time:%s,state:%s",cronTrigger.getCronExpression(),scheduler.getTriggerState(triggerKey).name());
    }

    /**
     * 修改某个任务的执行时间
     *
     * @param name
     * @param group
     * @param time
     * @return
     * @throws SchedulerException
     */
    public String modifyJob(String name,String group,String time) throws SchedulerException {
        TriggerKey triggerKey = new TriggerKey(name, group);
        CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        // 得到 cron 表达式
        String cron = cronTrigger.getCronExpression();
        if(!cron.equalsIgnoreCase(time)){
//            创建新的 cron触发器
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(time);
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(name,group)
                    .withSchedule(cronScheduleBuilder).build();
            Date date = scheduler.rescheduleJob(triggerKey, trigger);
            System.out.println("modifyJob -> data " + date);
        }
        return getJobInfo(name,group);
    }

    /**
     * 暂停所有任务
     *
     * @throws SchedulerException
     */
    public void pauseAllJob() throws SchedulerException {
        scheduler.pauseAll();
    }

    /**
     * 暂停某个任务
     *
     * @param name
     * @param group
     * @throws SchedulerException
     */
    public void pauseJob(String name ,String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if(jobDetail == null){
            System.out.println("不存在该任务");
        }
        scheduler.pauseJob(jobKey);
    }

    /**
     * 恢复所有任务
     *
     * @throws SchedulerException
     */
    public void resumeAllJob() throws SchedulerException {
        scheduler.resumeAll();
    }

    /**
     * 恢复某个任务
     *
     * @param name
     * @param group
     * @return
     * @throws SchedulerException
     */
    public String resumeJob(String name ,String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if(jobDetail == null){
            System.out.println("不存在该任务");
        }
        scheduler.resumeJob(jobKey);
        return getJobInfo(name, group);
    }

    /**
     * 删除某个任务
     *
     * @param name
     * @param group
     * @throws SchedulerException
     */
    public void deleteJob(String name,String group) throws SchedulerException {
        JobKey jobKey = new JobKey(name, group);
        JobDetail jobDetail = scheduler.getJobDetail(jobKey);
        if(jobDetail == null){
            System.out.println("不存在该任务");
        }
        scheduler.deleteJob(jobKey);
    }


    private void startJob(Scheduler scheduler) throws SchedulerException {
        // 通过 JobBuilder 构建出 JobDetail 实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体的Job实例
        JobDetail detail = JobBuilder.newJob(SchedulerQuartzJob1.class).withIdentity("job1", "group1").build();

        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");

        // CronTrigger 表达式触发器 继承于 Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job1", "group1")
                .withSchedule(cronScheduleBuilder).build();

        scheduler.scheduleJob(detail,cronTrigger);
    }

    private void startJob2(Scheduler scheduler) throws SchedulerException {
        // 通过 JobBuilder 构建出 JobDetail 实例，JobDetail规定只能是实现Job接口的实例
        // JobDetail 是具体的Job实例
        JobDetail detail = JobBuilder.newJob(SchedulerQuartzJob2.class).withIdentity("job2", "group2").build();

        // 基于表达式构建触发器
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("0/3 * * * * ?");

        // CronTrigger 表达式触发器 继承于 Trigger
        // TriggerBuilder 用于构建触发器实例
        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("job2", "group2")
                .withSchedule(cronScheduleBuilder).build();

        scheduler.scheduleJob(detail,cronTrigger);
    }

}
