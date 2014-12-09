package com.xiangtan.dao;

import java.util.List;

import com.xiangtan.beans.Role_lv;
import com.xiangtan.beans.Role_user_map;

public interface Role_user_mapDao {

	public List<Role_user_map> getRole_user_mapsByUserid(int userid);
	
	public void add(int userId, String roleIds);
	
	public void update(int userId, String roleIds);
}
