package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String loginId;
	private String password;

	private List<String> familyNameErrorMessage = new ArrayList<String>();
	private List<String> firstNameErrorMessage = new ArrayList<String>();
	private List<String> familyNameKanaErrorMessage = new ArrayList<String>();
	private List<String> firstNameKanaErrorMessage = new ArrayList<String>();
	private List<String> emailErrorMessage = new ArrayList<String>();
	private List<String> loginIdErrorMessage = new ArrayList<String>();
	private List<String> passwordErrorMessage = new ArrayList<String>();

	private String categoryId;

	public String execute(){

		String result =ERROR;
		InputChecker inputChecker =new InputChecker();

		session.put("familyName",familyName);
		session.put("firstName",firstName);
		session.put("familyNameKana",familyNameKana);
		session.put("firstNameKana",firstNameKana);
		session.put("sex",sex);
		session.put("email",email);
		session.put("loginId",loginId);

		familyNameErrorMessageList = inputChecker.doCheck("姓",familyName,1, 16, true, true, true, false, false, false, false, false, false);
		firstNameErrorMessageList = inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, false, false, false, false);
		familyNameKanaErrorMessageList = inputChecker.doCheck("姓ふりがな",familyNameKana,1, 16, false, false, true, false, false, false, false, false, false);
		firstNameKanaErrorMessageList = inputChecker.doCheck("名ふりがな",firstNameKana,1, 16, false, false, true, false, false, false, false, false, false);
		emailErrorMessageList = inputChecker.doCheck("メールアドレス", email, 10, 32, true, false, false, true, true, false, false, false, false);
		loginIdErrorMessageList = inputChecker.doCheck("ユーザID", loginId, true, false, false, true, true, false, false, false, false, false, false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false, false, false);


		if(familyNameErrorMessageList.size()==0
				&& firstNameErrorMessageList.size()==0
				&& familyNameKanaErrorMessageList.size()==0
				&& firstNameKkanaErrorMessageList.size()==0
				&& emailErrorMessageList.size()==0
				&& loginIdErrorMessageList.size()==0
				&& passwordErrorMessageList.size()==0) {
			result = SUCCESS;
		}else{
			session.put("familyNameErrorMessageList", familyNameErrorMessageList);
			session.put("firstNameErrorMessageList", firstNameErrorMessageList);
			session.put("familyNameKanaErrorMessageList", familyNameKanaErrorMessageList);
			session.put("firstNameKanaErrorMessageList", firstNameKanaErrorMessageList);
			session.put("emailErrorMessageList", emailErrorMessageList);
			session.put("loginIdErrorMessageList", loginIdErrorMessageList);
			session.put("passwordErrorMessageList", passwordErrorMessageList);
			result = ERROR;
		}
		return result;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getFamilyNameErrorMessage() {
		return familyNameErrorMessage;
	}

	public void setFamilyNameErrorMessage(List<String> familyNameErrorMessage) {
		this.familyNameErrorMessage = familyNameErrorMessage;
	}

	public List<String> getFirstNameErrorMessage() {
		return firstNameErrorMessage;
	}

	public void setFirstNameErrorMessage(List<String> firstNameErrorMessage) {
		this.firstNameErrorMessage = firstNameErrorMessage;
	}

	public List<String> getFamilyNameKanaErrorMessage() {
		return familyNameKanaErrorMessage;
	}

	public void setFamilyNameKanaErrorMessage(List<String> familyNameKanaErrorMessage) {
		this.familyNameKanaErrorMessage = familyNameKanaErrorMessage;
	}

	public List<String> getFirstNameKanaErrorMessage() {
		return firstNameKanaErrorMessage;
	}

	public void setFirstNameKanaErrorMessage(List<String> firstNameKanaErrorMessage) {
		this.firstNameKanaErrorMessage = firstNameKanaErrorMessage;
	}

	public List<String> getEmailErrorMessage() {
		return emailErrorMessage;
	}

	public void setEmailErrorMessage(List<String> emailErrorMessage) {
		this.emailErrorMessage = emailErrorMessage;
	}

	public List<String> getLoginIdErrorMessage() {
		return loginIdErrorMessage;
	}

	public void setLoginIdErrorMessage(List<String> loginIdErrorMessage) {
		this.loginIdErrorMessage = loginIdErrorMessage;
	}

	public List<String> getPasswordErrorMessage() {
		return passwordErrorMessage;
	}

	public void setPasswordErrorMessage(List<String> passwordErrorMessage) {
		this.passwordErrorMessage = passwordErrorMessage;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

}



