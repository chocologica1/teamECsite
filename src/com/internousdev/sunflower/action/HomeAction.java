package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.MCategoryDAO;
import com.internousdev.sunflower.dto.MCategoryDTO;
import com.internousdev.sunflower.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;

	//ログインしてるか、していないか確認 ログインしていない場合tempUserIdをputする。
	public String execute(){

		List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();

		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRamdomValue());
		}

		if(!session.containsKey("mCategoryDTOList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDTOList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}

		return SUCCESS;
    }

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}

}
