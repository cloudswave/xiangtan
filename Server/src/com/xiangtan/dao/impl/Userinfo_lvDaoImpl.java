package com.xiangtan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.xiangtan.beans.Userinfo_lv;
import com.xiangtan.dao.Userinfo_lvDao;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Userinfo_lvDaoImpl implements Userinfo_lvDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Userinfo_lv get(String name, String password) {
		String sql = "select * from Userinfo_lv where name = ? and password = ?";
		RowMapper<Userinfo_lv> rowMapper = new BeanPropertyRowMapper<Userinfo_lv>(
				Userinfo_lv.class);
		try {
			return jdbcTemplate.queryForObject(sql, rowMapper, name, password);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Userinfo_lv add(String name, String password, int role,
			int groupid) {
		String sql = "insert into Userinfo_lv (name, password, role ) values (?, ?, ?)";
		int update = jdbcTemplate.update(sql, name, password, role);
		if (update > 0) {// 添加成功
			return get(name, password);// 返回添加成功的对象
		}
		return null;
	}

	@Override
	public Userinfo_lv get(int id) {
		String sql = "select * from Userinfo_lv where id = ?";
		RowMapper<Userinfo_lv> rowMapper = new BeanPropertyRowMapper<Userinfo_lv>(
				Userinfo_lv.class);
		try {
			return jdbcTemplate.queryForObject(sql, rowMapper, id);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Userinfo_lv get(String name) {
		String sql = "select * from Userinfo_lv where name = ?";
		RowMapper<Userinfo_lv> rowMapper = new BeanPropertyRowMapper<Userinfo_lv>(
				Userinfo_lv.class);
		try {
			return jdbcTemplate.queryForObject(sql, rowMapper, name);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<Userinfo_lv> getByRole(int role) {
		String sql = "select * from Userinfo_lv where role = ?";
		List<Userinfo_lv> Userinfo_lvs = jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Userinfo_lvRowMapper()), role);
		return Userinfo_lvs;
	}

	@Override
	public List<Userinfo_lv> getByGroupid(int groupid) {
		String sql = "select * from Userinfo_lv where groupid = ?";
		List<Userinfo_lv> Userinfo_lvs = jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Userinfo_lvRowMapper()), groupid);
		return Userinfo_lvs;
	}
	
	private class Userinfo_lvRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Userinfo_lv userinfo_lv = new Userinfo_lv();
			userinfo_lv.setGroupid(rs.getInt("groupid"));
			userinfo_lv.setId(rs.getInt("id"));
			userinfo_lv.setName(rs.getString("name"));
			userinfo_lv.setPassword(rs.getString("password"));
			userinfo_lv.setRole(rs.getInt("role"));
			return userinfo_lv;
		}
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from Userinfo_lv where id = ?";
		int update = jdbcTemplate.update(sql, id);
		if (update > 0) {//删除成功
			return true;
		}
		return false;
	}

	@Override
	public Userinfo_lv update(int id, String name, int role,
			String password, int groupid) {
		String sql = "update Userinfo_lv set  name = ?, role = ?, password = ?, groupid = ? where id = ?";
		int update = jdbcTemplate.update(sql, name, role, password, groupid, id);
		if (update > 0) {//执行成功
			return get(id);
		}
		return null;
	}

}
