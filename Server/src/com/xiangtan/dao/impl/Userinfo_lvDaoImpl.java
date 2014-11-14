package com.xiangtan.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.xiangtan.beans.Userinfo_lv;
import com.xiangtan.dao.Userinfo_lvDao;

public class Userinfo_lvDaoImpl implements Userinfo_lvDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public Userinfo_lv login(String name, String password) {
		String sql = "select * from Userinfo_lv where name = ? and password = ?";
        RowMapper<Userinfo_lv> rowMapper = new BeanPropertyRowMapper<Userinfo_lv>(Userinfo_lv.class);
        try {
        	return  jdbcTemplate.queryForObject(sql, rowMapper, name, password);
		} catch (Exception e) {
			return null;
		}
	}

}
