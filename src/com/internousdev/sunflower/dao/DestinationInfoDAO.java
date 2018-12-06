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
		ArrayList<DestinationInfoDTO> destinationList = new ArrayList<DestinationInfoDTO>();
		String sql ="SELECT"
				+ "id, family_name, first_name, family_name_kana, first_name_kana, email, tell_number, user_address"
				+ "FROM"
				+ "destination_info"
				+ "WHERE"
				+ "user_id = ?";

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
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}

		return destinationList;
	}

	public int insert(String userId, String familyName, String firstName, String familyNameKana, String firstNameKana, String)
}
