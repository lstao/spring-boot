package com.liu.cloud.user.repository;

import com.liu.cloud.user.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface UserRepository {
     List<User> getAllUser();

     User getUserById(@Param("id") String id);
}
