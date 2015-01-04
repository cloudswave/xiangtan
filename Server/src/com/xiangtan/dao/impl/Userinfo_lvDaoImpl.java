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
import com.xiangtan.utils.EncryptUtil;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Userinfo_lvDaoImpl implements Userinfo_lvDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*
	@Override
	public Userinfo_lv get(String name, String password) {
		String sql = "select * from Userinfo_lv where name = ? and password = ?";
		RowMapper<Userinfo_lv> rowMapper = new BeanPropertyRowMapper<Userinfo_lv>(
				Userinfo_lv.class);
		try {
			return (Userinfo_lv)jdbcTemplate.queryForObject(sql, rowMapper, name, password);
		} catch (Exception e) {
			return null;
		}
	}
	*/

	@Override
	public Userinfo_lv add(String name, String password, String email, String tel, String truename, String department, String note) {
		String sql = "insert into Userinfo_lv (name, password, email, tel, truename, department, note ) values (?, ?, ?, ?, ?, ?, ?)";
		int update = jdbcTemplate.update(sql, name, password, email, tel, truename,  department, note);
		if (update > 0) {// 添加成功
			return get(name);// 返回添加成功的对象
		}
		return null;
	}

	@Override
	public Userinfo_lv get(int id) {
		String sql = "select * from Userinfo_lv where id = ?";
		RowMapper<Userinfo_lv> rowMapper = new BeanPropertyRowMapper<Userinfo_lv>(
				Userinfo_lv.class);
		try {
			return (Userinfo_lv)jdbcTemplate.queryForObject(sql, rowMapper, id);
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
			Userinfo_lv userinfo_lv = (Userinfo_lv)jdbcTemplate.queryForObject(sql, rowMapper, name);
			userinfo_lv.setKey(EncryptUtil.encrypt(userinfo_lv.getName()));
			System.out.println(userinfo_lv);
			return userinfo_lv;
		} catch (Exception e) {
			return null;
		}
	}

	/*
	@Override
	public List<Userinfo_lv> getByRole(int role) {
		String sql = "select * from Userinfo_lv where role = ? order by id";
		List<Userinfo_lv> Userinfo_lvs = jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Userinfo_lvRowMapper()), role);
		return Userinfo_lvs;
	}
	*/

	@Override
	public List<Userinfo_lv> getByGroupid(int groupid) {
		String sql = "select * from Userinfo_lv where groupid = ? order by id";
		List<Userinfo_lv> Userinfo_lvs = (List<Userinfo_lv>)jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Userinfo_lvRowMapper()), groupid);
		return Userinfo_lvs;
	}
	
	private class Userinfo_lvRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int index) throws SQLException {
			Userinfo_lv userinfo_lv = new Userinfo_lv();
			userinfo_lv.setId(rs.getInt("id"));
			userinfo_lv.setName(rs.getString("name"));
			userinfo_lv.setPassword(rs.getString("password"));
			userinfo_lv.setEmail(rs.getString("email"));
			userinfo_lv.setTel(rs.getString("tel"));
			userinfo_lv.setTruename(rs.getString("truename"));
			userinfo_lv.setDepartment(rs.getString("department"));
			userinfo_lv.setNote(rs.getString("note"));
			return userinfo_lv;
		}
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from Userinfo_lv where id = ?";
		System.out.println(sql);
		int update = jdbcTemplate.update(sql, id);
		if (update > 0) {//删除成功
			return true;
		}
		return false;
	}

	@Override
	public Userinfo_lv update(int id, String name, String password, String email, String tel, String truename, String department, String note) {
		String sql = "update Userinfo_lv set  name = ?, password = ?, email = ?, tel = ?, truename = ?, department = ?, note = ?  where id = ?";
		int update = jdbcTemplate.update(sql, name, password, email, tel, truename, department, note, id);
		if (update > 0) {//执行成功
			return get(id);
		}
		return null;
	}

	@Override
	public List<Userinfo_lv> getAll() {
		String sql = "select * from Userinfo_lv order by id";
		List<Userinfo_lv> Userinfo_lvs = (List<Userinfo_lv>)jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Userinfo_lvRowMapper()));
		return Userinfo_lvs;		
	}
	//String sql = "select top 10 * from Userinfo_lv where id not in(select top 10 id from Userinfo_lv) order by id";
	@Override
	public List<Userinfo_lv> getUsersByPager(int pageSize, int currentPage) {
		String sql = "select top " + pageSize + " * from Userinfo_lv where id not in(select top " + pageSize * (currentPage - 1) + " id from Userinfo_lv) order by id";
		List<Userinfo_lv> Userinfo_lvs = (List<Userinfo_lv>)jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Userinfo_lvRowMapper()));
		return Userinfo_lvs;		
	}

	@Override
	public List<Userinfo_lv> getUserinfo_lvsLikeName(String name) {
		// select * from Userinfo_lv where name like '%w%' order by id
		String sql = "select * from Userinfo_lv where name like '%"+name+"%' order by id";
		System.out.println(sql);
		List<Userinfo_lv> userinfo_lvs = (List<Userinfo_lv>)jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Userinfo_lvRowMapper()));
		//System.out.println(userinfo_lvs.size());
		return userinfo_lvs;
	}

	@Override
	public List<Userinfo_lv> getUserinfo_lvsLikeDepartment(String department) {
		String sql = "select * from Userinfo_lv where department like '%"+department+"%' order by id";
		System.out.println(sql);
		List<Userinfo_lv> userinfo_lvs = (List<Userinfo_lv>)jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Userinfo_lvRowMapper()));
		return userinfo_lvs;
	}

	@Override
	public List<Userinfo_lv> getUserinfo_lvsLikeTruename(String truename) {
		String sql = "select * from Userinfo_lv where truename like '%"+truename+"%' order by id";
		System.out.println(sql);
		List<Userinfo_lv> userinfo_lvs = (List<Userinfo_lv>)jdbcTemplate.query(sql, new RowMapperResultSetExtractor(new Userinfo_lvRowMapper()));
		return userinfo_lvs;
	}
	
}
