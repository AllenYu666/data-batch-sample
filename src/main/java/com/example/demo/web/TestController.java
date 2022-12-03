package com.example.demo.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.service.JobExecutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 通过http模拟触发job
 */
@RestController
@RequestMapping("/data/batch")
public class TestController {

    @Autowired
    private JobExecutionService jobExecutionService;

    @PostMapping("/startJob")
    public String startJob(@RequestBody String params) {
        JSONObject data = JSON.parseObject(params);
        // 由于job执行是异步的 故此处返回并不是真正的执行结果 具体结果可查看数据库相应的表中的状态
        String result = jobExecutionService.executeJob(data.getString("jobName"));
        return result;
    }


}
