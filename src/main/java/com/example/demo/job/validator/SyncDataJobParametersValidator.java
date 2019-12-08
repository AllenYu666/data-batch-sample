package com.example.demo.job.validator;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;
import org.springframework.lang.Nullable;

/**
 * Created by Administrator on 2019/11/27.
 */
public class SyncDataJobParametersValidator implements JobParametersValidator {

    public static final SyncDataJobParametersValidator INSTANCE = new SyncDataJobParametersValidator();

    private static final Logger log = LoggerFactory.getLogger(SyncDataJobParametersValidator.class);

    private SyncDataJobParametersValidator() {

    }

    @Override
    public void validate(@Nullable JobParameters jobParameters) throws JobParametersInvalidException {
        log.info("Sync Data job parameters: {}", JSON.toJSONString(jobParameters.getParameters()));
    }
}
