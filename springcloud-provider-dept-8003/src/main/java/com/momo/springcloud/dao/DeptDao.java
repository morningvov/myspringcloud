package com.momo.springcloud.dao;

import com.momo.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author momo
 * @create 2020-03-01 下午 17:03
 */
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept findById(Long id);

    public List<Dept> findAll();

}

