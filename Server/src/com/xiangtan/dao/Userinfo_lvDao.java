package com.xiangtan.dao;

import java.util.List;

import com.xiangtan.beans.Userinfo_lv;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public interface Userinfo_lvDao {
	public Userinfo_lv get(String name, String password);
	
	public Userinfo_lv add(String name, String password, String email, String tel, String truename, String department, String note);
	
	/**
	 * 根据id删除用户
	 * @param id 用户id
	 * @return 若删除成功则返回true，否则返回false
	 */
	public boolean delete(int id);
	
	/**
	 * 根据id查询用户
	 * @param id 用户id
	 * @return 返回查询到的Userinfo_lv对象。若查询失败返回null
	 */
	public Userinfo_lv get(int id);
	
	/**
	 * 根据用户名查询用户
	 * @param name 用户名
	 * @return 返回查询到的Userinfo_lv对象。若查询失败返回null
	 */
	public Userinfo_lv get(String name);
	
	/**
	 * 根据用户角色id查询用户
	 * @param role 用户角色id
	 * @return 返回查询到的装有满足条件的Userinfo_lv的list。若查询失败则返回null。
	 */
	//public List<Userinfo_lv> getByRole(int role);
	
	/**
	 * 根据用户组id查询用户
	 * @param groupid 用户组id
	 * @return 返回查询到的装有满足条件的Userinfo_lv的list。若查询失败则返回null。
	 */
	public List<Userinfo_lv> getByGroupid(int groupid);
	
	/**
	 * 更新用户信息
	 * @param id 用户id
	 * @param name 用户名
	 * @param role 用户角色id
	 * @param password 用户密码
	 * @param groupid 用户组id
	 * @return 更新成功的Userinfo_lv对象。若更新失败则返回null。
	 */
	public Userinfo_lv update(int id, String name, String password, String email, String tel, String truename, String department, String note);

	/**
	 * 查询所有用户
	 * @return 若查询成功，则返回查询到的装有Userinfo_lv的list。否则返回null。
	 */
	public List<Userinfo_lv> getAll();
	
	/**
	 * 
	 * @param pageSize 每页的记录数
	 * @param currentPage 当前页码
	 * @return
	 */
	public List<Userinfo_lv> getUsersByPager(int pageSize, int currentPage);
	
	/**
	 * 根据用户名模糊查找
	 * @param name
	 * @return 若查询成功，则返回查询到的装有Userinfo_lv的list。否则返回null。
	 */
	public List<Userinfo_lv> getUserinfo_lvsLikeName(String name);
	
	/**
	 * 根据部门模糊查找
	 * @param department
	 * @return 若查询成功，则返回查询到的装有Userinfo_lv的list。否则返回null。
	 */
	public List<Userinfo_lv> getUserinfo_lvsLikeDepartment(String department);
	
	/**
	 * 根据真实姓名模糊查找
	 * @param truename
	 * @return 若查询成功，则返回查询到的装有Userinfo_lv的list。否则返回null。
	 */
	public List<Userinfo_lv> getUserinfo_lvsLikeTruename(String truename);
	
	//public Userinfo_lv update(int id, String name, String password,String email, String tel, String truename, String department,String note);
}

/**
private int id;
private String name;
private int role;
private String password;
private int groupid;
*/