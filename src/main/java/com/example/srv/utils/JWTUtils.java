package com.example.srv.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
@author
@DATE 2022/6/25 -21:40
*/public class JWTUtils {
    public static void main(String[] args) {
//        String secret="abcdef";
//        String sign = JWT.create().
//                withClaim("username", "admin")
//                .sign(Algorithm.HMAC256(secret));
//        System.out.println(sign);
        String json="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFkbWluIn0.AwXJiXuMoJodNCq3EslfV6wVrwLIFFcaFqsAsWfITQg";
        DecodedJWT decode = JWT.decode(json);
        String username = decode.getClaim("username").asString();
        System.out.println(username);

    }
}
