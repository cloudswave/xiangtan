package com.xiangtan.service.impl;
import com.xiangtan.beans.Userinfo_lv;
import com.xiangtan.dao.Userinfo_lvDao;
import com.xiangtan.service.Userinfo_lvService;

public class Userinfo_lvServiceImpl implements Userinfo_lvService{

	private static Userinfo_lvDao userinfo_lvDao;
	
	public void setUserinfo_lvDao(Userinfo_lvDao userinfo_lvDao) {
		Userinfo_lvServiceImpl.userinfo_lvDao = userinfo_lvDao;
	}
	
	@Override
	public Userinfo_lv login(String name, String password) {
		//如果用户名或者密码为空则直接返回null登录失败
		if (name == null || password == null || name.equals("") || password.equals("")) {
			return null;
		}
		return userinfo_lvDao.login(name, password);
	}



}
