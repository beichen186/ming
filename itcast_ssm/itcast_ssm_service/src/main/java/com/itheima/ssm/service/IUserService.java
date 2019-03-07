package com.itheima.ssm.service;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

//继承userDetailsService
public interface IUserService extends UserDetailsService {
    public UserDetails loadUserByUsername(String username);
    public List<UserInfo> findAll();
    public void save(UserInfo userInfo);
    public UserInfo findById(String id);
    List<Role> findOtherRoles(String userId);
}
