package com.xiangtan.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import com.xiangtan.beans.Area;
import com.xiangtan.dao.AreaDao;
import com.xiangtan.utils.AreaUtil;
//@Repository("areaDao")
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class AreaDaoImpl implements AreaDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Area get(String areaCode) {
		System.err.println("areaCode:" + areaCode);
		String sql = "select areaCode, areaLevel, areaName, subAreaNum from area where areaCode = ?";
        RowMapper<Area> rowMapper = new BeanPropertyRowMapper<Area>(Area.class);
        try {
        	Area area = (Area) jdbcTemplate.queryForObject(sql, rowMapper, areaCode);
        	//System.out.println(AreaUtil.getCompleteAddress(area.getAreaCode(), area.getAreaLevel()));
//        	area.setCompleteAddress(AreaUtil.getCompleteAddress(area.getAreaCode(), area.getAreaLevel()));
        	return  area;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public Area update(String areaCode, int areaLevel, String areaName,
			int subAreaNum) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean delete(Area area) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Area add(Area area) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Area> getSubAreasByCode(String areaCode) {
		List<Area>areas = null;
		String sql = "";
		int areaLevel = AreaUtil.getAreaLevelByCode(areaCode);
		switch (areaLevel) {
		case 1:// 国，查省。
			sql = "select * from area where areaCode like '"
					+ areaCode.substring(0, 0)
					+ "__0000000000' and areaCode != '" + areaCode + "'";
			break;
		case 2:// 省级，查市
			sql = "select * from area where areaCode like '"
					+ areaCode.substring(0, 2)
					+ "__00000000' and areaCode != '" + areaCode + "'";
			break;
		case 3:// 市级，查县
			sql = "select * from area where areaCode like '"
					+ areaCode.substring(0, 4) + "__000000' and areaCode != '"
					+ areaCode + "'";
			break;
		case 4:// 县级，查镇
			sql = "select * from area where areaCode like '"
					+ areaCode.substring(0, 6) + "___000' and areaCode != '"
					+ areaCode + "'";
			break;
		case 5:// 镇级，查村
			sql = "select * from area where areaCode like '"
					+ areaCode.substring(0, 9) + "___' and areaCode != '"
					+ areaCode + "'";
			break;
		case 6:// 村级。没有下级，不查。

			break;
		default:
			break;
		}
		if (sql.length() == 0) {
			return null;
		}
		areas = (List<Area>)jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new AreaRowMapper()));
//		for (Area area : areas) {
//			area.setCompleteAddress(AreaUtil.getCompleteAddress(area.getAreaCode(), area.getAreaLevel()));
//		}
		System.out.println(areas);
//		System.out.println(AreaUtil.getCompleteAddress("420500000000", 3));
		return areas;
	}

	private class AreaRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Area area = new Area();
			area.setAreaCode(rs.getString("areaCode"));
			area.setAreaLevel(rs.getInt("areaLevel"));
			area.setAreaName(rs.getString("areaName"));
			area.setSubAreaNum(rs.getInt("subAreaNum"));
			//area.setCompleteAddress(AreaUtil.getCompleteAddress(area.getAreaCode(), area.getAreaLevel()));
			return area;
		}
	}
}
