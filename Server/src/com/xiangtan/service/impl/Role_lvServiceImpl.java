package com.xiangtan.service.impl;

import java.util.List;

import com.xiangtan.beans.Role_lv;
import com.xiangtan.dao.Role_lvDao;
import com.xiangtan.service.Role_lvService;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Role_lvServiceImpl implements Role_lvService{

	private static Role_lvDao role_lvDao;
	public static void setRole_lvDao(Role_lvDao role_lvDao) {
		Role_lvServiceImpl.role_lvDao = role_lvDao;
	}
	
	@Override
	public Role_lv getRole_lv(int id) {
		return role_lvDao.get(id);
	}

	@Override
	public Role_lv getByRoleName(String roleName) {
		return role_lvDao.getByRoleName(roleName);
	}

	@Override
	public boolean deleteByRoleName(String roleName) {
		return role_lvDao.deleteByRoleName(roleName);
	}

	@Override
	public Role_lv addRole_lv(String roleName, String type, String desText) {
		if (roleName.length() == 0) {
			return null;
		}
		return role_lvDao.add(roleName, type, desText);
	}

	@Override
	public Role_lv updateRole_lv(int id, String roleName, String type, String desText) {
		if (roleName.length() == 0) {
			return null;
		}
		return role_lvDao.update(id, roleName, type, desText);
	}

	@Override
	public List<Role_lv> getRole_lvsByUserid(int userid) {
		return role_lvDao.getRole_lvsByUserid(userid);
	}

	@Override
	public List<Role_lv> getAll() {
		System.out.println("Role_lvServiceImpl.getAll()");
		return role_lvDao.getAll();
	}

	@Override
	public List<Role_lv> getRolesByPager(int pageSize, int currentPage) {
		if (pageSize <= 0 || currentPage <= 0) {
			return null;
		}
		return role_lvDao.getRolesByPager(pageSize, currentPage);
	}

	@Override
	public boolean deleteByRoleId(int id) {
		return role_lvDao.delete(id);
	}
}
