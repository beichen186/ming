package com.itheima.ssm.service;

import com.itheima.ssm.domain.Permission;

import java.util.List;

public interface IPermissonService {
    List<Permission> findAll();
    void  save(Permission permission);
}
