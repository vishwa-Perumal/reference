package P1;

import org.quartz.CronScheduleBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Cooking implements Job {
	Task1 task1;
	Task2 task2;
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		task1=new Task1();
		task2=new Task2();
		task1.process();
		task2.process();
	}
	
	
	public static void main(String[] args) throws SchedulerException {
//		Cooking cooking= new Cooking();
		
		JobDetail job =JobBuilder.newJob(Cooking.class).withIdentity("j1", "g1").build();
		
		Trigger trigger =TriggerBuilder.newTrigger().withIdentity("t1", "g1")
//		.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5)
//				.repeatForever())
				.withSchedule(CronScheduleBuilder.cronSchedule("0 40 21 * * ?"))
				
				.build();
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.scheduleJob(job, trigger);
		scheduler.start();
		
		
		
		
	}

}
