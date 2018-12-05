package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {
	private String loginId;                      //ユーザID
	private String password;                     //現在のパスワード
	private String newPassword;                  //新しいパスワード
	private String reConfirmationNewPassword;    //（再確認）
	/*private String categoryId;*/

	private List<String> loginIdErrorMessageList = new ArrayList<String>();                  //ユーザIDが適当でないときのエラーメッセージ
	private List<String> passwordErrorMessageList = new ArrayList<String>();                 //現在のパスワードが間違っているときのエラーメッセージ
	private List<String> passwordIncorrectErrorMessageList = new ArrayList<String>();        //
	private List<String> newPasswordErrorMessageList = new ArrayList<String>();              //
	private List<String> reConfirmationNewPasswordErrorMessageList = new ArrayList<String>();//
	private List<String> newPasswordIncorrectErrorMessageList = new ArrayList<String>();     //

	private Map<String,Object> session;  //セッション


	public String execute() {
		String result = ERROR;

		InputChecker inputChecker = new InputChecker();  //InputCheckerをインスタンス化

		//doCheck()メソッドを使って、既入力・半角英数字・文字数を判定する
		loginIdErrorMessageList = inputChecker.doCheck("ユーザID",loginId,1,8,true,false,false,true,false,false,false,false,false);
		passwordErrorMessageList = inputChecker.doCheck("現在のパスワード",password,1,16,true,false,false,true,false,false,false,false,false);
		newPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード",newPassword,1,16,true,false,false,true,false,false,false,false,false);
		reConfirmationNewPasswordErrorMessageList = inputChecker.doCheck("新しいパスワード(再確認)",reConfirmationNewPassword,1,16,true,false,false,true,false,false,false,false,false);

		//doPasswordCheck()メソッドを使って、"新しいパスワード"と"(再確認)"の文字列が一致するか確認する
		newPasswordIncorrectErrorMessageList = inputChecker.doPasswordCheck(newPassword,reConfirmationNewPassword);


		//上記全てのエラーメッセージが無かった場合
		if(loginIdErrorMessageList.size() == 0
		&& passwordErrorMessageList.size() == 0
		&& newPasswordErrorMessageList.size() == 0
		&& reConfirmationNewPasswordErrorMessageList.size() == 0
		&& newPasswordIncorrectErrorMessageList.size() == 0) {

			UserInfoDAO userInfoDAO = new UserInfoDAO();  //UserInfoDAOをインスタンス化
			if(userInfoDAO.isExistUserInfo())

		}
	}

}
