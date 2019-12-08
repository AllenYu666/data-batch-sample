package com.example.demo;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class DataBatchSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataBatchSampleApplication.class, args);
	}

}
