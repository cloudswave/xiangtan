package com.xiangtan.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.xiangtan.beans.Pager;
import com.xiangtan.dao.PagerDao;

public class PagerDaoImpl implements PagerDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public Pager getPager(String tableName) {
		int totalCount = 0;
		String sql = "select count(*)as totalCount from " + tableName;
		SqlRowSet queryForRowSet = jdbcTemplate.queryForRowSet(sql);
		if (queryForRowSet.next()) {
			totalCount =  queryForRowSet.getInt("totalCount");  
		}
		Pager pager = new Pager();
		pager.setTotalCount(totalCount);
		//pager.setCurrentPage(1);
		//pager.setPageNo(1);
		//Math.ceil((double)totalCount/(double)pager.getPageSize());
		//Math.ceil((double)totalCount/(double)pager.getPageSize()).intValue();
		Double s = new Double(Math.ceil((double)totalCount/(double)pager.getPageSize()));
		pager.setTotalPage(s.intValue());
		//pager.setTotalPage(totalCount/pager.getPageSize() + 1);
		System.out.println(pager);
		return pager;
	}
}
