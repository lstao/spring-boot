package com.liu.cloud.movie.web;

import com.liu.cloud.movie.feign.UserFeignClient;
import com.liu.cloud.user.domain.User;
import com.liu.cloud.user.dto.UserDto;
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

    @GetMapping("/{id}/detail")
    public UserDto findById(@PathVariable String id) {
        return this.userFeignClient.findById(id);
    }

    @GetMapping("/test")
    public UserDto testPost(User user) {
        return this.userFeignClient.postUser(user);
    }

    @GetMapping("/test-get")
    public UserDto testGet(User user) {
        return this.userFeignClient.getUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> testList() {
        return this.userFeignClient.getAllUser();
    }


}
