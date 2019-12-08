package com.example.demo.job.stepsupport;

import com.example.demo.job.entity.SyncDataDTO;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;
import org.springframework.util.comparator.BooleanComparator;

/**
 * Created by Administrator on 2019/11/27.
 */
@StepScope
@Component
public class BarSetpItemReader implements ItemReader<SyncDataDTO> {

    /**
     * 每次运行只读一次
     */
    private Boolean oneChunkSwitch;

    public BarSetpItemReader() {
        this.oneChunkSwitch = true;
    }

    @Override
    public SyncDataDTO read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (this.oneChunkSwitch) {
            // 模拟read
            SyncDataDTO dataDTO = new SyncDataDTO();
            dataDTO.setNum(1111);
            dataDTO.setName("Jack Ma");
            dataDTO.setHeight(170F);

            oneChunkSwitch = false;
            return dataDTO;
        }

        return null;
    }
}
