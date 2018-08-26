package com.liu.cloud.movie.feign;

import com.liu.cloud.config.Configurational;
import com.liu.cloud.user.domain.User;
import com.liu.cloud.user.dto.UserDto;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.security.auth.login.Configuration;
import java.util.List;

@FeignClient(name="microservice-provider-user",configuration = Configurational.class)
public interface UserFeignClient {
  @RequestLine("GET /user/{id}/detail")
  UserDto findById(@Param("id") String id); // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value


}
