package com.internousdev.sunflower.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.CartInfoDAO;
import com.internousdev.sunflower.dao.DestinationInfoDAO;
import com.internousdev.sunflower.dao.MCategoryDAO;
import com.internousdev.sunflower.dao.UserInfoDAO;
import com.internousdev.sunflower.dto.DestinationInfoDTO;
import com.internousdev.sunflower.dto.MCatergoryDTO;
import com.internousdev.sunflower.dto.UserInfoDTO;
import com.internousdev.sunflower.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private boolean savedLoginId;
	private String categoryId;
	private String loginId;
	private String password;
	private String loginErrorMessage;

	private List<MCategoryDTO>mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private List<String>loginIdErrorMessageList = new ArrayList<String>();
	private List<String>passwordErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;


	public String execute(){



	}

	//フォームに入力できる文字数の指定
	InputChecker inputChecker = new InputChecker();
	loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false, false, false);
	passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false, false, false);


	//入力できない文字が入力ときのメッセージ
	if(loginIdErrorMessageList.size()!=0 && passworkErrorMessageList.size()!=0){
		session.put("loginIdErrorMessageList", "loginIdErrorMessageList");
		session.put("passwordErrorMessageList", "passwordErrorMessageList");
		session.put("logined",0);
	}

	//
	if(!session.containsKey("mCategoryList")){
		MCategoryDAO mCategoryDao = new MCategoryDAO();
		mCategoryDtoList = mCategoryDao.getMCategoryList;
		session.put("mCategoryDtoList", mCategoryList);
	}

	UserInfoDAO userInfoDao = new UserInfoDAO();
	//入力したID,パスワードが登録されているか確認
	if(userInfoDao.login(loginId, password)){
		//該当ユーザーをログイン状態にする
		if(userInfoDao.login(loginId, password)> 0){
			UserInfoDTO userIdDTO = userInfoDao.getUserInfo(loginId, password);
			session.put("loginId", userInfoDTO.getUserId());
			int count=0;
			CartInfoDAO cartInfoDao = new CartInfoDAO();


		}
	}




}
