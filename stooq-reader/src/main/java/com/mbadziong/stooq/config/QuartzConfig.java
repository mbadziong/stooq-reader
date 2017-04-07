package com.mbadziong.stooq.config;

import com.mbadziong.stooq.http.StooqDataService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    @Bean
    public StooqDataService stooqDataService() {
        return new StooqDataService();
    }

    @Bean
    public MethodInvokingJobDetailFactoryBean myQuartzJob() {
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetObject(stooqDataService());
        bean.setTargetMethod("run");
        bean.setConcurrent(false);

        return bean;
    }

    @Bean
    public CronTriggerFactoryBean myPrintTrigger() {
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(myQuartzJob().getObject());
        bean.setCronExpression("*/10 * * * * ?");
        return bean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean() {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(myPrintTrigger().getObject());

        return schedulerFactoryBean;
    }
}
