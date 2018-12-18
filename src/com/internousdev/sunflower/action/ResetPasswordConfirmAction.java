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
	private List<String> userIdErrorMessageList = new ArrayList<String>();                 	 //ユーザID不適当メッセージ
	private List<String> passwordErrorMessageList = new ArrayList<String>();                 //現在のパスワード不適当メッセージ
	private List<String> incorrectErrorMessageList = new ArrayList<String>();       		 //ユーザIDまたはパスワード不存在メッセージ
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();              //新しいパスワード不適当メッセージ
	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();//（再確認）不適当メッセージ
	private List<String> newPasswordIncorrectErrorMessageList = new ArrayList<String>();     //新しいパスワードと（再確認）不一致メッセージ
	private Map<String,Object> session;  //セッション

	public String execute() {
		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}
		String result = ERROR;

	//エラーメッセージを全て消去する
		session.remove("userIdErrorMessageList");
		session.remove("passwordErrorMessageList");
		session.remove("incorrectErrorMessageList");
		session.remove("newPasswordErrorMessageList");
		session.remove("reConfirmationNewPasswordErrorMessageList");
		session.remove("newPasswordIncorrectErrorMessageList");
		session.remove("savedUserId");

	//InputCheckerをインスタンス化(文字種・文字数の判定)
		InputChecker inputChecker = new InputChecker();
		//doCheck()メソッドを使って、既入力・半角英数字・文字数を判定する
		userIdErrorMessageList = inputChecker.doCheck("ユーザID",userId,1,8,true,false,false,true,false,false,false,false,false);
		passwordErrorMessageList = inputChecker.doCheck("現在のパスワード",password,1,16,true,false,false,true,false,false,false,false,false);
		newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード",newPassword,1,16,true,false,false,true,false,false,false,false,false);
		reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード(再確認)",reConfirmationNewPassword,1,16,true,false,false,true,false,false,false,false,false);

		//４つのエラーメッセージを格納
		session.put("userIdErrorMessageList", userIdErrorMessageList);                                         //セッション「ユーザID不適当メッセージ」
		session.put("passwordErrorMessageList", passwordErrorMessageList);                                     //セッション「現在のパスワード不適当メッセージ」
		session.put("newPasswordErrorMessageList", newPasswordErrorMessageList);                               //セッション「新しいパスワード不適当メッセージ」
		session.put("reConfirmationNewPasswordErrorMessageList", reConfirmationNewPasswordErrorMessageList);   //セッション「（再確認）不適当メッセージ」


	//４つのエラーメッセージが無かった場合
		if(userIdErrorMessageList.size() == 0
		&& passwordErrorMessageList.size() == 0
		&& newPasswordErrorMessageList.size() == 0
		&& reConfirmationNewPasswordErrorMessageList.size() == 0) {
			//UserInfoDAOをインスタンス化（ユーザID・現パスワードの判定）
			UserInfoDAO userInfoDAO = new UserInfoDAO();
			//入力されたユーザID・パスワードと一致するデータがDB上に無かった場合
			if(!(userInfoDAO.isExistsUserInfo(userId,password))) {
				incorrectErrorMessageList.add("ユーザIDまたは現在のパスワードが異なります。");
				session.put("incorrectErrorMessageList", incorrectErrorMessageList);  							//セッション「ユーザIDまたはパスワード不存在メッセージ」
			}
			//入力されたユーザID・パスワードと一致するデータがDB上にあれば"true"が返ってくる
			else if(userInfoDAO.isExistsUserInfo(userId,password)) {
				//入力された新しいパスワードの1文字目だけ表示、2～16文字目は*で表示されるようにした文字列を代入する
				session.put("copyUserId", userId);				  	  //セッション「ユーザID」
				session.put("savedUserId", true);			      //セッション「保存ユーザID(戻る用)」
				session.put("newPassword", newPassword);          //セッション「新しいパスワード」
				session.put("hiddenPassword", hiddenPassword(newPassword));    //セッション「*で表示されるパスワード」

				//doPasswordCheck()メソッドを使って、"新しいパスワード"と"(再確認)"の文字列が一致するか確認する
				newPasswordIncorrectErrorMessageList = inputChecker.doPasswordCheck(newPassword,reConfirmationNewPassword);
				session.put("newPasswordIncorrectErrorMessageList", newPasswordIncorrectErrorMessageList);    	 //セッション「新しいパスワードと（再確認）不一致メッセージ」

				//新しいパスワードと（再確認）が一致している場合
				if(newPasswordIncorrectErrorMessageList.size() == 0){
					result = SUCCESS;
				}
				return result;
			}
			return result;
		}
	return result;
	}

	//パスワードを*で隠すメソッド
	 String hiddenPassword(String password){
		int beginIndex = 0;
		int endIndex = 0;
		if(password.length() >= 1) {
			endIndex = 1;
		}
		StringBuilder stringBuilder = new StringBuilder("****************");
		String hiddenPassword = stringBuilder.replace(beginIndex, endIndex, password.substring(beginIndex,endIndex)).toString();
		return hiddenPassword;
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
	public Map<String, Object> getSession() {
		return session;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
