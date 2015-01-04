package com.xiangtan.utils;

import java.util.List;

import com.xiangtan.beans.Role_lv;
import com.xiangtan.service.Role_lvService;
import com.xiangtan.service.Userinfo_lvService;

public class AuthorizeUtil {

	//��IOC�����л�ȡbean����beans.xml��������
	private static Role_lvService role_lvService;
	private static Userinfo_lvService userinfo_lvService;
	
	public static void setRole_lvService(Role_lvService role_lvService) {
		AuthorizeUtil.role_lvService = role_lvService;
	}
	
	public static void setUserinfo_lvService(
			Userinfo_lvService userinfo_lvService) {
		AuthorizeUtil.userinfo_lvService = userinfo_lvService;
	}
	
	/**
	 * command����Ȩ����֤����
	 * @param userId �û�id
	 * @param operationString �����ַ���,e.g DELETE_USER
	 * @return ����֤�ɹ�����true�����򷵻�false
	 */
	public static boolean commandOperationAuthorize(String commandOperationString, String key) {
		String str[] = key.split("\\|\\|");
		//�����û�ֱ�ӷ���true
		if (str[0].equals("admin")) {
			return true;
		}
		List<Role_lv>role_lvs = role_lvService.getRole_lvsByUsername(str[0], key);
		
		for (Role_lv role_lv : role_lvs) {
			if (role_lv.getType().equals("region")) {
				continue;
			}
			//�����ɫ��Ȩ���ַ�������������ַ������ʾ�д�Ȩ��
			if (role_lv.getDesText().indexOf(commandOperationString) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * region����Ȩ����֤����
	 * @param userId
	 * @param regionOperationString
	 * @return
	 */
	public static boolean regionOperationAuthorize(int userId, String regionOperationString) {
		
		return false;
	}
	
	/**
	 * ������֤����
	 * @param key ����key
	 * @return ����֤�ɹ�����true�����򷵻�false
	 */
	public static boolean requestAuthorize(String authorizeString) {
		//key="admin||2882ed3a43fc42cc"
		String str[] = authorizeString.split("\\|\\|");
		//str[0]���û���
		//str[1]��key
		try {
			if (str[1].equals(EncryptUtil.encrypt(str[0]))) {
				System.out.println("���������֤ͨ��");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("���������֤��ͨ��");
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(requestAuthorize("admin||2882ed3a43fc42cc1"));
	}
}
