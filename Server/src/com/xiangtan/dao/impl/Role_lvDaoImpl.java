package com.xiangtan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.cxf.wsdl.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.xiangtan.beans.Role_lv;
import com.xiangtan.beans.Userinfo_lv;
import com.xiangtan.dao.Role_lvDao;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Role_lvDaoImpl implements Role_lvDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Role_lv add(String roleName, String type, String desText) {
		String sql = "insert into Role_lv (roleName, type, desText) values (? , ?, ?)";
		int update = jdbcTemplate.update(sql, roleName, type, desText);
		if (update > 0) {
			return getByRoleName(roleName);
		}
		return null;
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from Role_lv where id = ?";
		int update = jdbcTemplate.update(sql, id);
		if (update > 0) {//删除成功
			return true;
		}
		return false;
	}

	@Override
	public Role_lv get(int id) {
		String sql = "select * from Role_lv where id = ?";
		RowMapper<Role_lv> rowMapper = new BeanPropertyRowMapper<Role_lv>(
				Role_lv.class);
		try {
			return jdbcTemplate.queryForObject(sql, rowMapper, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Role_lv update(int id, String roleName, String type,
			String desText) {
		String sql = "update Role_lv set roleName = ?, type = ?, desText = ? where id = ?";
		int update = jdbcTemplate.update(sql, roleName, type, desText, id);
		if (update > 0) {//更新成功
			return get(id);
		}
		//更新失败
		return null;
	}
	
	private class Role_lvRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Role_lv role_lv = new Role_lv();
			role_lv.setDesText(rs.getString("desText"));
			role_lv.setId(rs.getInt("id"));
			role_lv.setRoleName(rs.getString("roleName"));
			role_lv.setType(rs.getString("type"));
			return role_lv;
		}
	}

	@Override
	public Role_lv getByRoleName(String roleName) {
		String sql = "select * from Role_lv where roleName = ?";
		RowMapper<Role_lv> rowMapper = new BeanPropertyRowMapper<Role_lv>(
				Role_lv.class);
		try {
			return jdbcTemplate.queryForObject(sql, rowMapper, roleName);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteByRoleName(String roleName) {
		String sql = "delete from Role_lv where roleName = ?";
		int update = jdbcTemplate.update(sql, roleName);
		if (update > 0) {//删除成功
			return true;
		}
		return false;
	}

}
