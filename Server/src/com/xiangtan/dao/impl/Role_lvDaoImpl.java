package com.xiangtan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.xiangtan.beans.Role_lv;
import com.xiangtan.beans.Role_user_map;
import com.xiangtan.dao.Role_lvDao;
import com.xiangtan.dao.Role_user_mapDao;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Role_lvDaoImpl implements Role_lvDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private Role_user_mapDao role_user_mapDao;
	
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
		if (update > 0) {//ɾ���ɹ�
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
			Role_lv role_lv = (Role_lv)jdbcTemplate.queryForObject(sql, rowMapper, id);
			System.out.println(role_lv);
			return role_lv;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Role_lv update(int id, String roleName, String type,
			String desText) {
		String sql = "update Role_lv set roleName = ?, type = ?, desText = ? where id = ?";
		int update = jdbcTemplate.update(sql, roleName, type, desText, id);
		if (update > 0) {//���³ɹ�
			System.out.println(get(id));
			return get(id);
		}
		//����ʧ��
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
		if (update > 0) {//ɾ���ɹ�
			return true;
		}
		return false;
	}

	@Override
	public List<Role_lv> getRole_lvsByUserid(int userid) {
		//�Ȳ�role_user_map��
		System.out.println("userid:" + userid);
		List<Role_user_map> role_user_maps = role_user_mapDao.getRole_user_mapsByUserid(userid);
		List<Role_lv>role_lvs = new ArrayList<Role_lv>();
		Role_user_map role_user_map = null;
		for (Iterator iterator = role_user_maps.iterator(); iterator.hasNext();) {
			role_user_map = (Role_user_map) iterator.next();
			//����role_user_map���е�roleidȥrole_lv���в�ѯ
			role_lvs.add(get(role_user_map.getRoleid()));
		}
		return role_lvs;
	}

	@Override
	public List<Role_lv> getAll() {
		String sql = "select * from Role_lv order by id";
		List<Role_lv> role_lvs = (List<Role_lv>)jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Role_lvRowMapper()));
		System.out.println(role_lvs);
		return role_lvs;
	}

	@Override
	public List<Role_lv> getRolesByPager(int pageSize, int currentPage) {
		String sql = "select top " + pageSize + " * from Role_lv where id not in(select top " + pageSize * (currentPage - 1) + " id from Role_lv) order by id";
		List<Role_lv> role_lvs = (List<Role_lv>)jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Role_lvRowMapper()));
		return role_lvs;
	}

}
