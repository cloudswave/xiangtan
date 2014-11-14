package com.xiangtan.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Userinfo_lv;
@WebService
public interface Userinfo_lvService {
	
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 如果登录成功，则返回登录成功的Userinfo_lv对象。否则返回null
	 */
	@WebMethod
	public Userinfo_lv login(String name, String password);
}
