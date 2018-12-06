package com.internousdev.sunflower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.sunflower.util.DBConnector;

public class PurchaseHistoryInfoDAO {

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
			ps.setString(1, loginId);
			ps.setInt(2, productId);
			ps.setInt(3, productCount);
			ps.setInt(4, price);
			ps.setInt(5, destinationId);
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
}
