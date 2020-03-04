package com.momo.springcloud.service;

import com.momo.springcloud.entity.Dept;

import java.util.List;

/**
 * @author momo
 * @create 2020-03-01 下午 17:14
 */
public interface DeptService
{
    public boolean add(Dept dept);
    public Dept get(Long id);
    public List<Dept> list();
}
