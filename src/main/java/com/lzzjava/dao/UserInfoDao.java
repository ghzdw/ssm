package com.lzzjava.dao;

import java.util.List;
import java.util.Map;

import com.lzzjava.beans.UserInfo;


public interface UserInfoDao {
	void insertMy(UserInfo userInfo);
	List<UserInfo> listAllBySql(String sql);
	List<UserInfo> testSelect(String nameString, int ageee);
	List<Map<String, Object>> testSelectResMap(Map<String, Object> map);
}
