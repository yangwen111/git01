package com.example.srv.servie.impl;

import com.example.srv.bo.User;
import com.example.srv.bo.UserExample;
import com.example.srv.dao.UserMapper;
import com.example.srv.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author
 * @DATE 2022/6/24 -16:21
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUser(User user) {
        String name=user.getUsername();
        String passWord=user.getPassword();
        UserExample example=new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(name);
        criteria.andPasswordEqualTo(passWord);
        List<User> users = userMapper.selectByExample(example);
        if(users==null||users.size()==0) {
            return null;
        }
        return users.get(0);
    }
}
