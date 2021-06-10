package com.example.demo.controller;

import com.example.demo.quartz.QuartzScheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartz")
public class QuartzController {

    @Autowired
    private QuartzScheduler quartzScheduler;

    @RequestMapping("/startAll")
    public void startAllJob(){
        try {
            quartzScheduler.startAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/info/{name}/{group}")
    public String info(@PathVariable(value = "name") String name,@PathVariable(value = "group") String group) throws SchedulerException {
        return quartzScheduler.getJobInfo(name, group);
    }

}
