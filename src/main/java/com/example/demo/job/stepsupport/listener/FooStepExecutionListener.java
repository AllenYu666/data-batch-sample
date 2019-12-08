package com.example.demo.job.stepsupport.listener;

/**
 * Created by Administrator on 2019/11/27.
 */
public class FooStepExecutionListener extends AbstractStepExecutionListener {

    public static final FooStepExecutionListener INSTANCE = new FooStepExecutionListener();

    @Override
    protected String stepType() {
        return "FooStep";
    }
}
