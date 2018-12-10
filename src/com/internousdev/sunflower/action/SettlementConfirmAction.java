package com.internousdev.sunflower.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.DestinationInfoDAO;
import com.internousdev.sunflower.dto.DestinationInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware{
	private Map<String, Object> session;
	private String id;
	private String familyName;
	private String firstName;
	private String address;
	private String telNumber;
	private String email;
	ArrayList<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<DestinationInfoDTO>();

	public String execute(){
		String result = "";
		/*宛先情報取得用DAO*/
		DestinationInfoDAO destinationDao = new DestinationInfoDAO();
		/*宛先情報を格納する変数リスト*/

		/*ログインしている場合*/
		if((session.containsKey("loginFlg"))){
			try{
				/*DBから宛先情報のリストを取得する*/
				destinationInfoDTOList = destinationDao.getDestinationInfo(String.valueOf(session.get("loginId"))); //デバック時にコメントアウト

				/*宛先情報リストが空の場合*/
				Iterator<DestinationInfoDTO> iterator = destinationInfoDTOList.iterator();
				if(!(iterator.hasNext())){
					destinationInfoDTOList = null;
				}

				/*セッションに宛先情報リストを入れる*/
				session.put("destinationInfoDTOList", destinationInfoDTOList);

			}
			catch(SQLException e){
				e.printStackTrace();
			}

			/*決済確認画面へ遷移するための戻り値*/
			result = SUCCESS;
		}

		/*ログインしていない場合*/
		else{
			/*カートフラグを立てる*/
			session.put("cartFlg", true);

			/*ログイン画面へ遷移するための戻り値*/
			result = ERROR;
		}

		return result;
	}
	/*以下セッター＆ゲッター*/


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public ArrayList<DestinationInfoDTO> getDestinationInfoDTOList() {
		return destinationInfoDTOList;
	}


	public void setDestinationInfoDTOList(ArrayList<DestinationInfoDTO> destinationInfoDTOList) {
		this.destinationInfoDTOList = destinationInfoDTOList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
