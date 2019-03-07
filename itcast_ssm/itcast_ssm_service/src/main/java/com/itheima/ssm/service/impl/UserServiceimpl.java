package com.itheima.ssm.service.impl;

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import com.itheima.ssm.utils.BCryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Service("userService")
@Transactional
public class UserServiceimpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserInfo userInfo=null;
        //处理自己的用户对象封装成UserDetails
        //密码不加密式要加"{noop}"
       userInfo = userDao.findByUsername(username);
        System.out.println(userInfo.getPassword());
        User user = new User(userInfo.getUsername(),  userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true,getAuthority(userInfo.getRoles()));
     return user;
    }

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        String password = (String)BCryptPasswordEncoderUtils.encodePassword(userInfo.getPassword());
        userInfo.setPassword(password);
        System.out.println(password);
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(String id) {
      return   userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(String userId) {
        return null;
    }

    //作用就是放回一个list集合,集合中装入的是角色描述
  public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
      for (Role role : roles) {
          list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
      }
      return list;
  }
}