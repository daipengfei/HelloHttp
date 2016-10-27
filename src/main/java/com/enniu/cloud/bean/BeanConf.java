package com.enniu.cloud.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.enniu.cloud.bean.entity.BeanChild;
import com.enniu.cloud.bean.entity.BeanParent;

/*********************************
 *                               *
 Created by daipengfei on 16/10/13.
 *                               *
 ********************************/
@Configuration
public class BeanConf {

    @Bean(initMethod = "initMethod")
    BeanParent beanParent(){
        System.out.println("init beanParent");
        return new BeanParent();
    }

    @Bean(name = "child")
    BeanChild beanChild(){
        System.out.println("init beanChild");
        return new BeanChild();
    }


    @Bean(name = "child1")
    BeanChild child1(){
        System.out.println("init beanChild1");
        return new BeanChild();
    }
}
