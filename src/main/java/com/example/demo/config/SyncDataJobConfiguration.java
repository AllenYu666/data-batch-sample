package com.example.demo.config;

import com.example.demo.job.SyncDataJobListener;
import com.example.demo.job.entity.SyncDataDO;
import com.example.demo.job.entity.SyncDataDTO;
import com.example.demo.job.stepsupport.BarSetpItemProcessor;
import com.example.demo.job.stepsupport.BarSetpItemReader;
import com.example.demo.job.stepsupport.BarSetpItemWriter;
import com.example.demo.job.stepsupport.FooStepTasklet;
import com.example.demo.job.stepsupport.listener.BarStepExecutionListener;
import com.example.demo.job.stepsupport.listener.FooStepExecutionListener;
import com.example.demo.job.validator.SyncDataJobParametersValidator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2019/11/26.
 */
@Configuration
public class SyncDataJobConfiguration {

    private static final String FOO_STEP = "fooStep";

    private static final String BAR_STEP = "barStep";

    private JobBuilderFactory jobBuilderFactory;

    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    public SyncDataJobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }


    @Bean("syncDataJob")
    public Job syncDataJob(@Qualifier(FOO_STEP) Step fooStep,
                           @Qualifier(BAR_STEP) Step barStep,
                           SyncDataJobListener listener) {
        return jobBuilderFactory.get("syncDataJob")
                .start(fooStep)
                .next(barStep)
                .listener(listener)
                .validator(SyncDataJobParametersValidator.INSTANCE)
                .build();
    }


    @JobScope
    @Bean(FOO_STEP)
    public Step fooStep(FooStepTasklet tasklet) {
        return stepBuilderFactory.get(FOO_STEP)
                .tasklet(tasklet)
                .allowStartIfComplete(true)
                .listener(FooStepExecutionListener.INSTANCE)
                .build();
    }

    @JobScope
    @Bean(BAR_STEP)
    public Step barStep(BarSetpItemReader reader,
                        BarSetpItemProcessor processor,
                        BarSetpItemWriter writer) {
        return stepBuilderFactory.get(BAR_STEP)
                .<SyncDataDTO, SyncDataDO>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .listener(BarStepExecutionListener.INSTANCE)
                .build();
    }
}
