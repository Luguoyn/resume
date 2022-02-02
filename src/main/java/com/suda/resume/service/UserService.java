package com.suda.resume.service;

import com.suda.resume.mapper.UserMapper;
import com.suda.resume.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper mapper;

    public User getUserByName(String username){
        return mapper.getUserByName(username);
    }

    public int updatePassword(User user, String newPassword){
        user.setPassword(newPassword);

        return mapper.update(user);

    }
}
