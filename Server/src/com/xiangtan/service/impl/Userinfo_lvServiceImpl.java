package com.xiangtan.service.impl;

import java.util.List;

import com.xiangtan.beans.Userinfo_lv;
import com.xiangtan.dao.Userinfo_lvDao;
import com.xiangtan.service.Userinfo_lvService;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Userinfo_lvServiceImpl implements Userinfo_lvService {

	private static Userinfo_lvDao userinfo_lvDao;

	public void setUserinfo_lvDao(Userinfo_lvDao userinfo_lvDao) {
		Userinfo_lvServiceImpl.userinfo_lvDao = userinfo_lvDao;
	}

	@Override
	public Userinfo_lv login(String name, String password) {
		if (name == null || password == null || name.equals("")
				|| password.equals("")) {
			return null;
		}
		System.out.println(name + "~~~" + password);
		return userinfo_lvDao.get(name, password);
	}

	@Override
	public Userinfo_lv user_add(String name, String password, int role,
			int groupid) {
		if (name.length() == 0 || password.length() == 0) {
			System.err.println("用户名密码不可为空");
			return null;
		}
		if (userinfo_lvDao.get(name) != null) {// name不允许重复
			System.err.println("name不允许重复");
			return null;
		}
		return userinfo_lvDao.add(name, password, role, groupid);
	}

	@Override
	public Userinfo_lv getUserinfo_lv(int id) {
		return userinfo_lvDao.get(id);
	}

	@Override
	public Userinfo_lv getUserinfo_lvByName(String name) {
		return userinfo_lvDao.get(name);
	}

	@Override
	public List<Userinfo_lv> getUserinfo_lvsByRole(int role) {
		return userinfo_lvDao.getByRole(role);
	}

	@Override
	public List<Userinfo_lv> getUserinfo_lvsByGroupid(int groupid) {
		return userinfo_lvDao.getByGroupid(groupid);
	}

	@Override
	public boolean deleteUserinfo_lv(int id) {
		return userinfo_lvDao.delete(id);
	}

}
