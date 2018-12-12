package com.internousdev.sunflower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.sunflower.dto.PurchaseHistoryInfoDTO;
import com.internousdev.sunflower.util.DBConnector;


public class PurchaseHistoryInfoDAO {


	// 商品購入履歴一覧の取得 (商品名・商品名かな・画像ファイルパス・画像ファイル名・単品価格・購入個数)
	public ArrayList<PurchaseHistoryInfoDTO> getPurchaseHistoryInfo(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();

		String sql="SELECT"
				+ " pi.product_name as product_name,"			// 商品名
				+ " pi.product_name_kana as product_name_kana,"	// ふりがな
				+ " pi.image_file_path as image_file_path,"		// 画像ファイルパス
				+ " pi.image_file_name as image_file_name,"		// 画像ファイル名
				+ " phi.price as price,"						// 単品価格
				+ " phi.product_count as product_count,"		// 個数
				+ " pi.release_date as release_date,"			// 発売年月日
				+ " pi.release_company as release_company"		// 発売会社名
				+ " FROM purchase_history_info as phi"
				+ " LEFT JOIN product_info as pi"
				+ " ON phi.product_id = pi.product_id"
				+ " WHERE phi.user_id = ?"
				+ " ORDER BY phi.regist_date DESC";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDTO.setProductName(rs.getString("product_name"));
				purchaseHistoryInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				purchaseHistoryInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				purchaseHistoryInfoDTO.setImageFileName(rs.getString("image_file_name"));
				purchaseHistoryInfoDTO.setPrice(rs.getInt("price"));
				purchaseHistoryInfoDTO.setProductCount(rs.getInt("product_count"));
				purchaseHistoryInfoDTO.setTotalPrice(rs.getInt("price")*rs.getInt("product_count"));
				purchaseHistoryInfoDTO.setReleaseDate(rs.getDate("release_date"));
				purchaseHistoryInfoDTO.setReleaseCompany(rs.getString("release_company"));
				purchaseHistoryInfoDTOList.add(purchaseHistoryInfoDTO);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return purchaseHistoryInfoDTOList;
	}

	// 購入商品情報をDBに格納
	public int regist(String loginId, int productId, int productCount, int price, int destinationId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO"
				+ " purchase_history_info"
				+ " (user_id, product_id, product_count, price, destination_id, regist_date, update_date)"
				+ " VALUES"
				+ " (?,?,?,?,?,now(),now())";
		int count = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginId);
			ps.setInt(2,productId);
			ps.setInt(3,productCount);
			ps.setInt(4,price);
			ps.setInt(5,destinationId);
			count = ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
		} finally {
			try{
				con.close();
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		return count;
	}

	// 商品購入履歴一覧の全削除
	public int allDelete(String loginId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql="DELETE FROM purchase_history_info where user_id =?";
		int count = 0;

		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loginId);
			count = ps.executeUpdate();
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count;
	}

}
