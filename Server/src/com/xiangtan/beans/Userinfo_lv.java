package com.xiangtan.beans;

public class Userinfo_lv {
	private int id;
	private String name;
	private int role;
	private String password;
	private int groupid;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getRole() {
		return role;
	}

	public String getPassword() {
		return password;
	}

	public int getGroupid() {
		return groupid;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	public Userinfo_lv(int id, String name, int role, String password,
			int groupid) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.password = password;
		this.groupid = groupid;
	}

	public Userinfo_lv() {
		super();
	}

	@Override
	public String toString() {
		return "Userinfo_lv [id=" + id + ", name=" + name + ", role=" + role
				+ ", password=" + password + ", groupid=" + groupid + "]";
	}

}
