package main.java.schedules;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import main.java.requests.FileDownloader;

@Component
public class RefreshScheduler {

    private static final Logger log = LoggerFactory.getLogger(RefreshScheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    ApplicationContext applicationContext;
    
    @Autowired
    JobLauncher jobLauncher;
    
    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() 
    {
        log.info("The time is now {}", dateFormat.format(new Date()));
        
        Job bean = (Job) applicationContext.getBean("importUserJob");
        
        if(bean == null)
        {
        	log.info("no batch job with name importUserJob found");
        	return;
        }

        new FileDownloader().download("dfds");
        
        log.info("lets see if download blocks");
//        try {
//        	log.info("executing job");
//			//jobLauncher.run(bean, new JobParameters());
//		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
//				| JobParametersInvalidException e) {
//			e.printStackTrace();
//		}
      
       
    }
}