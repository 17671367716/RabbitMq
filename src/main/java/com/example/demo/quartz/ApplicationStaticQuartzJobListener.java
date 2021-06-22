package com.example.demo.quartz;

/**
 * 项目启动时，启动 quartz
 */

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationStaticQuartzJobListener implements ApplicationListener {

    @Autowired
    private Scheduler quartzScheduler;

    /**
     * 初始启动quartz
     * @param event
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
//        try {
//            quartzScheduler.startAllJob();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
    }

    @Bean
    public Scheduler scheduler() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        return schedulerFactory.getScheduler();
    }
}
