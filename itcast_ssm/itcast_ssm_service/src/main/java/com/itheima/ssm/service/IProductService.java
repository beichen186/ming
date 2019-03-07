package com.itheima.ssm.service;

import com.itheima.ssm.domain.Product;
import org.springframework.core.annotation.Order;

import java.util.List;

public interface IProductService {

    public List<Product> findAll(int page,int size) throws Exception;

    void save(Product product) throws Exception;
}
