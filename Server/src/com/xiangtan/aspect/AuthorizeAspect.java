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
        System.out.println("ǰ��֪ͨ��The method "+ methodName +" begins with " + args + ",����������" + args.size());
//        System.out.println(args.get(0).getClass().getName());
        System.out.println("key:" + args.get(args.size() - 1));
//        ���һ��������key
        if (!AuthorizeUtil.requestAuthorize(args.get(args.size() - 1).toString())) {
        	throw new IllegalRequestException("�Ƿ�����");
		}
    }
	
	public void afterMethod(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        //List<Object>args = Arrays.asList(joinpoint.getArgs());  ����֪ͨ�����п��Ի�ȡ������
        System.out.println("����֪ͨ��The method "+ methodName +" ends ");
    }
}
