package cn.sxt.thread.thread04.others;

import static org.quartz.DateBuilder.evenSecondDateAfterNow;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * quartzѧϰ����
 * @author �ƽ���
 */
public class QuartzTest {

    public void run() throws Exception {
        //1.����Scheduler����
        SchedulerFactory sf = new StdSchedulerFactory();
        //2.�ӹ����л�ȡ������
        Scheduler sched = sf.getScheduler();

        //3.����JobDetail
        JobDetail job = newJob(HelloJob.class).withIdentity("job1", "group1").build();

        //ʱ��
        Date runTime = evenSecondDateAfterNow();

        //4.������
        //Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();
        Trigger trigger = newTrigger().withIdentity("trigger1","group1")
                .startAt(runTime).withSchedule(simpleSchedule().withIntervalInSeconds(5)
                        .withRepeatCount(3)).build();

        //5.ע������ʹ�������
        sched.scheduleJob(job, trigger);

        //����
        sched.start();

        try {
            //500���ֹͣ
            Thread.sleep(500L * 1000L);
            // executing...
        } catch (Exception e) {
            //
        }

    }

    public static void main(String[] args) throws Exception {

        QuartzTest example = new QuartzTest();
        example.run();

    }

}
