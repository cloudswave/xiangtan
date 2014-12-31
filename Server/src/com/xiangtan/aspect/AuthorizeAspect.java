package com.xiangtan.aspect;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

import com.xiangtan.exception.IllegalRequestException;
import com.xiangtan.utils.AuthorizeUtil;


public class AuthorizeAspect {

	public void beforeMethod(JoinPoint joinpoint) {
//		System.out.println("beforeMethod");
        String methodName = joinpoint.getSignature().getName();
        List<Object>args = Arrays.asList(joinpoint.getArgs());
        System.out.println("前置通知：The method "+ methodName +" begins with " + args + ",参数个数：" + args.size());
//        System.out.println(args.get(0).getClass().getName());
        System.out.println("key:" + args.get(args.size() - 1));
//        最后一个参数是key
        if (!AuthorizeUtil.requestAuthorize(args.get(args.size() - 1).toString())) {
        	throw new IllegalRequestException("非法请求");
		}
    }
	
	public void afterMethod(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        //List<Object>args = Arrays.asList(joinpoint.getArgs());  后置通知方法中可以获取到参数
        System.out.println("后置通知：The method "+ methodName +" ends ");
    }
}
