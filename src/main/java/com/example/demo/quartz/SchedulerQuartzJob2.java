package com.example.demo.quartz;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SchedulerQuartzJob2 implements Job {
    private void before(){
        System.out.println("任务开始执行");
    }

    private void after(){
        System.out.println("任务结束执行");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        before();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        JobDetail jobDetail = context.getJobDetail();
        System.out.println("开始" + sdf.format(new Date()));
        System.out.println("job2");
        System.out.println("结束" + sdf.format(new Date()));
        after();
    }
}
