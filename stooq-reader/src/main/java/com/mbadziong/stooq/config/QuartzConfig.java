package com.mbadziong.stooq.config;

import com.mbadziong.stooq.stooq.StooqDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public StooqDataService stooqDataService() {
        return new StooqDataService();
    }

    @Bean
    public MethodInvokingJobDetailFactoryBean stooqJob() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetObject(stooqDataService());
        bean.setTargetMethod("run");
        bean.setConcurrent(false);

        return bean;
    }
}
