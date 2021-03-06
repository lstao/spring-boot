package com.liu.cloud.movie.feign;

import com.liu.cloud.user.domain.User;
import com.liu.cloud.user.dto.UserDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient("microservice-provider-user")
public interface UserFeignClient {
  @RequestMapping(value = "/user/{id}/detail", method = RequestMethod.GET)
  public UserDto findById(@PathVariable("id") String id); // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public UserDto postUser(@RequestBody User user);

  // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。可能是我没找到相应的注解或使用方法错误。
  // 如勘误，请@lilizhou2008  eacdy0000@126.com
  @RequestMapping(value = "/get-user", method = RequestMethod.GET)
  public UserDto getUser(User user);

  @RequestMapping(value="/user/getAllUser")
  public List<User> getAllUser();
}
