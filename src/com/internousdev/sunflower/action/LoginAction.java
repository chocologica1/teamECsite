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
	private String loginId;
	private String password;
	private int cartFlg;

	private List<MCategoryDTO>mCategoryDTOList = new ArrayList<MCategoryDTO>();

	private List<String>loginIdErrorMessageList = new ArrayList<String>();
	private List<String>passwordErrorMessageList = new ArrayList<String>();

	private Map<String, Object> session;
	private Object destinationDTOList;



	public String execute(){

		String result = ERROR;

		if(savedLoginId==true){
			session.put("savedLoginId", true);
			session.put("loginId", loginId);
		}else{
			session.put("savedLoginId", false);
			session.put("loginId", loginId);
		}

	//フォームに入力できる文字数の指定
	InputChecker inputChecker = new InputChecker();
	loginIdErrorMessageList = inputChecker.doCheck("ログインID", loginId, 1, 8, true, false, false, true, false, false, false, false, false);
	passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false, false, false);


	//入力できない文字が入力ときのメッセージ
	if(loginIdErrorMessageList.size()!=0 && passwordErrorMessageList.size()!=0){
		session.put("loginIdErrorMessageList", "loginIdErrorMessageList");
		session.put("passwordErrorMessageList", "passwordErrorMessageList");
		session.put("loginId",0);
	}

	if(!session.containsKey("mCategoryList")){
		MCategoryDAO mCategoryDao = new MCategoryDAO();
		mCategoryDTOList = mCategoryDao.getMCategoryList();
		session.put("mCategoryDTOList", mCategoryDTOList);
	}

	UserInfoDAO userInfoDao = new UserInfoDAO();


	if(loginId.isEmpty() && password.isEmpty()){
		loginId = String.valueOf(session.get("userId"));
		password = String.valueOf(session.get("password"));
	}

	//入力したID,パスワードが登録されているか確認
	if(userInfoDao.isExistsUserInfo(loginId, password)){
		//該当ユーザーをログイン状態にする
		if(userInfoDao.login(loginId, password)> 0){
			UserInfoDTO userInfoDTO = userInfoDao.getUserInfo(loginId, password);
			session.put("loginId", userInfoDTO.getUserId());


			//tempUserIdに保持しているカート情報とloginIDをリンクさせる
			CartInfoDAO cartInfoDao = new CartInfoDAO();
			cartInfoDao.linkToLoginId(loginId,String.valueOf(session.get("tempUserId")));


			/*cartFlgを保持している場合
			 * 宛先情報を取得し
			 * 決済画面に遷移
			 */
			cartFlg = cartInfoDao.linkToLoginId(String.valueOf(session.get("tempUserId")),loginId);
			if(cartFlg > 0) {
				DestinationInfoDAO destinationInfoDao = new DestinationInfoDAO();
				try {
					List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();
					destinationInfoDTOList = destinationInfoDao.getDestinationInfo(loginId);
					Iterator<DestinationInfoDTO> iterator = destinationInfoDTOList.iterator();
					//宛先情報がない場合nullを入れる。
					if(!(iterator.hasNext())) {
						destinationInfoDTOList = null;
					}
					session.put("destinationDTOList", destinationDTOList);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				result = "settlement";
			}else {
				result = SUCCESS;
			}
		}
		//ヘッダーにログイン情報の受け渡す
			session.put("loginFlg", 1);
	}
	return result;



		}



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
