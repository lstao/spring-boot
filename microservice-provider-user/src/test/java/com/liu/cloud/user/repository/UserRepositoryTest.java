package com.liu.cloud.user.repository;

import com.liu.cloud.user.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@MapperScan("com.liu.cloud.user.repository")
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void testGetAllUser(){
        List<User> list = userRepository.getAllUser();
        list.stream().forEach(System.out::println);
    }

    @Test
    public void testGetOne()
    {
        System.out.println(userRepository.getUserById("2996469934780530164"));
    }

    
}