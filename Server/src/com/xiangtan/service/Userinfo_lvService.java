package com.xiangtan.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.xiangtan.beans.Userinfo_lv;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
@WebService
public interface Userinfo_lvService {
	
	/**
	 * 用户登录
	 * @param name 用户名
	 * @param password 密码
	 * @return 若登录成功，则返回用户名和密码对应的Userinfo_lv对象。否则返回null。
	 */
	@WebMethod
	public Userinfo_lv login(String name, String password);
	
	/**
	 * 添加用户
	 * @param name 用户名
	 * @param password 密码
	 * @param role 角色id
	 * @param groupid 组id
	 * @return 若添加成功，则返回成功添加的Userinfo_lv对象。否则返回null。
	 */
	@WebMethod
	public Userinfo_lv add(String name, String password, String email, String tel, String truename, String department, String note, String roleIds);
	/**
	 * 根据用户id查询Userinfo_lv对象
	 * @param id 用户id
	 * @return 若查询成功，则返回查询到的Userinfo_lv对象。否则返回null。
	 */
	@WebMethod
	public Userinfo_lv getUserinfo_lv(int id);
	
	/**
	 * 更新用户信息
	 * @param id
	 * @param name
	 * @param password
	 * @param email
	 * @param tel
	 * @param truename
	 * @param department
	 * @param note
	 * @param roleIds
	 * @return 更新成功的Userinfo_lv对象
	 */
	@WebMethod
	public Userinfo_lv update(int id, String name, String password, String email, String tel, String truename, String department, String note, String roleIds);
	
	/**
	 * 根据用户name查询Userinfo_lv对象
	 * @param name 用户名
	 * @return 若查询成功，则返回查询到的Userinfo_lv对象。否则返回null。
	 */
	@WebMethod
	public Userinfo_lv getUserinfo_lvByName(String name);
	
	/**
	 * 根据用户名模糊查找
	 * @param name
	 * @return 若查询成功，则返回查询到的装有Userinfo_lv的list。否则返回null。
	 */
	@WebMethod
	public List<Userinfo_lv> getUserinfo_lvsLikeName(String name);
	
	/**
	 * 根据用户角色id查询装有Userinfo_lv的list
	 * @param role 用户角色id
	 * @return 若查询成功，则返回查询到的装有Userinfo_lv的list。否则返回null。
	 */
	/*
	@WebMethod
	public List<Userinfo_lv> getUserinfo_lvsByRole(int role);
	*/
	/**
	 * 根据用户组id查询装有Userinfo_lv的list
	 * @param groupid 用户组id
	 * @return 若查询成功，则返回查询到的装有Userinfo_lv的list。否则返回null。
	 */
	@WebMethod
	public List<Userinfo_lv> getUserinfo_lvsByGroupid(int groupid);
	
	/**
	 * 根据id删除用户
	 * @param id 用户id
	 * @return 若删除成功则返回true，若删除失败则返回false
	 */
	@WebMethod
	public boolean deleteUserinfo_lv(int id);
	
	/**
	 * 查询所有用户
	 * @return 若查询成功，则返回查询到的装有Userinfo_lv的list。否则返回null。
	 */
	@WebMethod
	public List<Userinfo_lv> getAll();
	
	/**
	 * 
	 * @param pageSize 每页记录数
	 * @param currentPage 当前页码
	 * @return
	 */
	@WebMethod
	public List<Userinfo_lv> getUsersByPager(int pageSize, int currentPage);
}

/**

*/