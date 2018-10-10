package com.lzzjava.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzzjava.beans.UserInfo;
import com.lzzjava.service.UserInfoService;

@Controller
public class UserInfoHandler {
	
	@Resource
	private UserInfoService userInfoService;
	@RequestMapping("/insertMy") 
	public String insertMy(){
		UserInfo userInfo=new UserInfo();
		userInfo.setUserName("zdw"+Math.random());
		userInfo.setAge(Long.valueOf(Math.round(Math.ceil(Math.random()*200))).intValue());
		userInfoService.insertMy(userInfo);
		return "redirect:/test.jsp";
	}
	@RequestMapping("/listAllBySql") 
	public String listAllBySql(){
		List<UserInfo> listAll = userInfoService.listAllBySql();
		for(UserInfo u:listAll){
			System.out.println(u);
		}
		return "redirect:/test.jsp";
	}
	@RequestMapping("/testSelect") 
	public String testSelect(){
		List<UserInfo> listAll = userInfoService.testSelect();
		for(UserInfo u:listAll){
			System.out.println(u);
		}
		return "redirect:/test.jsp";
	}
	@RequestMapping("/testSelectResMap")  @ResponseBody
	public Map<String, Object> testSelect2ResJson(HttpServletRequest request){
		List<Map<String, Object>> list = userInfoService.testSelectResMap(request);
		Map<String, Object> resultMap=new HashMap<String, Object>();
		resultMap.put("rows", list);
		return resultMap;
	}
}
