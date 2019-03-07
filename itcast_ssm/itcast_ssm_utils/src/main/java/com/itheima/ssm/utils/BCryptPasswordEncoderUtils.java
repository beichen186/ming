package com.itheima.ssm.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
       return passwordEncoder.encode(password);
    }
}
