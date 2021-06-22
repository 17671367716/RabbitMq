package com.example.demo.controller;

import com.example.demo.quartz.QuartzSchedulerConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;

import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quartz")
@Api
public class QuartzController {

    @Autowired
    private QuartzSchedulerConfig quartzScheduler;

    @ApiOperation(value = "开始所有任务")
    @RequestMapping("/startAll")
    public void startAllJob(){
        try {
            quartzScheduler.startAllJob();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation(value = "查看指定任务信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name" ,value = "名称"),
            @ApiImplicitParam(name = "group", value = "group")
    })
    @GetMapping("/info/{name}/{group}")
    public String info(
            @PathVariable(value = "name") String name,
            @PathVariable(value = "group") String group) throws SchedulerException {
        return quartzScheduler.getJobInfo(name, group);
    }

}
