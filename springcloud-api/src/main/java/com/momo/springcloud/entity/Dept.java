package com.momo.springcloud.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * (Dept)实体类
 *
 * @author momo
 * @since 2020-03-01 16:32:26
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)  //链式写法
public class Dept implements Serializable {
    private static final long serialVersionUID = -86340120974150741L;
    
    private Long deptno;
    
    private String dname;

    //这个数据数存在哪个数据库的字段~ 微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

     /*
    链式写法：
       Dept dept =  new Dept();
       dept.setDeptNo(11).setDname('ssss').setDb_source('001');
     */

}