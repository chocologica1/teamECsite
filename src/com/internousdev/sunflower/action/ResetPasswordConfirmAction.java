package com.internousdev.sunflower.action;

import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport{
	private String userId;
	private String nowPassword;
	private String newPassword;
	private String newPasswordConfirm;
	private String errorMessage1; //ユーザIDの未入力についてのエラーメッセージ
	private String errorMessage2; //ユーザIDの文字種についてのエラーメッセージ
	private String errorMessage3; //ユーザIDの文字数についてのエラーメッセージ
	private String errorMessage4; //

	public String execute() {
		String result = ERROR;  //始めはエラーにしておく

		/*ユーザIDが未入力でない,ユーザIDが全て半角英数字,ユーザIDの文字数が1～8字のとき
		 *ユーザIDが未入力でない,ユーザIDが全て半角英数字,ユーザIDの文字数が1～8字のとき */
		if ((userId.length() != 0) && (userId /**/) && (userId.length() >= 1 && userId.length() <= 8) &&
			(nowPassword.length() != 0) && (nowPassword /**/) && (nowPassword.length() >= 1 && nowPassword.length() <= 16) &&
			(newPassword.length() != 0) && (newPassword /**/) && (newPassword.length() >= 1 && newPassword.length() <= 16) &&
			(newPassword.equals(newPasswordConfirm))) {

			result = SUCCESS;

		} else if (userId.length() == 0) {  //ユーザIDが未入力のとき
			result = ERROR;
			errorMessage1 = "ユーザIDを入力してください。";

		} else if (userId /**/) {  //ユーザIDが半角英数字でないとき
			result = ERROR;
			errorMessage2 = "ユーザIDは半角英数字で入力してください。";

		} else if (userId.length() > 8) {  //ユーザIDの文字数が適当でないとき
			result = ERROR;
			errorMessage3 = "ユーザIDは1文字以上8文字以下で入力してください。";
		}
		return result;
	}







	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getErrorMessage1() {
		return errorMessage1;
	}
	public void setErrorMessage1(String errorMessage1) {
		this.errorMessage1 = errorMessage1;
	}

	public String getErrorMessage2() {
		return errorMessage2;
	}
	public void setErrorMessage2(String errorMessage2) {
		this.errorMessage2 = errorMessage2;
	}

	public String getErrorMessage3() {
		return errorMessage3;
	}
	public void setErrorMessage3(String errorMessage3) {
		this.errorMessage3 = errorMessage3;
	}

	public String getErrorMessage4() {
		return errorMessage4;
	}
	public void setErrorMessage4(String errorMessage4) {
		this.errorMessage4 = errorMessage4;
	}

	public String getNowPassword() {
		return nowPassword;
	}
	public void setNowPassword(String nowPassword) {
		this.nowPassword = nowPassword;
	}

	public String getNewPasswordConfirm() {
		return newPasswordConfirm;
	}
	public void setNewPasswordConfirm(String newPasswordConfirm) {
		this.newPasswordConfirm = newPasswordConfirm;
	}



}
