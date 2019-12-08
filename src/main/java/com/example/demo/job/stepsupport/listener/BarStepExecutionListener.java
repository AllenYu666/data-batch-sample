package com.example.demo.job.stepsupport.listener;

/**
 * Created by Administrator on 2019/11/27.
 */
public class BarStepExecutionListener extends AbstractStepExecutionListener {

    public static final BarStepExecutionListener INSTANCE = new BarStepExecutionListener();

    @Override
    protected String stepType() {
        return "BarStep";
    }
}
