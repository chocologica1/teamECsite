package com.internousdev.sunflower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sunflower.dto.DestinationInfoDTO;
import com.internousdev.sunflower.util.DBConnector;

public class DestinationInfoDAO {

	/*ログインユーザのカート情報を取得する*/
	/*引数：ログインID*/
	public ArrayList<DestinationInfoDTO> getDestinationInfo(String loginId) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<DestinationInfoDTO> destinationDTOList = new ArrayList<DestinationInfoDTO>();
		String sql ="SELECT id, family_name, first_name, family_name_kana, first_name_kana, email, tell_number, user_address FROM destination_info WHERE user_id = ?";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DestinationInfoDTO dto = new DestinationInfoDTO();
				dto.setId(rs.getInt("id"));
				dto.setFamilyName(rs.getString("family_name"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setFamilyNameKana(rs.getString("family_name_kana"));
				dto.setFirstNameKana(rs.getString("first_name_kana"));
				dto.setEmail(rs.getString("email"));
				dto.setTelNumber(rs.getString("tell_number"));
				dto.setUserAddress(rs.getString("user_address"));
				destinationDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return destinationDTOList;
	}

	public int createDestination(String userId, String familyName, String firstName, String familyNameKana, String firstNameKana, String email, String tellNumber, String userAddress){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		int count =0;

		String sql="insert into destination_info(user_id,family_name,first_name,family_name_kana,first_name_kana,email,tell_number,user_address,regist_date,update_date)"
				+ " values(?,?,?,?,?,?,?,?,now(),now())";

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, familyName);
			ps.setString(3, firstName);
			ps.setString(4, familyNameKana);
			ps.setString(5, firstNameKana);
			ps.setString(6, email);
			ps.setString(7, tellNumber);
			ps.setString(8, userAddress);
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
}
