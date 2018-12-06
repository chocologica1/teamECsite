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

	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private String categoryId;
	private Map<String, Object> session;

	//ログインしてるか、していないか確認
	public String execute(){
		if(!(session.containsKey("loginId")) && !(session.containsKey("tempUserId"))){
			CommonUtility commonUtility = new CommonUtility();
			session.put("tempUserId", commonUtility.getRamdomValue());
		}

		//ログイン中でないことを確認。
		if(!session.containsKey("loginId")){
			session.put("loginId", 0);
		}

		//ログイン中であることを確認。
		if(session.containsKey("loginId")){
			session.put("loginId", 1);
		}


		if(!session.containsKey("mCategoryDTOList")){
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDTOList = mCategoryDao.getMCategoryList();
			for(int i = 0; i<mCategoryDTOList.size(); i++){
				System.out.println("aa:"+ mCategoryDTOList.get(i).getCategoryId());
			}
			session.put("mCategoryDTOList", mCategoryDTOList);
		}

		return SUCCESS;
    }

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<MCategoryDTO> getmCategoryDTOList(){
		return mCategoryDTOList;
	}

	public void setmCategoryDTOList(List<MCategoryDTO> mCategoryDTOList){
		this.mCategoryDTOList = mCategoryDTOList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}


}
