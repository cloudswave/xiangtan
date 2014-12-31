package com.xiangtan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiangtan.service.Userinfo_lvService;

public class Test01 {
public static void main(String[] args) {
	//����spring IOC����
    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
    //��IOC�����л�ȡbeanʵ�� 
    Userinfo_lvService userinfo_lvService = applicationContext.getBean(Userinfo_lvService.class);
    System.out.println(userinfo_lvService.login("admin", "22"));
}
}
