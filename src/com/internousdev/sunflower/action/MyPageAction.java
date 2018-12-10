package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.UserInfoDAO;
import com.internousdev.sunflower.dto.UserInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private UserInfoDTO userInfoDTO = new UserInfoDTO();

	public String execute(){

		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}

        //SessionloginIdが無い場合home.jspに遷移
		if(!(session.containsKey("loginId"))){
		    String result = ERROR;
		    return result;
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();

		userInfoDTO = userInfoDAO.getUserInfo(String.valueOf(session.get("loginId")));

		return SUCCESS;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public UserInfoDTO getUserInfoDTO() {
		return userInfoDTO;
	}

	public void setUserInfoDTO(UserInfoDTO userInfoDTO) {
		this.userInfoDTO = userInfoDTO;
	}

}
