package com.xiangtan.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.xiangtan.beans.Area;
import com.xiangtan.beans.Role_lv;
import com.xiangtan.dao.AreaDao;
import com.xiangtan.dao.Role_lvDao;
import com.xiangtan.dao.Userinfo_lvDao;
import com.xiangtan.service.Role_lvService;
import com.xiangtan.utils.AuthorizeUtil;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Role_lvServiceImpl implements Role_lvService{

	private static Role_lvDao role_lvDao;
	private static AreaDao areaDao;
	private static Userinfo_lvDao userinfo_lvDao;
	
	public static void setRole_lvDao(Role_lvDao role_lvDao) {
		Role_lvServiceImpl.role_lvDao = role_lvDao;
	}
	
	public static void setAreaDao(AreaDao areaDao) {
		Role_lvServiceImpl.areaDao = areaDao;
	}
	
	public static void setUserinfo_lvDao(Userinfo_lvDao userinfo_lvDao) {
		Role_lvServiceImpl.userinfo_lvDao = userinfo_lvDao;
	}
	
	@Override
	public Role_lv getRole_lv(int id, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_ROLE", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_ROLE权限！");
		}
		return role_lvDao.get(id);
	}

	@Override
	public Role_lv getByRoleName(String roleName, String key) {
		
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_ROLE", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_ROLE权限！");
		}
		
		return role_lvDao.getByRoleName(roleName);
	}

	@Override
	public boolean deleteByRoleName(String roleName, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("DELETE_ROLE", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有DELETE_ROLE权限！");
		}
		return role_lvDao.deleteByRoleName(roleName);
	}

	@Override
	public Role_lv addRole_lv(String roleName, String type, String desText, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("ADD_ROLE", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有ADD_ROLE权限！");
		}
		if (roleName.length() == 0) {
			return null;
		}
		return role_lvDao.add(roleName, type, desText);
	}

	@Override
	public Role_lv updateRole_lv(int id, String roleName, String type, String desText, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("UPDATE_ROLE", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有UPDATE_ROLE权限！");
		}
		if (roleName.length() == 0) {
			return null;
		}
		return role_lvDao.update(id, roleName, type, desText);
	}

	@Override
	public List<Role_lv> getRole_lvsByUserid(int userid, String key) {
		
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_ROLE", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_ROLE权限！");
		}
		
		return role_lvDao.getRole_lvsByUserid(userid);
	}

	@Override
	public List<Role_lv> getAll(String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_ROLE", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_ROLE权限！");
		}
		System.out.println("Role_lvServiceImpl.getAll()");
		return role_lvDao.getAll();
	}

	@Override
	public List<Role_lv> getRolesByPager(int pageSize, int currentPage, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_ROLE", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_ROLE权限！");
		}
		if (pageSize <= 0 || currentPage <= 0) {
			return null;
		}
		return role_lvDao.getRolesByPager(pageSize, currentPage);
	}

	@Override
	public boolean deleteByRoleId(int id, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("DELETE_ROLE", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有DELETE_ROLE权限！");
		}
		return role_lvDao.delete(id);
	}

	@Override
	public List<Area> getAreasByDesText(String desText, String key) {
		String areaCodes[] = desText.split("\\|\\|");
		List<Area>areas = new ArrayList<Area>();
		for (int i = 0; i < areaCodes.length; i++) {
			if(areaCodes[i].length() != 0){
				areas.add(areaDao.get(areaCodes[i]));
			}
		}
		System.out.println(areas);
		return areas;
	}

	@Override
	public List<Role_lv> getRole_lvsByUsername(String username, String key) {
//		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_ROLE", key)) {
//			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_ROLE权限！");
//		}
//		先获取用户ID，然后根据ID使用getRole_lvsByUserid方法
		 return role_lvDao.getRole_lvsByUserid(userinfo_lvDao.get(username).getId());
	}
}
