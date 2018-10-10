package com.lzzjava.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.lzzjava.beans.UserInfo;

public interface UserInfoService {
	void insertMy(UserInfo userInfo);
	List<UserInfo> listAllBySql();
	List<UserInfo> testSelect();
	List<Map<String, Object>> testSelectResMap(HttpServletRequest request);
}
