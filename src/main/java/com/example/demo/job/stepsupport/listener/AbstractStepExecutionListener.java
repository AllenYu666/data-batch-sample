package com.example.demo.job.stepsupport.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

/**
 * Created by Administrator on 2019/11/27.
 */
public abstract class AbstractStepExecutionListener implements StepExecutionListener {

    private static final Logger log = LoggerFactory.getLogger(AbstractStepExecutionListener.class);

    @Override
    public void beforeStep(StepExecution stepExecution) {
        log.info("Starting execute step, step type: {}", this.stepType());
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        log.info("Finishing execute step, step type: {}", this.stepType());
        return stepExecution.getExitStatus();
    }

    /**
     * explicit step type
     * @return
     */
    protected abstract String stepType();
}
