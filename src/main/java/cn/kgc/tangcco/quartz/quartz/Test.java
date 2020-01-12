package cn.kgc.tangcco.quartz.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.impl.triggers.SimpleTriggerImpl;

import java.text.ParseException;
import java.util.Date;

/**
 * @program: quartz
 * @description: TODO
 * @author: cuihao
 * @create: 2020-01-12 20:30
 * @version: V1.0
 **/
public class Test {
    public static void main(String[] args) throws SchedulerException, ParseException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class).withIdentity("myJob").build();
       /* SimpleTriggerImpl simpleTrigger = new SimpleTriggerImpl("aaa");
        simpleTrigger.setStartTime(new Date(System.currentTimeMillis()+2000));
        simpleTrigger.setEndTime(new Date(System.currentTimeMillis()+20000));*/
        CronTriggerImpl cronTrigger = new CronTriggerImpl("t2","aaa","0 0/1 * * * ?");
        StdSchedulerFactory factory = new StdSchedulerFactory();
        Scheduler scheduler = factory.getScheduler();
        scheduler.scheduleJob(jobDetail, cronTrigger);
        scheduler.start();
    }
}
