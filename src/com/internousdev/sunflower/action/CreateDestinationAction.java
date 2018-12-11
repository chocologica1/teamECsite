package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String userAddress;
	private String telnumber;
	private String email;
	private Boolean createDestinationFlg;
	private Map<String, Object> session;

	public String execute(){
		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}
	String result = ERROR;

	//
	if(createDestinationFlg){
		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("userAddress");
		session.remove("telNumber");
		session.remove("email");
	}

	//セッションに残っているエラーメッセージを取り除いておく
	session.remove("familyNameErrorMessageList");
	session.remove("firstNameErrorMessageList");
	session.remove("familyNameKanaErrorMessageList");
	session.remove("firstNameKanaErrorMessageList");
	session.remove("userAddressErrorMessageList");
	session.remove("emailErrorMessageList");
	session.remove("telNumberErrorMessageList");

	result = SUCCESS;

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

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String gettelnumber() {
		return telnumber;
	}

	public void settelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setCreateDestinationFlg(boolean createDestinationFlg){
		this.createDestinationFlg = createDestinationFlg;
	}
}
