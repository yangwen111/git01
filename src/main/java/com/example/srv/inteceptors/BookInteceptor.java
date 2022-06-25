package com.example.srv.inteceptors;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author
 * @DATE 2022/6/21 -16:59
 */
public class BookInteceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("开始拦截请求");
        String token = request.getHeader("token");
        if(ObjectUtils.isEmpty(token)){
            return false;
        }
//      拿到token后与共有缓存对比
        DecodedJWT decode = JWT.decode(token);
        String username = decode.getClaim("username").toString();
        if(username==null){
            return false;
        }
        return true;
    }
}
