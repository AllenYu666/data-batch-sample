package com.example.demo.service;

/**
 * 提供操作job的service（job start/job restart/job stop）
 */
public interface JobExecutionService {

    String executeJob(String jobName);
}
