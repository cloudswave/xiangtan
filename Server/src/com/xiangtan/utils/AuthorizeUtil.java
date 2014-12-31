package com.xiangtan.utils;

import java.util.List;

import com.xiangtan.beans.Role_lv;
import com.xiangtan.service.Role_lvService;
import com.xiangtan.service.Userinfo_lvService;

public class AuthorizeUtil {

	//从IOC容器中获取bean，在beans.xml中有配置
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
	 * command操作权限验证方法
	 * @param userId 用户id
	 * @param operationString 操作字符串,e.g DELETE_USER
	 * @return 若验证成功返回true，否则返回false
	 */
	public static boolean commandOperationAuthorize(String commandOperationString, String key) {
		String str[] = key.split("\\|\\|");
		//超级用户直接返回true
		if (str[0].equals("admin")) {
			return true;
		}
		List<Role_lv>role_lvs = role_lvService.getRole_lvsByUsername(str[0], key);
		
		for (Role_lv role_lv : role_lvs) {
			if (role_lv.getType().equals("region")) {
				continue;
			}
			//如果角色的权限字符串里包含操作字符串则表示有此权限
			if (role_lv.getDesText().indexOf(commandOperationString) >= 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * region操作权限验证方法
	 * @param userId
	 * @param regionOperationString
	 * @return
	 */
	public static boolean regionOperationAuthorize(int userId, String regionOperationString) {
		
		return false;
	}
	
	/**
	 * 请求验证方法
	 * @param key 请求key
	 * @return 若验证成功返回true，否则返回false
	 */
	public static boolean requestAuthorize(String authorizeString) {
		//key="admin||2882ed3a43fc42cc"
		String str[] = authorizeString.split("\\|\\|");
		//str[0]是用户名
		//str[1]是key
		try {
			if (str[1].equals(EncryptUtil.encrypt(str[0]))) {
				System.out.println("请求身份验证通过");
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.err.println("请求身份验证不通过");
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(requestAuthorize("admin||2882ed3a43fc42cc1"));
	}
}
