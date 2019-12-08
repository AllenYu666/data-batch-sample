package com.example.demo.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/11/27.
 */
@Component
public class SyncDataJobListener implements JobExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(SyncDataJobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        log.info("Starting job, job name: {} and instanceId: {}",
                jobExecution.getJobInstance().getJobName(),
                jobExecution.getJobInstance().getInstanceId());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        log.info("Finishing job, job name: {} and instanceId: {}",
                jobExecution.getJobInstance().getJobName(),
                jobExecution.getJobInstance().getInstanceId());
    }
}
