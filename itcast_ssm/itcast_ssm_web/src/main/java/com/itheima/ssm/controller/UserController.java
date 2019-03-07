package com.itheima.ssm.controller;

import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//访问路径
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv= new ModelAndView();
        List<UserInfo> userList = userService.findAll();
        mv.addObject("userList",userList);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv=new ModelAndView();
        UserInfo user = userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }
    ModelAndView findByIdAndCanAddRole(@RequestParam(name = "id",required = true) String userId){
return null;
    }
}
