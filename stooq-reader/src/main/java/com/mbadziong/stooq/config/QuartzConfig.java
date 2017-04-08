package com.mbadziong.stooq.config;

import com.mbadziong.stooq.quartz.StooqTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public StooqTask stooqTask() {
        return new StooqTask();
    }

    @Bean
    public MethodInvokingJobDetailFactoryBean stooqJob() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetObject(stooqTask());
        bean.setTargetMethod("run");
        bean.setConcurrent(false);

        return bean;
    }
}
