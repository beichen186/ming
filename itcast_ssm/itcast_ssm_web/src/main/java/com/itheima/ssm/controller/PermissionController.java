package com.itheima.ssm.controller;

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissonService permissonService;
    @RequestMapping("/findAll.do")
    ModelAndView findAll(){
        System.out.println("执行了");
        ModelAndView mv=new ModelAndView();
        List<Permission> permissionList = permissonService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }
    @RequestMapping("save.do")
    String save(Permission permission){
          permissonService.save(permission);
          return "forward:findAll.do";

    };
}
