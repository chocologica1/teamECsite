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
	private String userAdress;
	private String tellNumber;
	private String email;
	private String categoryId;
	private Map<String, Object> session;

	public String execute(){
		String result = ERROR;
		DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();

		System.out.println(session.get("familyName"));
		System.out.println(session.get("firstName"));
		System.out.println(session.get("familyNameKana"));
		System.out.println(session.get("firstNameKana"));
		System.out.println(session.get("userAdress"));
		System.out.println(session.get("tellNumber"));
		System.out.println(session.get("email"));

		int count = destinationInfoDAO.createDestination(session.get("loginId").toString(),session.get("familyName").toString(), session.get("firstName").toString(), session.get("familyNameKana").toString(), session.get("firstNameKana").toString(), session.get("userAdress").toString(), session.get("tellNumber").toString(), session.get("email").toString());
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

	public String getUserAdress() {
		return userAdress;
	}

	public void setUserAdress(String userAdress) {
		this.userAdress = userAdress;
	}

	public String getTellNumber() {
		return tellNumber;
	}

	public void setTellNumber(String tellNumber) {
		this.tellNumber = tellNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
