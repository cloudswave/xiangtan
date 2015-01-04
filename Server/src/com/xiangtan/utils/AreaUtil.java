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
			areaLevel = 2;//ʡ
		}else if (areaCode.contains("00000000")) {
			areaLevel = 3;//��
		}else if (areaCode.contains("000000")) {
			areaLevel = 4;//��
		}else if (areaCode.contains("000")) {
			areaLevel = 5;//��
		}else{
			areaLevel = 6;//��
		}
		return areaLevel;
	}
	
	/**
	 * @param areaCode ��������
	 * @param areaLevel �����ȼ�
	 * @return �����ĵ�ַ
	 */
	public static String getCompleteAddress(String areaCode, int areaLevel) {
		String address = "";
		String sql = "";
		SqlRowSet queryForRowSet = null;
		//System.out.println("jdbcTemplate:" + jdbcTemplate);
		switch (areaLevel) {
		case 1://�й�
			address = "�й�";
			break;
		case 2://ʡ��
				sql = "select * from area where areaCode = " + areaCode;
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				break;
		case 3://�м���ǰ��Ҫ����ʡ��
			try {
				sql = "select * from area where areaCode = " + areaCode.substring(0, 2) + "0000000000";//���ʡ��
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 4) + "00000000";//����м�
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 4://�ؼ���ǰ��Ҫ����ʡ�����м�
			try {
				sql = "select * from area where areaCode = " + areaCode.substring(0, 2) + "0000000000";//���ʡ��
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 4) + "00000000";//����м�
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 6) + "000000";//����ؼ�
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 5://�򼶣�ǰ��Ҫ����ʡ�����м����ؼ�
			try {
				sql = "select * from area where areaCode = " + areaCode.substring(0, 2) + "0000000000";//���ʡ��
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 4) + "00000000";//����м�
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 6) + "000000";//����ؼ�
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 9) + "000";//�����
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 6://�弶��ǰ��Ҫ����ʡ�����м����ؼ�����
			try {
				sql = "select * from area where areaCode = " + areaCode.substring(0, 2) + "0000000000";//���ʡ��
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 4) + "00000000";//����м�
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 6) + "000000";//����ؼ�
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode.substring(0, 9) + "000";//�����
				queryForRowSet = jdbcTemplate.queryForRowSet(sql);
				if (queryForRowSet.next()) {
					address +=  queryForRowSet.getString("AREANAME");  
				}
				sql = "select * from area where areaCode = " + areaCode;//����弶
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
