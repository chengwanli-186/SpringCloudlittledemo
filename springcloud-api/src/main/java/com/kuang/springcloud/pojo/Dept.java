package com.kuang.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;



//所有实体类务必实现序列化
@Data
@NoArgsConstructor
@Accessors(chain = true)  //链式写法注解
public class Dept implements Serializable {  //Dept为实体类。orm（对象关系映射）。类表关系映射。mysql实体类表-dept实体类

    private Long deptno;

    private String dname;

     //下面这个字段的作用是来显示  这个数据是存在哪个数据库中的字段~微服务，一个服务对应一个数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }







    /**
     * 链式写法
     *     原始写法：Dept dept = new Dept()
     *              dept.setDeptNo(11);接着写下一个set
     *              dept.setDeptNo(12);.........
     * 链式写法：
     *         Dept dept = new Dept()
     *         dept.setDeptNo(11).setDeptNo('ccc').......
     * */



}
