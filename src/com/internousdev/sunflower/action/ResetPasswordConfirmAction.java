package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.UserInfoDAO;
import com.internousdev.sunflower.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {
	private String userId;                       //ユーザID
	private String password;                     //現在のパスワード
	private String newPassword;                  //新しいパスワード
	private String reConfirmationNewPassword;    //（再確認）
	/*private String categoryId;*/

	private List<String> userIdErrorMessageList = new ArrayList<String>();                 	 //ユーザID不適当メッセージ
	private List<String> passwordErrorMessageList = new ArrayList<String>();                 //現在のパスワード不適当メッセージ
	private List<String> incorrectErrorMessageList = new ArrayList<String>();       		 //ユーザIDまたはパスワード不存在メッセージ
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();              //新しいパスワード不適当メッセージ
	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();//（再確認）不適当メッセージ
	private List<String> newPasswordIncorrectErrorMessageList = new ArrayList<String>();     //新しいパスワードと（再確認）不一致メッセージ

	private Map<String,Object> session;  //セッション


	public String execute() {
		String result = ERROR;

		InputChecker inputChecker = new InputChecker();  //InputCheckerをインスタンス化

		//doCheck()メソッドを使って、既入力・半角英数字・文字数を判定する
		userIdErrorMessageList = inputChecker.doCheck("ユーザID",userId,1,8,true,false,false,true,false,false,false,false,false);
		passwordErrorMessageList = inputChecker.doCheck("現在のパスワード",password,1,16,true,false,false,true,false,false,false,false,false);
		newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード",newPassword,1,16,true,false,false,true,false,false,false,false,false);
		reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード(再確認)",reConfirmationNewPassword,1,16,true,false,false,true,false,false,false,false,false);

		//doPasswordCheck()メソッドを使って、"新しいパスワード"と"(再確認)"の文字列が一致するか確認する
		newPasswordIncorrectErrorMessageList = inputChecker.doPasswordCheck(newPassword,reConfirmationNewPassword);


		//上記全てのエラーメッセージが無かった場合
		if(userIdErrorMessageList.size() == 0
		&& passwordErrorMessageList.size() == 0
		&& newPasswordErrorMessageList.size() == 0
		&& reConfirmationNewPasswordErrorMessageList.size() == 0
		&& newPasswordIncorrectErrorMessageList.size() == 0) {

			UserInfoDAO userInfoDAO = new UserInfoDAO();  //UserInfoDAOをインスタンス化

			//入力されたユーザID・パスワードと一致するデータがDB上にあれば"true"が返ってくる
			if(userInfoDAO.isExistsUserInfo(userId,password)) {

				//入力された新しいパスワードの1文字目だけ表示、2～16文字目は*で表示されるようにした文字列を代入する
				String hiddenPassword = userInfoDAO.hiddenPassword(newPassword);
				session.put("copyUserId", userId);				  	  //セッション「ユーザID」
				session.put("savedUserId", true);			      //セッション「保存ユーザID(戻る用)」
				session.put("newPassword", newPassword);          //セッション「新しいパスワード」
				session.put("hiddenPassword", hiddenPassword);    //セッション「*で表示されるパスワード」
				result = SUCCESS;
				return result;

			//入力されたユーザID・パスワードと一致するデータがDB上に無かった場合
			} else if(!(userInfoDAO.isExistsUserInfo(userId,password))) {
				result = ERROR;
				incorrectErrorMessageList.add("ユーザIDまたは現在のパスワードが異なります。");
				session.put("incorrectErrorMessageList", incorrectErrorMessageList);  //セッション「ユーザIDまたはパスワード不存在メッセージ」
				return result;
			}
		} else {
			session.put("userIdErrorMessageList", userIdErrorMessageList);                                         //セッション「ユーザID不適当メッセージ」
			session.put("passwordErrorMessageList", passwordErrorMessageList);                                     //セッション「現在のパスワード不適当メッセージ」
			session.put("newPasswordErrorMessageList", newPasswordErrorMessageList);                               //セッション「新しいパスワード不適当メッセージ」
			session.put("reConfirmationNewPasswordErrorMessageList", reConfirmationNewPasswordErrorMessageList);   //セッション「（再確認）不適当メッセージ」
			session.put("newPasswordIncorrectErrorMessageList", newPasswordIncorrectErrorMessageList);             //セッション「新しいパスワードと（再確認）不一致メッセージ」
		}
		return result;
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getReConfirmationNewPassword() {
		return reConfirmationNewPassword;
	}
	public void setReConfirmationNewPassword(String reConfirmationNewPassword) {
		this.reConfirmationNewPassword = reConfirmationNewPassword;
	}

	public List<String> getUserIdErrorMessageList() {
		return userIdErrorMessageList;
	}
	public void setUserIdErrorMessageList(List<String> userIdErrorMessageList) {
		this.userIdErrorMessageList = userIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}
	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public List<String> getIncorrectErrorMessageList() {
		return incorrectErrorMessageList;
	}
	public void setIncorrectErrorMessageList(List<String> incorrectErrorMessageList) {
		this.incorrectErrorMessageList = incorrectErrorMessageList;
	}

	public List<String> getNewPasswordErrorMessageList() {
		return newPasswordErrorMessageList;
	}
	public void setNewPasswordErrorMessageList(List<String> newPasswordErrorMessageList) {
		this.newPasswordErrorMessageList = newPasswordErrorMessageList;
	}

	public List<String> getReConfirmationNewPasswordErrorMessageList() {
		return reConfirmationNewPasswordErrorMessageList;
	}
	public void setReConfirmationNewPasswordErrorMessageList(List<String> reConfirmationNewPasswordErrorMessageList) {
		this.reConfirmationNewPasswordErrorMessageList = reConfirmationNewPasswordErrorMessageList;
	}

	public List<String> getNewPasswordIncorrectErrorMessageList() {
		return newPasswordIncorrectErrorMessageList;
	}
	public void setNewPasswordIncorrectErrorMessageList(List<String> newPasswordIncorrectErrorMessageList) {
		this.newPasswordIncorrectErrorMessageList = newPasswordIncorrectErrorMessageList;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}
