package com.example.demo.job.stepsupport;

import com.alibaba.fastjson.JSON;
import com.example.demo.job.entity.SyncDataDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Administrator on 2019/11/27.
 */
@StepScope
@Component
public class BarSetpItemWriter implements ItemWriter<SyncDataDO> {

    private static final Logger log = LoggerFactory.getLogger(BarSetpItemWriter.class);

    @Override
    public void write(List<? extends SyncDataDO> list) throws Exception {

        // 模拟writer
        log.info("***********************************");
        log.info("Bar Step Item Writer: {}", JSON.toJSONString(list));

    }
}
