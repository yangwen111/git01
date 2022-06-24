package com.example.srv.controller;

import com.example.srv.bo.User;
import com.example.srv.controller.params.BaseRes;
import com.example.srv.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @DATE 2022/6/24 -16:28
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/login")
    public BaseRes<User> login(@RequestBody User user){
        User user1=userService.getUser(user);
        BaseRes baseRes=new BaseRes();
        baseRes.setResult(user1);
        return baseRes;
    }
}
