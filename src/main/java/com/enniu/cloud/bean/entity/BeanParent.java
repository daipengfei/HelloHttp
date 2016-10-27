package com.enniu.cloud.bean.entity;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.InitializingBean;

/*********************************
 *                               *
 Created by daipengfei on 16/10/13.
 *                               *
 ********************************/

public class BeanParent implements InitializingBean{
    @PostConstruct
    public void init(){
        System.out.println("parent bean init!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializing parentBean!!!");
    }

    public void initMethod(){
        System.out.println("this is initMethod!");
    }

}
