package com.xiangtan.service.impl;

import java.util.List;

import com.xiangtan.beans.Userinfo_lv;
import com.xiangtan.dao.Role_user_mapDao;
import com.xiangtan.dao.Userinfo_lvDao;
import com.xiangtan.service.Userinfo_lvService;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Userinfo_lvServiceImpl implements Userinfo_lvService {

	private static Userinfo_lvDao userinfo_lvDao;
	private static Role_user_mapDao role_user_mapDao;
	
	public void setUserinfo_lvDao(Userinfo_lvDao userinfo_lvDao) {
		Userinfo_lvServiceImpl.userinfo_lvDao = userinfo_lvDao;
	}
	
	public static void setRole_user_mapDao(Role_user_mapDao role_user_mapDao) {
		Userinfo_lvServiceImpl.role_user_mapDao = role_user_mapDao;
	}

	@Override
	public Userinfo_lv login(String name, String password) {
		if (name == null || password == null || name.equals("")
				|| password.equals("")) {
			return null;
		}
		System.out.println(name  + "~~~");
		return userinfo_lvDao.get(name, password);
	}

	@Override
	public Userinfo_lv add(String name, String password, String email, String tel, String truename, String department, String note, String roleIds) {
		if (name.length() == 0 || password.length() == 0) {
			System.err.println("用户名密码不可为空");
			return null;
		}
		if (userinfo_lvDao.get(name) != null) {// name不允许重复
			System.err.println("name不允许重复");
			return null;
		}
		System.out.println("roleIds:"+roleIds);
		Userinfo_lv userinfo_lv = userinfo_lvDao.add(name, password, email, tel, truename, department, note);
		if (userinfo_lv != null) {
			System.out.println("添加成功，" + userinfo_lv);
			
			role_user_mapDao.add(userinfo_lv.getId(), roleIds);
		}
		return userinfo_lv;
	}

	@Override
	public Userinfo_lv getUserinfo_lv(int id) {
		return userinfo_lvDao.get(id);
	}

	@Override
	public Userinfo_lv getUserinfo_lvByName(String name) {
		return userinfo_lvDao.get(name);
	}

	/*
	@Override
	public List<Userinfo_lv> getUserinfo_lvsByRole(int role) {
		return userinfo_lvDao.getByRole(role);
	}
	*/

	@Override
	public List<Userinfo_lv> getUserinfo_lvsByGroupid(int groupid) {
		return userinfo_lvDao.getByGroupid(groupid);
	}

	@Override
	public boolean deleteUserinfo_lv(int id) {
		return userinfo_lvDao.delete(id);
	}

	@Override
	public List<Userinfo_lv> getAll() {
		System.out.println("public List<Userinfo_lv> getAll() 被调用");
		return userinfo_lvDao.getAll();
	}

}
