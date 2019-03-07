package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RequestMapping("/role")
@Controller
public class RoleController {
    @Autowired
    private IRoleService roleService;
    @RequestMapping("/findAll.do")
    ModelAndView findAll(){
        List<Role> roleList = roleService.findAll();
        ModelAndView mv=new ModelAndView();
        mv.addObject("roleList",roleList);
        System.out.println("执行了");
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/save.do")
    String save(Role role){
      roleService.save(role);
      return "redirect:findAll.do";
    }
    @RequestMapping("/findById")
    ModelAndView findById(String id){
        ModelAndView mv=new ModelAndView();
        Role role = roleService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
}
