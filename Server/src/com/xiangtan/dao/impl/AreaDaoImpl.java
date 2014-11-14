package com.xiangtan.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.xiangtan.beans.Area;
import com.xiangtan.dao.AreaDao;
//@Repository("areaDao")
public class AreaDaoImpl implements AreaDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Area get(String areaCode) {
		String sql = "select areaCode, areaLevel, areaName, subAreaNum from area where areaCode = ?";
        RowMapper<Area> rowMapper = new BeanPropertyRowMapper<Area>(Area.class);
        try {
        	return  jdbcTemplate.queryForObject(sql, rowMapper, areaCode);
		} catch (Exception e) {
			return null;
		}
	}

}
