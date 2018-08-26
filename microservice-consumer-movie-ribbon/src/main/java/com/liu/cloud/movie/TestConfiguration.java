package com.liu.cloud.movie;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
 /**
  *
 * 自定义的注解实现延迟加载，如果在启动时加载会出问题
  * ComponentScan 会加载，导致冲突，解决的方法就是TestConfiguration不能被springboot主程序扫描到（即不在其同级或子目录下）
 */
@ExcludeFromComponentScan
public class TestConfiguration {
//    @Autowired
//    IClientConfig config;

//    @Bean
//    public IRule ribbonRule(IClientConfig config){
//        return new RandomRule();
//    }

    /**
     * 负载均衡规则
     * @return
     */
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}
