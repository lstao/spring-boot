package com.liu.cloud.movie.feign;

import com.liu.cloud.config.AuthConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 如果没有设置url，但是与eureka连用，那么取的就是eureka的application名称
 * 否者name只是url对应的一个名字
 */
@FeignClient(name="xxx",url="http://localhost:8761/",configuration = AuthConfiguration.class)
public interface FeignClient2 {
    @RequestMapping("/eureka/apps/{serviceName}")
    String findServiceInfo(@PathVariable("serviceName")String serviceName);
}
