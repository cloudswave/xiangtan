package com.xiangtan.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.cxf.binding.corba.wsdl.Exception;

import com.mchange.v1.cachedstore.CachedStoreError;
import com.xiangtan.beans.Userinfo_lv;
import com.xiangtan.dao.Role_user_mapDao;
import com.xiangtan.dao.Userinfo_lvDao;
import com.xiangtan.exception.IllegalRequestException;
import com.xiangtan.service.Userinfo_lvService;
import com.xiangtan.utils.AuthorizeUtil;
import com.xiangtan.utils.EncryptUtil;
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
		Userinfo_lv userinfo_lv = userinfo_lvDao.get(name);
		if (userinfo_lv.getPassword().equals(password)) {
			System.out.println(name  + "登陆成功，key：" + userinfo_lv.getKey());
			return userinfo_lv;
		}
		return null;
	}

	@Override
	public Userinfo_lv add(String name, String password, String email, String tel, String truename, String department, String note, String roleIds, String key) {
//		检查用户command权限
		if (!AuthorizeUtil.commandOperationAuthorize("ADD_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有ADD_USER权限！");
		}
		if (name.length() == 0 || password.length() == 0) {
			System.err.println("用户名密码不可为空");
			return null;
		}
		if (userinfo_lvDao.get(name) != null) {// name不允许重复
			System.err.println("name不允许重复");
			return null;
		}
//		System.out.println("roleIds:"+roleIds);
		Userinfo_lv userinfo_lv = userinfo_lvDao.add(name, password, email, tel, truename, department, note);
		if (userinfo_lv != null) {
			System.out.println("添加成功，" + userinfo_lv);
			
			role_user_mapDao.add(userinfo_lv.getId(), roleIds);
		}
		return userinfo_lv;
	}

	@Override
	public Userinfo_lv getUserinfo_lv(int id, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_USER权限！");
		}
		return userinfo_lvDao.get(id);
	}

	@Override
	public Userinfo_lv getUserinfo_lvByName(String name, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_USER权限！");
		}
		return userinfo_lvDao.get(name);
	}

	/*
	@Override
	public List<Userinfo_lv> getUserinfo_lvsByRole(int role) {
		return userinfo_lvDao.getByRole(role);
	}
	*/

	@Override
	public List<Userinfo_lv> getUserinfo_lvsByGroupid(int groupid, String key) {
		return userinfo_lvDao.getByGroupid(groupid);
	}

	@Override
	public boolean deleteUserinfo_lv(int id, String key) {
		return userinfo_lvDao.delete(id);
	}

	@Override
	public List<Userinfo_lv> getAll(String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_USER权限！");
		}
//		System.out.println("public List<Userinfo_lv> getAll() 被调用");
		return userinfo_lvDao.getAll();
	}

	@Override
	public List<Userinfo_lv> getUsersByPager(int pageSize, int currentPage, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_USER权限！");
		}
//		System.err.println(authorizeString);
		/*
		if (!AuthorizeUtil.requestAuthorize(key)) {
			//System.out.println("身份验证不通过");
			throw new IllegalRequestException("非法请求,身份验证失败");
		}
		*/
		if (pageSize <= 0 || currentPage <= 0) {
			return null;
		}
		return userinfo_lvDao.getUsersByPager(pageSize, currentPage);
	}

	@Override
	public Userinfo_lv update(int id, String name, String password,
			String email, String tel, String truename, String department,
			String note, String roleIds, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("UPDATE_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有UPDATE_USER权限！");
		}
		role_user_mapDao.update(id, roleIds);
		Userinfo_lv userinfo_lv = userinfo_lvDao.update(id, name, password, email, tel, truename, department, note);
		return userinfo_lv;
	}

	@Override
	public List<Userinfo_lv> getUserinfo_lvsLikeSth(String name, String department, String truename, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("当前用户没有VIEW_USER权限！");
		}
		name = name.trim();
		department = department.trim();
		truename = truename.trim();
		List<Userinfo_lv>result = new ArrayList<>();
		if (name.trim().length() == 0) {//不查询name
			if (department.trim().length() == 0) {//不查询name 不查询department
				if (truename.trim().length() == 0) {//不查询name 不查询department 不查询truename
					return null;
				}else {//不查询name 不查询department 要查询truename
					result =  userinfo_lvDao.getUserinfo_lvsLikeTruename(truename);
					return result;
				}
			}else {//不查询name 要查询department
				result = userinfo_lvDao.getUserinfo_lvsLikeDepartment(department);
				if (truename.trim().length() == 0) {//不查询name 要查询department 不查询truename
					return result;
				}else {//不查询name 要查询department 要查询查询truename
					List<Userinfo_lv>truenameResult = userinfo_lvDao.getUserinfo_lvsLikeTruename(truename);
					List<Userinfo_lv>result1 = new ArrayList<>();
					//取result和truenameResult的交集
					for (int i = 0; i < result.size(); i++) {
						for (int j = 0; j < truenameResult.size(); j++) {
							if (result.get(i).getId() == truenameResult.get(j).getId()) {
								result1.add(truenameResult.get(i));
							}
						}
					}
					return result1;
				}
			}
		}else {//要查询name
			List<Userinfo_lv>nameResult = userinfo_lvDao.getUserinfo_lvsLikeName(name);
			if (department.trim().length() == 0) {//要查询name 不查询department
				if (truename.trim().length() == 0) {//要查询name 不查询department 不查询truename
					return nameResult;
				}else {//要查询name 不查询department 要查询truename
					List<Userinfo_lv>truenameResult = userinfo_lvDao.getUserinfo_lvsLikeTruename(truename);
					List<Userinfo_lv>result1 = new ArrayList<>();
					//取nameResult和truenameResult的交集
					for (int i = 0; i < nameResult.size(); i++) {
						for (int j = 0; j < truenameResult.size(); j++) {
							if (nameResult.get(i).getId() == truenameResult.get(j).getId()) {
								result1.add(nameResult.get(i));
							}
						}
					}
					return result1;
				}
			}else {//要查询name 要查询 department
				List<Userinfo_lv>departmentResult = userinfo_lvDao.getUserinfo_lvsLikeDepartment(department);
				if (truename.trim().length() == 0) {//要查询name 要查询 department 不查询truename
					List<Userinfo_lv>result1 = new ArrayList<>();
					for (int i = 0; i < nameResult.size(); i++) {
						for (int j = 0; j < departmentResult.size(); j++) {
							if (nameResult.get(i).getId() == departmentResult.get(j).getId()) {
								result1.add(nameResult.get(i));
							}
						}
					}
					return result1;
				}else{//要查询name 要查询 department 要查询truename
					List<Userinfo_lv>truenameResult = userinfo_lvDao.getUserinfo_lvsLikeTruename(truename);
					List<Userinfo_lv>result1 = new ArrayList<>();
					for (int i = 0; i < nameResult.size(); i++) {
						for (int j = 0; j < departmentResult.size(); j++) {
							if (nameResult.get(i).getId() == departmentResult.get(j).getId()) {
								result1.add(nameResult.get(i));
							}
						}
					}
					List<Userinfo_lv>result2 = new ArrayList<>();
					for (int i = 0; i < truenameResult.size(); i++) {
						for (int j = 0; j < result1.size(); j++) {
							if (truenameResult.get(i).getId() == result1.get(j).getId()) {
								result2.add(truenameResult.get(i));
							}
						}
					}
					return result2;
				}
			}
		}
	}

}
