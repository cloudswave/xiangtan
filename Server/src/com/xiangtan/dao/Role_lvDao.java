package com.xiangtan.dao;

import java.util.List;

import com.xiangtan.beans.Role_lv;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public interface Role_lvDao {

	/**
	 * 添加新的角色
	 * @param roleName 角色名
	 * @param type 角色类型
	 * @param desText 角色信息
	 * @return 返回成功添加的角色。若添加不成功则返回null。
	 */
	public Role_lv add(String roleName, String type, String desText);
	
	/**
	 * 根据角色id删除角色
	 * @param id 角色id
	 * @return 若删除成功则返回true，否则返回false
	 */
	public boolean delete(int id);
	
	/**
	 * 根据角色名删除角色
	 * @param roleName 角色名
	 * @return 若删除成功则返回true，否则返回false
	 */
	public boolean deleteByRoleName(String roleName);
	
	/**
	 * 根据id查询角色
	 * @param id 角色id
	 * @return 返回查询到的Role_lv对象。若查询不成功则返回null。
	 */
	public Role_lv get(int id);
	
	/**
	 * 根据角色名查询角色
	 * @param roleName 角色名
	 * @return 返回查询到的Role_lv对象。若查询不成功则返回null。
	 */
	public Role_lv getByRoleName(String roleName);
	
	/**
	 * 更新角色信息
	 * @param id 角色id
	 * @param roleName 角色名称
	 * @param type 角色类型
	 * @param desText 角色信息
	 * @return 返回成功更新的Role_lv对象。
	 */
	public Role_lv update(int id, String roleName, String type, String desText);
	
	/***
	 * 根据用户ID查询用户所属的角色
	 * @param userid 用户id
	 * @return
	 */
	public List<Role_lv> getRole_lvsByUserid(int userid);
	
	/**
	 * 查询所有角色
	 * @return
	 */
	public List<Role_lv> getAll();
}

/*
 * 
 * 	private int id;
	private String roleName;
	private String type;
	private String desText;
 */
