package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.UserInfoDAO;
import com.internousdev.sunflower.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	public String execute(){
        //SessionのloginIdが無い場合home.jspに遷移
		if(!(session.containsKey("loginId"))){
		    String result = ERROR;
		    return result;
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		UserInfoDTO userInfoDTO = new UserInfoDTO();

		userInfoDTO = userInfoDAO.getUserInfo(String.valueOf(session.get("loginId")));

		//userInfoDTOに入ったかを確認する条件分岐
		if(userInfoDTO != null){
			session.put("familyName", userInfoDTO.getFamilyName());
			session.put("firstName", userInfoDTO.getFirstName());
			session.put("familyNameKana", userInfoDTO.getFamilyNameKana());
			session.put("firstNameKana", userInfoDTO.getFirstNameKana());
			session.put("sex", userInfoDTO.getSex());
			session.put("email", userInfoDTO.getEmail());
			//一応コンソールに表示させるために
			System.out.println(session.get("familyName"));
		}
		return SUCCESS;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}



}
