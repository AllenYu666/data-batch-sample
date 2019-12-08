package com.example.demo.job.stepsupport;

import com.alibaba.fastjson.JSON;
import com.example.demo.job.entity.SyncDataDO;
import com.example.demo.job.entity.SyncDataDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2019/11/27.
 */
@StepScope
@Component
public class BarSetpItemProcessor implements ItemProcessor<SyncDataDTO, SyncDataDO> {

    private static final Logger log = LoggerFactory.getLogger(BarSetpItemProcessor.class);

    @Override
    public SyncDataDO process(SyncDataDTO syncDataDTO) throws Exception {

        log.info("Item processor, Input SyncDataDTO: {}", JSON.toJSONString(syncDataDTO));

        // 模拟biz process
        SyncDataDO dataDO = new SyncDataDO();
        dataDO.setNum(syncDataDTO.getNum());
        dataDO.setName(syncDataDTO.getName() + "666666");
        dataDO.setHeight(syncDataDTO.getHeight());

        return dataDO;
    }
}
