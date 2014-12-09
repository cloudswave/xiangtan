package com.xiangtan.beans;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Role_lv {
	private int id;
	private String roleName;
	private String type;
	private String desText;

	public int getId() {
		return id;
	}

	public String getRoleName() {
		return roleName;
	}

	public String getType() {
		return type;
	}

	public String getDesText() {
		return desText;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setDesText(String desText) {
		this.desText = desText;
	}

	public Role_lv(int id, String roleName, String type, String desText) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.type = type;
		this.desText = desText;
	}

	public Role_lv() {
		super();
	}

	@Override
	public String toString() {
		return "Role_lv [id=" + id + ", roleName=" + roleName + ", type="
				+ type + ", desText=" + desText + "]";
	}

}
