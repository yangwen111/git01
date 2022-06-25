package com.example.srv.controller;

import com.example.srv.bo.User;
import com.example.srv.controller.params.BaseRes;
import com.example.srv.servie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
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
        if(user1!=null){
            String secret="abcdef";
        String token = JWT.create().
                withClaim("username", user1.getUsername())
                .sign(Algorithm.HMAC256(secret));
            user1.setToken(token);
        }
        BaseRes baseRes=new BaseRes();
        baseRes.setResult(user1);
        return baseRes;
    }
}
