package com.xiangtan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiangtan.service.Userinfo_lvService;

public class Test01 {
public static void main(String[] args) {
	//创建spring IOC容器
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    //从IOC容器中获取bean实例 
    Userinfo_lvService userinfo_lvService = applicationContext.getBean(Userinfo_lvService.class);
    System.out.println(userinfo_lvService.login("admin", "22"));
}
}
