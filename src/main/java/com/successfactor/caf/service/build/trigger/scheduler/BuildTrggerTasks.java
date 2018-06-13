package com.successfactor.caf.service.build.trigger.scheduler;

import com.successfactor.caf.service.build.trigger.jobs.StreetPatrol;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BuildTrggerTasks {

    private static final Logger log = LoggerFactory.getLogger(BuildTrggerTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

//    @Scheduled(fixedRate = 5000)
//    @Scheduled(fixedDelay = 5000)
//    @Scheduled(cron="*/10 * * * * *")   //every ten seconds
//    @Scheduled(cron="*/10 * * * *")     //every ten minutes
    @Scheduled(cron = "${scheduler.cron.expression}")     //read from properties.
    public void reportCurrentTime() {

        log.info("\n");
        log.info("=============================================");
        log.info("Current time {}, scheduler on build status...", dateFormat.format(new Date()));
        StreetPatrol.getInstance().doThem();

    }
}
