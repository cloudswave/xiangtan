package com.xiangtan.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.cxf.binding.corba.wsdl.Exception;

import com.mchange.v1.cachedstore.CachedStoreError;
import com.xiangtan.beans.Userinfo_lv;
import com.xiangtan.dao.Role_user_mapDao;
import com.xiangtan.dao.Userinfo_lvDao;
import com.xiangtan.exception.IllegalRequestException;
import com.xiangtan.service.Userinfo_lvService;
import com.xiangtan.utils.AuthorizeUtil;
import com.xiangtan.utils.EncryptUtil;
/**
 * @author Shangyidong
 * @date 2014-11-21
 * @version 1.0
 */
public class Userinfo_lvServiceImpl implements Userinfo_lvService {

	private static Userinfo_lvDao userinfo_lvDao;
	private static Role_user_mapDao role_user_mapDao;
	
	public void setUserinfo_lvDao(Userinfo_lvDao userinfo_lvDao) {
		Userinfo_lvServiceImpl.userinfo_lvDao = userinfo_lvDao;
	}
	
	public static void setRole_user_mapDao(Role_user_mapDao role_user_mapDao) {
		Userinfo_lvServiceImpl.role_user_mapDao = role_user_mapDao;
	}

	@Override
	public Userinfo_lv login(String name, String password) {
		if (name == null || password == null || name.equals("")
				|| password.equals("")) {
			return null;
		}
		Userinfo_lv userinfo_lv = userinfo_lvDao.get(name);
		if (userinfo_lv.getPassword().equals(password)) {
			System.out.println(name  + "��½�ɹ���key��" + userinfo_lv.getKey());
			return userinfo_lv;
		}
		return null;
	}

	@Override
	public Userinfo_lv add(String name, String password, String email, String tel, String truename, String department, String note, String roleIds, String key) {
//		����û�commandȨ��
		if (!AuthorizeUtil.commandOperationAuthorize("ADD_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("��ǰ�û�û��ADD_USERȨ�ޣ�");
		}
		if (name.length() == 0 || password.length() == 0) {
			System.err.println("�û������벻��Ϊ��");
			return null;
		}
		if (userinfo_lvDao.get(name) != null) {// name�������ظ�
			System.err.println("name�������ظ�");
			return null;
		}
//		System.out.println("roleIds:"+roleIds);
		Userinfo_lv userinfo_lv = userinfo_lvDao.add(name, password, email, tel, truename, department, note);
		if (userinfo_lv != null) {
			System.out.println("��ӳɹ���" + userinfo_lv);
			
			role_user_mapDao.add(userinfo_lv.getId(), roleIds);
		}
		return userinfo_lv;
	}

	@Override
	public Userinfo_lv getUserinfo_lv(int id, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("��ǰ�û�û��VIEW_USERȨ�ޣ�");
		}
		return userinfo_lvDao.get(id);
	}

	@Override
	public Userinfo_lv getUserinfo_lvByName(String name, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("��ǰ�û�û��VIEW_USERȨ�ޣ�");
		}
		return userinfo_lvDao.get(name);
	}

	/*
	@Override
	public List<Userinfo_lv> getUserinfo_lvsByRole(int role) {
		return userinfo_lvDao.getByRole(role);
	}
	*/

	@Override
	public List<Userinfo_lv> getUserinfo_lvsByGroupid(int groupid, String key) {
		return userinfo_lvDao.getByGroupid(groupid);
	}

	@Override
	public boolean deleteUserinfo_lv(int id, String key) {
		return userinfo_lvDao.delete(id);
	}

	@Override
	public List<Userinfo_lv> getAll(String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("��ǰ�û�û��VIEW_USERȨ�ޣ�");
		}
//		System.out.println("public List<Userinfo_lv> getAll() ������");
		return userinfo_lvDao.getAll();
	}

	@Override
	public List<Userinfo_lv> getUsersByPager(int pageSize, int currentPage, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("��ǰ�û�û��VIEW_USERȨ�ޣ�");
		}
//		System.err.println(authorizeString);
		/*
		if (!AuthorizeUtil.requestAuthorize(key)) {
			//System.out.println("�����֤��ͨ��");
			throw new IllegalRequestException("�Ƿ�����,�����֤ʧ��");
		}
		*/
		if (pageSize <= 0 || currentPage <= 0) {
			return null;
		}
		return userinfo_lvDao.getUsersByPager(pageSize, currentPage);
	}

	@Override
	public Userinfo_lv update(int id, String name, String password,
			String email, String tel, String truename, String department,
			String note, String roleIds, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("UPDATE_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("��ǰ�û�û��UPDATE_USERȨ�ޣ�");
		}
		role_user_mapDao.update(id, roleIds);
		Userinfo_lv userinfo_lv = userinfo_lvDao.update(id, name, password, email, tel, truename, department, note);
		return userinfo_lv;
	}

	@Override
	public List<Userinfo_lv> getUserinfo_lvsLikeSth(String name, String department, String truename, String key) {
		if (!AuthorizeUtil.commandOperationAuthorize("VIEW_USER", key)) {
			throw new com.xiangtan.exception.PermissonDeniedException("��ǰ�û�û��VIEW_USERȨ�ޣ�");
		}
		name = name.trim();
		department = department.trim();
		truename = truename.trim();
		List<Userinfo_lv>result = new ArrayList<Userinfo_lv>();
		if (name.trim().length() == 0) {//����ѯname
			if (department.trim().length() == 0) {//����ѯname ����ѯdepartment
				if (truename.trim().length() == 0) {//����ѯname ����ѯdepartment ����ѯtruename
					return null;
				}else {//����ѯname ����ѯdepartment Ҫ��ѯtruename
					result =  userinfo_lvDao.getUserinfo_lvsLikeTruename(truename);
					return result;
				}
			}else {//����ѯname Ҫ��ѯdepartment
				result = userinfo_lvDao.getUserinfo_lvsLikeDepartment(department);
				if (truename.trim().length() == 0) {//����ѯname Ҫ��ѯdepartment ����ѯtruename
					return result;
				}else {//����ѯname Ҫ��ѯdepartment Ҫ��ѯ��ѯtruename
					List<Userinfo_lv>truenameResult = userinfo_lvDao.getUserinfo_lvsLikeTruename(truename);
					List<Userinfo_lv>result1 = new ArrayList<Userinfo_lv>();
					//ȡresult��truenameResult�Ľ���
					for (int i = 0; i < result.size(); i++) {
						for (int j = 0; j < truenameResult.size(); j++) {
							if (result.get(i).getId() == truenameResult.get(j).getId()) {
								result1.add(truenameResult.get(i));
							}
						}
					}
					return result1;
				}
			}
		}else {//Ҫ��ѯname
			List<Userinfo_lv>nameResult = userinfo_lvDao.getUserinfo_lvsLikeName(name);
			if (department.trim().length() == 0) {//Ҫ��ѯname ����ѯdepartment
				if (truename.trim().length() == 0) {//Ҫ��ѯname ����ѯdepartment ����ѯtruename
					return nameResult;
				}else {//Ҫ��ѯname ����ѯdepartment Ҫ��ѯtruename
					List<Userinfo_lv>truenameResult = userinfo_lvDao.getUserinfo_lvsLikeTruename(truename);
					List<Userinfo_lv>result1 = new ArrayList<Userinfo_lv>();
					//ȡnameResult��truenameResult�Ľ���
					for (int i = 0; i < nameResult.size(); i++) {
						for (int j = 0; j < truenameResult.size(); j++) {
							if (nameResult.get(i).getId() == truenameResult.get(j).getId()) {
								result1.add(nameResult.get(i));
							}
						}
					}
					return result1;
				}
			}else {//Ҫ��ѯname Ҫ��ѯ department
				List<Userinfo_lv>departmentResult = userinfo_lvDao.getUserinfo_lvsLikeDepartment(department);
				if (truename.trim().length() == 0) {//Ҫ��ѯname Ҫ��ѯ department ����ѯtruename
					List<Userinfo_lv>result1 = new ArrayList<Userinfo_lv>();
					for (int i = 0; i < nameResult.size(); i++) {
						for (int j = 0; j < departmentResult.size(); j++) {
							if (nameResult.get(i).getId() == departmentResult.get(j).getId()) {
								result1.add(nameResult.get(i));
							}
						}
					}
					return result1;
				}else{//Ҫ��ѯname Ҫ��ѯ department Ҫ��ѯtruename
					List<Userinfo_lv>truenameResult = userinfo_lvDao.getUserinfo_lvsLikeTruename(truename);
					List<Userinfo_lv>result1 = new ArrayList<Userinfo_lv>();
					for (int i = 0; i < nameResult.size(); i++) {
						for (int j = 0; j < departmentResult.size(); j++) {
							if (nameResult.get(i).getId() == departmentResult.get(j).getId()) {
								result1.add(nameResult.get(i));
							}
						}
					}
					List<Userinfo_lv>result2 = new ArrayList<Userinfo_lv>();
					for (int i = 0; i < truenameResult.size(); i++) {
						for (int j = 0; j < result1.size(); j++) {
							if (truenameResult.get(i).getId() == result1.get(j).getId()) {
								result2.add(truenameResult.get(i));
							}
						}
					}
					return result2;
				}
			}
		}
	}

}
