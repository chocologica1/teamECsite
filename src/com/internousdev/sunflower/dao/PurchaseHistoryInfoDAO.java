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

		String sql="SELECT pi.product_name, pi.product_name_kana, pi.image_file_path, pi.image_file_name, phi.price, phi.product_count"
				+ "FROM product_info pi"
				+ "LEFT JOIN purchase_history_info phi"
				+ "ON pi.product_id = phi.product_id"
				+ "WHERE phi.user_id = ?"
				+ "ORDER BY regist_date"
				+ "DESC";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,loginId);
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDTO.setProductName(rs.getString("product_name"));
				purchaseHistoryInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				purchaseHistoryInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				purchaseHistoryInfoDTO.setImageFileName(rs.getString("image_file_name"));
				purchaseHistoryInfoDTO.setPrice(rs.getInt("price"));
				purchaseHistoryInfoDTO.setProductCount(rs.getInt("product_count"));
				purchaseHistoryInfoDTO.setTotalPrice(rs.getInt("price")*rs.getInt("product_count"));
				purchaseHistoryInfoDTOList.add(purchaseHistoryInfoDTO);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return purchaseHistoryInfoDTOList;
	}



	// 購入商品情報をDBに格納
	public int regist(String loginId, int productId, int productCount, int price, int destinationId){
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "INSERT INTO"
				+ "purchase_history_info"
				+ "(user_id, product_id, product_count, price, destination_id, regist_date)"
				+ "VALUES"
				+ "(?,?,?,?,?,now())";
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
		}
		try{
			con.close();
		}
		catch(SQLException e){
			e.printStackTrace();
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
		}
		try {
			con.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}




}
