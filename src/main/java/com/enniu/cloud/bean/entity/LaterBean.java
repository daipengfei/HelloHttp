package com.enniu.cloud.bean.entity;

import javax.annotation.PostConstruct;

/*********************************
 *                               *
 Created by daipengfei on 16/10/13.
 *                               *
 ********************************/

public class LaterBean {

    @PostConstruct
    public void init(){
        System.out.println("later bean init!");
    }

}
