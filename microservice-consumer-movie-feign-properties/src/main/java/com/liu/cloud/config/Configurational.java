package com.liu.cloud.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configurational {
    @Bean
    public Contract feginContract(){
        return  new feign.Contract.Default();
    }

    /**
     *配置日志（application.yml）貌似不管用
     */
    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
