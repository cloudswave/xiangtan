package com.xiangtan.beans;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Userinfo_lv {
	private int id;
	private String name;
	private String password;
	private String email;
	private String tel;
	private String truename;
	private String department;
	private String note;
	private String key;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public Userinfo_lv() {
		super();
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}

	public String getTruename() {
		return truename;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setTruename(String truename) {
		this.truename = truename;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public String getKey() {
		return key;
	}

	@Override
	public String toString() {
		return "Userinfo_lv [id=" + id + ", name=" + name + ", password="
				+ password + ", email=" + email + ", tel=" + tel
				+ ", truename=" + truename + ", department=" + department
				+ ", note=" + note + ", key=" + key + "]";
	}

}
