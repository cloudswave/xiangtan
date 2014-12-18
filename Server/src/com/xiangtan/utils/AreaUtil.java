package com.xiangtan.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

/**
 * @author Shangyidong
 * @date 2014-11-11
 * @version 1.0
 */
public class AreaUtil {
	@Autowired
	private static JdbcTemplate jdbcTemplate;
	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		if (AreaUtil.jdbcTemplate == null) {
			AreaUtil.jdbcTemplate = jdbcTemplate;
		}
	}
	
	public static int getAreaLevelByCode(String areaCode) {
		int areaLevel = 0;
		if (areaCode.contains("000000000000")) {
			areaLevel = 1;
		}else if (areaCode.contains("0000000000")) {
			areaLevel = 2;//省
		}else if (areaCode.contains("00000000")) {
			areaLevel = 3;//市
		}else if (areaCode.contains("000000")) {
			areaLevel = 4;//县
		}else if (areaCode.contains("000")) {
			areaLevel = 5;//镇
		}else{
			areaLevel = 6;//村
		}
		return areaLevel;
	}
	
	/**
	 * @param areaCode 地区代码
	 * @param areaLevel 地区等级
	 * @return 完整的地址
	 */
	public static String getCompleteAddress(String areaCode, int areaLevel) {
		String address = "";
		String sql = "";
		SqlRowSet queryForRowSet = null;
		//System.out.println("jdbcTemplate:" + jdbcTemplate);
		switch (areaLevel) {
		case 1://中国
			address = "中国";
			break;
		case 2://省级
				sql = "select * from area where areaCode = " + areaCode;
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				break;
		case 3://市级，前面要加上省级
			try {
				sql = "select * from area where areaCode = " + areaCode.substring(0, 2) + "0000000000";//查出省级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 4) + "00000000";//查出市级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 4://县级，前面要加上省级和市级
			try {
				sql = "select * from area where areaCode = " + areaCode.substring(0, 2) + "0000000000";//查出省级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 4) + "00000000";//查出市级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 6) + "000000";//查出县级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 5://镇级，前面要加上省级、市级和县级
			try {
				sql = "select * from area where areaCode = " + areaCode.substring(0, 2) + "0000000000";//查出省级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 4) + "00000000";//查出市级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 6) + "000000";//查出县级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 9) + "000";//查出镇级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 6://村级，前面要加上省级、市级、县级和镇级
			try {
				sql = "select * from area where areaCode = " + areaCode.substring(0, 2) + "0000000000";//查出省级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 4) + "00000000";//查出市级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 6) + "000000";//查出县级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 9) + "000";//查出镇级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode;//查出村级
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		return address;
	}
}
