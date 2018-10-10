package com.lzzjava.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.lzzjava.beans.UserInfo;
import com.lzzjava.dao.UserInfoDao;
import com.lzzjava.service.UserInfoService;

@Service 
public class UserInfoServiceImpl implements UserInfoService {
	@Resource
	private UserInfoDao userInfoDao;
	
	private Logger logger=Logger.getLogger(UserInfoServiceImpl.class);

	public void insertMy(UserInfo userInfo) {
		userInfoDao.insertMy(userInfo);
		logger.info(1/0);
	}

	public List<UserInfo> listAllBySql() {
		String sqlString="select * from user_info where age>30";
		logger.info("listAllBySql");
		return userInfoDao.listAllBySql(sqlString);
	}
	public List<UserInfo> testSelect() {
		String nameParam="zdw";
		int ageParam=40;
		return userInfoDao.testSelect(nameParam,ageParam);
	}
	public List<Map<String, Object>> testSelectResMap(HttpServletRequest request) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("userName", "zdw");
		map.put("age",80);
		map.put("field","age");
		map.put("direction","desc");
		int pageNowInt=1;
		int pageSizeInt=3;
		map.put("start", pageNowInt*pageSizeInt);
		map.put("len", pageSizeInt);
		return userInfoDao.testSelectResMap(map);
	}
}
