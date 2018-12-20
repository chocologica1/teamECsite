package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.MCategoryDAO;
import com.internousdev.sunflower.dto.MCategoryDTO;
import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware{
	private String categoryId;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private Map<String, Object> session;
	public String execute() {

		if(session == null || session.isEmpty()){
			return "timeOut";
		}

		if(!session.containsKey("mCategoryList")) {
			MCategoryDAO mCategoryDao = new MCategoryDAO();
			mCategoryDTOList = mCategoryDao.getMCategoryList();
			session.put("mCategoryDTOList", mCategoryDTOList);
		}
		session.put("loginIdErrorMessageList", "");
		session.put("passwordErrorMessageList", "");

		//カートフラグの削除
		session.remove("cartFlg");
		return SUCCESS;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public List<MCategoryDTO> getmCategoryDtoList() {
		return mCategoryDTOList;
	}

	public void setmCategoryDtoList(List<MCategoryDTO> mCategoryDTOList) {
		this.mCategoryDTOList = mCategoryDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}