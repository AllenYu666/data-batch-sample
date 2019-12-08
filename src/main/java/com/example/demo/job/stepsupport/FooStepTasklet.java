package com.example.demo.job.stepsupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/11/27.
 */
@StepScope
@Component
public class FooStepTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(FooStepTasklet.class);

    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        try {
            log.info("Starting Foo Step Tasklet");
            // biz
            return RepeatStatus.FINISHED;
        } catch (Exception e) {
            throw e;
        }
    }
}
