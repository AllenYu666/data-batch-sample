package com.example.demo.service.impl;

import com.example.demo.service.JobExecutionService;
import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/11/26.
 */
@Service
public class JobExecutionServiceImpl implements JobExecutionService {

    private JobLauncher jobLauncher;

    private JobRegistry jobRegistry;

    private JobOperator jobOperator;

    @Autowired
    public JobExecutionServiceImpl(JobLauncher jobLauncher, JobRegistry jobRegistry, JobOperator jobOperator) {
        this.jobLauncher = jobLauncher;
        this.jobRegistry = jobRegistry;
        this.jobOperator = jobOperator;
    }



    @Override
    public String executeJob(String jobName) {
        try {
            Job job = this.jobRegistry.getJob(jobName);
            JobExecution jobExecution = this.jobLauncher.run(job, this.buildJobParameters());
            return jobExecution.getStatus().toString();
        } catch (NoSuchJobException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Keep the parameters changing if you run it multiple times
     * @return
     */
    private JobParameters buildJobParameters() {
        return new JobParametersBuilder()
                .addString("aaa2", "123")
                .addString("bbb2", "666")
                .toJobParameters();
    }
}
