package com.liu.cloud.movie.web;

import com.liu.cloud.movie.feign.FeignClient2;
import com.liu.cloud.movie.feign.UserFeignClient;
import com.liu.cloud.user.domain.User;
import com.liu.cloud.user.dto.UserDto;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private FeignClient2 feignClient2;

    @GetMapping("/{id}/detail")
    public UserDto findById(@PathVariable String id) {
        return this.userFeignClient.findById(id);
    }

    @RequestMapping("/{serviceName}")
    public String findServiceInfo(@PathVariable("serviceName") String serviceName){
        return feignClient2.findServiceInfo(serviceName);
    }

}
