package com.xiangtan.ws.impl;

import java.util.List;

import com.xiangtan.beans.Area;
import com.xiangtan.beans.Role_lv;
import com.xiangtan.service.Role_lvService;
import com.xiangtan.ws.Role_lvWS;

public class Role_lvWSImpl implements Role_lvWS{

	private static Role_lvService role_lvService;
	public static void setRole_lvService(Role_lvService role_lvService) {
		Role_lvWSImpl.role_lvService = role_lvService;
	}
	@Override
	public Role_lv getRole_lv(int id, String key) {
		// TODO Auto-generated method stub
		return role_lvService.getRole_lv(id, key);
	}

	@Override
	public Role_lv getByRoleName(String roleName, String key) {
		// TODO Auto-generated method stub
		return role_lvService.getByRoleName(roleName, key);
	}

	@Override
	public boolean deleteByRoleName(String roleName, String key) {
		// TODO Auto-generated method stub
		return role_lvService.deleteByRoleName(roleName, key);
	}

	@Override
	public boolean deleteByRoleId(int id, String key) {
		// TODO Auto-generated method stub
		return role_lvService.deleteByRoleId(id, key);
	}

	@Override
	public Role_lv addRole_lv(String roleName, String type, String desText, String key) {
		// TODO Auto-generated method stub
		return role_lvService.addRole_lv(roleName, type, desText, key);
	}

	@Override
	public Role_lv updateRole_lv(int id, String roleName, String type,
			String desText, String key) {
		// TODO Auto-generated method stub
		return role_lvService.updateRole_lv(id, roleName, type, desText, key);
	}

	@Override
	public List<Role_lv> getRole_lvsByUserid(int userid, String key) {
		// TODO Auto-generated method stub
		return role_lvService.getRole_lvsByUserid(userid, key);
	}

	@Override
	public List<Role_lv> getAll(String key) {
		// TODO Auto-generated method stub
		return role_lvService.getAll(key);
	}

	@Override
	public List<Role_lv> getRolesByPager(int pageSize, int currentPage, String key) {
		// TODO Auto-generated method stub
		return role_lvService.getRolesByPager(pageSize, currentPage, key);
	}

	@Override
	public List<Area> getAreasByDesText(String desText, String key) {
		// TODO Auto-generated method stub
		return role_lvService.getAreasByDesText(desText, key);
	}

}
