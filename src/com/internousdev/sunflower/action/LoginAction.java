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
import com.internousdev.sunflower.dto.MCategoryDTO;
import com.internousdev.sunflower.dto.UserInfoDTO;
import com.internousdev.sunflower.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	private boolean savedLoginId;
	private String categoryId;
	private String loginId;
	private String password;
	private String loginErrorMessage;
	private boolean cartFlg;

	private List<MCategoryDTO>mCategoryDtoList = new ArrayList<MCategoryDTO>();

	private List<String>loginIdErrorMessageList = new ArrayList<String>();
	private List<String>passwordErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;


	public String execute(){

		String result = "login";

		try{
			if(!session.containsKey("logined")){
				result = "login";
				return result;
			}


	}

	//フォームに入力できる文字数の指定
	InputChecker inputChecker = new InputChecker();
	loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false, false, false);
	passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false, false, false);


	//入力できない文字が入力ときのメッセージ
	if(loginIdErrorMessageList.size()!=0 && passwordErrorMessageList.size()!=0){
		session.put("loginIdErrorMessageList", "loginIdErrorMessageList");
		session.put("passwordErrorMessageList", "passwordErrorMessageList");
		session.put("logined",0);
	}

	//
	if(!session.containsKey("mCategoryList")){
		MCategoryDAO mCategoryDao = new MCategoryDAO();
		mCategoryDTOList = mCategoryDao.getMCategoryList();
		session.put("mCategoryDtoList", mCategoryDTOList);
	}

	UserInfoDAO userInfoDao = new UserInfoDAO();
	//入力したID,パスワードが登録されているか確認
	if(userInfoDao.isExistsUserInfo(loginId, password)){
		//該当ユーザーをログイン状態にする
		if(userInfoDao.login(loginId, password)> 0){
			UserInfoDTO userIdDTO = userInfoDao.getUserInfo(loginId, password);
			session.put("loginId", userInfoDTO.getUserId());
			int count=0;
			CartInfoDAO cartInfoDao = new CartInfoDAO();

			//仮ユーザーIDに保持しているカート情報とユーザーIDをリンクさせる
			cartInfoDao.linkToLoginId(String.valueOf(session.get("tempUserId")),loginId);

			/*ログインフラグを保持している場合
			 * 宛先情報を取得し
			 * 決済画面に遷移
			 */
			if(count > 0) {
				DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
				try {
					List<DestinationInfoDTO> destinationInfoDtoList = new ArrayList<DestinationInfoDTO>();
					destinationInfoDtoList = destinationInfoDao.getDestinationInfo(loginId);
					Iterator<DestinationInfoDTO> iterator = destinationInfoDtoList.iterator();
					if(!(iterator.hasNext())) {
						destinationInfoDtoList = null;
					}
					session.put("destinationInfoDtoList", destinationInfoDtoList);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				result = "settlement";
			}else {
				result = SUCCESS;
			}
		}
			session.put("logined", 1);
	}
	return result;



		}


		public String getCategoryId(){
			return loginErrorMessage;
		}

		public void setLoginErrorMessage(String loginErrorMessage){
			this.loginErrorMessage = loginErrorMessage;
		}

		public void setCartFl

		public String getLoginId(){
			return loginId;
		}

		public void setLoginId(String loginId){
			this.loginId = loginId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public boolean isSavedLoginId() {
			return savedLoginId;
		}

		public void setSavedLoginId(boolean savedLoginId) {
			this.savedLoginId = savedLoginId;
		}

		public List<String> getLoginIdErrorMessageList() {
			return loginIdErrorMessageList;
		}
		public void setLoginIdErrorMessageList(List<String> loginIdErrorMessageList) {
			this.loginIdErrorMessageList = loginIdErrorMessageList;
		}
		public List<String> getPasswordErrorMessageList() {
			return passwordErrorMessageList;
		}
		public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
			this.passwordErrorMessageList = passwordErrorMessageList;
		}
		public Map<String, Object> getSession() {
			return session;
		}
		public void setSession(Map<String, Object> session) {
			this.session = session;
		}




}
