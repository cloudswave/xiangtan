package com.xiangtan.ws.impl;

import java.util.List;

import javax.jws.WebService;

import com.xiangtan.beans.Userinfo_lv;
import com.xiangtan.service.Userinfo_lvService;
import com.xiangtan.ws.Userinfo_lvWS;
public class Userinfo_lvWSImpl implements Userinfo_lvWS{

	private static Userinfo_lvService userinfo_lvService;
	public void setUserinfo_lvService(Userinfo_lvService userinfo_lvService) {
		System.out.println("set");
		Userinfo_lvWSImpl.userinfo_lvService = userinfo_lvService;
	}
	@Override
	public Userinfo_lv login(String name, String password) {
		System.out.println(userinfo_lvService);
//		userinfo_lvService.login(name, password);
//		System.out.println(name + "--" + password);
		return userinfo_lvService.login(name, password);
	}

	@Override
	public Userinfo_lv add(String name, String password, String email,
			String tel, String truename, String department, String note,
			String roleIds, String key) {
		// TODO Auto-generated method stub
		return userinfo_lvService.add(name, password, email, tel, truename, department, note, roleIds, key);
	}

	@Override
	public Userinfo_lv getUserinfo_lv(int id, String key) {
		// TODO Auto-generated method stub
		return userinfo_lvService.getUserinfo_lv(id, key);
	}

	@Override
	public Userinfo_lv update(int id, String name, String password,
			String email, String tel, String truename, String department,
			String note, String roleIds, String key) {
		// TODO Auto-generated method stub
		return userinfo_lvService.update(id, name, password, email, tel, truename, department, note, roleIds, key);
	}

	@Override
	public Userinfo_lv getUserinfo_lvByName(String name, String key) {
		// TODO Auto-generated method stub
		return userinfo_lvService.getUserinfo_lvByName(name, key);
	}

	@Override
	public List<Userinfo_lv> getUserinfo_lvsLikeSth(String name,
			String department, String truename, String key) {
		// TODO Auto-generated method stub
		return userinfo_lvService.getUserinfo_lvsLikeSth(name, department, truename, key);
	}

	@Override
	public List<Userinfo_lv> getUserinfo_lvsByGroupid(int groupid, String key) {
		// TODO Auto-generated method stub
		return userinfo_lvService.getUserinfo_lvsByGroupid(groupid, key);
	}

	@Override
	public boolean deleteUserinfo_lv(int id, String key) {
		// TODO Auto-generated method stub
		return userinfo_lvService.deleteUserinfo_lv(id, key);
	}

	@Override
	public List<Userinfo_lv> getAll(String key) {
		// TODO Auto-generated method stub
		return userinfo_lvService.getAll(key);
	}

	@Override
	public List<Userinfo_lv> getUsersByPager(int pageSize, int currentPage,
			String key) {
		// TODO Auto-generated method stub
		return userinfo_lvService.getUsersByPager(pageSize, currentPage, key);
	}
}
