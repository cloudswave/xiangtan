package com.xiangtan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.xiangtan.beans.Role_user_map;
import com.xiangtan.dao.Role_user_mapDao;

public class Role_user_mapDaoImpl implements Role_user_mapDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	//@Autowired
	//private Role_lvDao role_lvDao;
	
	public List<Role_user_map> getRole_user_mapsByUserid(int userid) {
		String sql = "select * from role_user_map_lv where userid = ?";
		List<Role_user_map> role_user_maps = (List<Role_user_map>) jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Role_user_mapRowMapper()), userid);
		return role_user_maps;
	}

	private class Role_user_mapRowMapper implements RowMapper{
        @Override
        public Object mapRow(ResultSet rs, int index) throws SQLException {
        	Role_user_map role_user_map = new Role_user_map();
        	role_user_map.setId(rs.getInt("id"));
        	role_user_map.setRoleid(rs.getInt("roleid"));
        	role_user_map.setUserid(rs.getInt("userid"));
            return role_user_map;
        }
    }

	@Override
	public void add(int userId, String roleIds) {
		//roleIds的结构为 114||145||123||178
		String rolesId[] = roleIds.split(",");
		System.err.println(roleIds);
		for (int i = 0; i < rolesId.length; i++) {
			System.out.println(rolesId[i]);
		}
		String sql = "insert into role_user_map_lv (roleid, userid)values(?,?)";
		for (int i = 0; i < rolesId.length; i++) {
			if (rolesId[i].length() != 0) {
				int j = jdbcTemplate.update(sql, Integer.parseInt(rolesId[i]), userId);
			}
		}
	}

	@Override
	public void update(int userId, String roleIds) {
		//先删除原有的映射关系
		String sql = "delete from role_user_map_lv where userid = ?";
		int update = jdbcTemplate.update(sql, userId);
		if (update > 0) {
			System.out.println("删除原有映射关系");
		}
		add(userId, roleIds);
	}
}
