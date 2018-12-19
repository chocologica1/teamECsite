package com.internousdev.sunflower.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.DestinationInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateDestinationCompleteAction extends ActionSupport implements SessionAware{

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String userAddress;
	private String telNumber;
	private String email;
	private Map<String, Object> session;

	public String execute(){
		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}

		if((!session.containsKey("loginId")) || (!session.containsKey("familyName"))
			|| (!session.containsKey("firstName")) || (!session.containsKey("familyNameKana"))
			|| (!session.containsKey("firstNameKana")) || (!session.containsKey("email"))
			|| (!session.containsKey("telNumber")) || (!session.containsKey("userAddress"))){
			return "timeOut";
		}

		String result = ERROR;
		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();

		int count = destinationInfoDAO.createDestination(session.get("loginId").toString(),session.get("familyName").toString(), session.get("firstName").toString(), session.get("familyNameKana").toString(), session.get("firstNameKana").toString(), session.get("email").toString(), session.get("telNumber").toString(), session.get("userAddress").toString());
		if(count >0){
			result = SUCCESS;
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

	public String getUseraddress() {
		return userAddress;
	}

	public void setUseraddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String gettelNumber() {
		return telNumber;
	}

	public void settelNumber(String telNumber) {
		this.telNumber = telNumber;
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

}
