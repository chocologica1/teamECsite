package com.internousdev.sunflower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.sunflower.dto.UserInfoDTO;
import com.internousdev.sunflower.util.DBConnector;


public class UserInfoDAO {


	//ユーザー情報をDBに入れる
	public int createUser(String familyName, String firstName, String familyNameKana,
			String firstNameKana, String sex, String email, String loginId, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count=0;

		String sql ="insert into user_info(user_id,password,family_name,first_name,"
				+ " family_name_kana,first_name_kana,sex,email,status,logined,regist_date,update_date)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now(), now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, loginId);
			ps.setString(2, password);
			ps.setString(3, familyName);
			ps.setString(4, firstName);
			ps.setString(5, familyNameKana);
			ps.setString(6, firstNameKana);
			ps.setString(7, sex);
			ps.setString(8, email);
			ps.setInt(9,0);
			ps.setInt(10, 1);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return count;
	}

	//
	public boolean isExistsUserInfo(String loginId, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		boolean result = false;
		String sql = "select count(*) as count from user_info where user_id=? and password=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				if (rs.getInt("count") > 0) {
					result = true;
				}
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	//user_idとpasswordを紐付けて参照しユーザー情報を取り出す
	public UserInfoDTO getUserInfo(String loginId, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO  = new UserInfoDTO();
		String sql = "select * from user_info where user_id =? and password = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setLogined(rs.getInt("status"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	//user_idを参照してユーザー情報を取り出す
	public UserInfoDTO getUserInfo(String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		String sql ="SELECT * from user_info where user_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				userInfoDTO.setId(rs.getInt("id"));
				userInfoDTO.setUserId(rs.getString("user_id"));
				userInfoDTO.setPassword(rs.getString("password"));
				userInfoDTO.setFamilyName(rs.getString("family_name"));
				userInfoDTO.setFirstName(rs.getString("first_name"));
				userInfoDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(rs.getString("first_name_kana"));
				userInfoDTO.setSex(rs.getInt("sex"));
				userInfoDTO.setEmail(rs.getString("email"));
				userInfoDTO.setStatus(rs.getString("status"));
				userInfoDTO.setLogined(rs.getInt("logined"));
				userInfoDTO.setRegistDate(rs.getDate("regist_date"));
				userInfoDTO.setUpdateDate(rs.getDate("update_date"));
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return userInfoDTO;
	}

	//パスワード再設定
	public int resetPassword(String loginId, String password){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql ="update user_info set password = ? where user_id= ?";
		int result = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, password);
			ps.setString(2, loginId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	//ログイン
	public int login(String loginId, String password){

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "update user_info set logined=1 where user_id= ? and password= ?";
		int result = 0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ps.setString(2, password);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	//ログアウト
	public int logout(String loginId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql= "update user_info set logined=0 where user_id= ?";
		int result =0;
		try{
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, loginId);
			result =ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	//パスワードを*で隠す
	public String hiddenPassword(String password) {
		int beginIndex = 0;
		int endIndex = 1;
		if(password.length() > 1) {
			endIndex = 2;
		}
		StringBuilder stringBuilder = new StringBuilder("****************");

		String hiddenPassword = stringBuilder.replace(beginIndex, endIndex, password.substring(beginIndex,endIndex)).toString();
		return hiddenPassword;
	}

}
