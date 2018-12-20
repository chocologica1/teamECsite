package com.internousdev.sunflower.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sunflower.dto.CartInfoDTO;
import com.internousdev.sunflower.util.DBConnector;

public class CartInfoDAO {

	private DBConnector db = new DBConnector();

	/**
	 * カート内商品情報一覧を取得します。
	 *
	 * @param userId	ユーザーID
	 * @param tempUserId	仮ユーザーID(session内"tempUserId")
	 * @return	カート情報一覧をDTOListで戻します
	 */

	public List<CartInfoDTO> getCartInfoDTOList(String userId, String tempUserId) {
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<>();
		Connection con = db.getConnection();
		String sql = "SELECT "
				+ "ci.id,"
				+ "ci.user_id,"
				+ "ci.temp_user_id,"
				+ "ci.product_id,"
				+ "ci.product_count,"
				+ "pi.price,"
				+ "ci.regist_date,"
				+ "ci.update_date,"
				+ "pi.product_name,"
				+ "pi.product_name_kana,"
				+ "pi.product_description,"
				+ "pi.image_file_path,"
				+ "pi.image_file_name,"
				+ "pi.release_date,"
				+ "pi.release_company,"
				+ "pi.status "
				+ "FROM cart_info ci "
				+ "LEFT JOIN product_info pi "
				+ "ON ci.product_id = pi.product_id "
				+ "WHERE user_id = ? OR temp_user_id = ? "
				+ "ORDER BY ci.regist_date DESC";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, tempUserId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CartInfoDTO dto = new CartInfoDTO();
				dto.setId(rs.getInt("ci.id"));
				dto.setUserId(rs.getString("ci.user_id"));
				dto.setTempUserId(rs.getString("ci.temp_user_id"));
				dto.setProductId(rs.getInt("ci.product_id"));
				dto.setProductCount(rs.getInt("ci.product_count"));
				dto.setPrice(rs.getInt("pi.price"));
				dto.setRegistDate(rs.getDate("ci.regist_date"));
				dto.setUpdateDate(rs.getDate("ci.update_date"));
				dto.setProductName(rs.getString("pi.product_name"));
				dto.setProductNameKana(rs.getString("pi.product_name_kana"));
				dto.setImageFilePath(rs.getString("pi.image_file_path"));
				dto.setImageFileName(rs.getString("pi.image_file_name"));
				dto.setReleaseDate(rs.getDate("pi.release_date"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setStatus(rs.getInt("pi.status"));
				dto.setSubtotal(dto.getPrice() * dto.getProductCount());
				cartInfoDTOList.add(dto);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
		return cartInfoDTOList;
	}

	/**
	 * カート内の商品一品目を削除します。
	 *
	 * @param productId	削除対象の商品ID
	 * @param usertId	ユーザーID
	 * @param tempUserId	仮ユーザーID
	 * @return	削除に成功した場合正の整数、失敗した場合は0を戻します
	 */
	public int delete(int productId, String userId, String tempUserId) {
		int result = 0;
		Connection con = db.getConnection();
		String sql = "DELETE FROM cart_info WHERE product_id = ? AND (user_id = ? OR temp_user_id = ?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setString(2, userId);
			ps.setString(3, tempUserId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
		return result;
	}

	/**
	 * カート内に商品を追加します。<br>
	 * カート内に同じ商品が既に存在した場合(existsProductメソッドで判定)、該当商品の個数を変更します。(addCountメソッドの呼び出し)
	 * @param productId	追加する商品ID
	 * @param productCount	追加する個数
	 * @param userId	ユーザーID
	 * @param tempUserId	仮ユーザーID
	 * @return	追加に成功した場合正の整数、失敗した場合は0を戻します
	 */

	public int regist(int productId, int productCount, String userId, String tempUserId) {
		int result = 0;
		int price = 0;

		//プロダクトIDが不正な場合0を戻す
		if(!isRightProductId(productId))return 0;

		//同じ商品が既にカートに入っていた場合、該当商品の個数を変更
		if(existsProduct(productId,userId,tempUserId)){
			result = addCount(productId,productCount,userId,tempUserId);
		}else{
			//userIdがnullの場合tempUserIdを代入
			userId = userId == null || "null".equals(userId) || userId.isEmpty() ? tempUserId : userId;
			Connection con = db.getConnection();
			String sql = "INSERT INTO cart_info(product_id,product_count,user_id,temp_user_id,price,regist_date,update_date) VALUES(?,?,?,?,?,now(),now())";
			price = getPrice(productId);
			try{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, productId);
				ps.setInt(2, productCount);
				ps.setString(3, userId);
				ps.setString(4, tempUserId);
				ps.setInt(5, price);
				result = ps.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				try{con.close();}catch(SQLException e){}
			}
		}
		return result;
	}

	/**
	 * 商品の価格を取得します
	 * @param productId	商品ID
	 * @return	商品価格
	 */

	public int getPrice(int productId){
		int result = 0;
		String sql = "SELECT price FROM product_info WHERE product_id = ?";
		Connection con = db.getConnection();
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) result = rs.getInt("price");
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
		return result;
	}

	/**
	 * ログインIDと仮ログインIDで保持していたカート情報をリンクさせます。
	 * @param tempUserId	仮ログインID
	 * @param LoginId	ユーザID
	 */
	public void linkToLoginId(String userId,String tempUserId){
		Connection con = db.getConnection();
		String sql = "UPDATE cart_info SET user_id = ? , temp_user_id = NULL , update_date = now() WHERE temp_user_id = ?";

		//user_idを持つカート情報を呼び出し、現在のtemp_user_idに紐づけて登録する
		List<CartInfoDTO> cartInfoDTOList = getCartInfoDTOList(userId,null);
		for(CartInfoDTO dto:cartInfoDTOList){
			regist(dto.getProductId(),dto.getProductCount(),tempUserId,tempUserId);
		}
		deleteAll(userId);

		//現在のtemp_user_idに紐づいたカート情報をuser_idと紐付ける
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, tempUserId);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
	}

	/**
	 * カート内の全ての商品の合計金額を戻します。
	 * @param tempUserId	仮ログインID
	 * @param userId	ユーザーID
	 * @return	合計金額を戻します
	 */
	public int getTotalPrice(String userId,String tempUserId){
		int result = 0;
		List<CartInfoDTO> cartInfoDTOList = getCartInfoDTOList(userId,tempUserId);
		for(CartInfoDTO dto : cartInfoDTOList){
			result += dto.getSubtotal();
		}
		return result;
	}

	/**
	 * カート内に指定された商品があるかを調べます。
	 * @param productId
	 * @param userId
	 * @param tempUserId
	 * @return	指定された商品があるかboolean値で戻します。
	 */
	public boolean existsProduct(int productId,String userId,String tempUserId){
		boolean result = false;
		Connection con = db.getConnection();
		String sql = "SELECT * FROM cart_info WHERE product_id = ? AND (user_id = ? OR temp_user_id = ?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setString(2, userId);
			ps.setString(3, tempUserId);
			ResultSet rs = ps.executeQuery();
			result = rs.next();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
		return result;
	}

	/**
	 * カート内の全ての商品を削除します。
	 * @param userId	ユーザーID
	 * @return	削除に成功した場合、削除件数（品目数）をintで戻します。削除されていない場合0を戻します。
	 */
	public int deleteAll(String userId){
		Connection con = db.getConnection();
		String sql = "DELETE FROM cart_info WHERE user_id = ?";
		int result = 0;
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
		return result;
	}

	/**
	 * 既にカートに入っている商品の個数を変更します。
	 * @param productId	対象の商品ID
	 * @param count	個数です。この数量をカート情報テーブルのproduct_countに足します。
	 * @param userId	ユーザーID
	 * @param tempUserId	仮ユーザーID
	 */
	public int addCount(int productId,int productCount,String userId,String tempUserId){
		int result = 0;
		Connection con = db.getConnection();
		String sql = "UPDATE cart_info SET product_count = product_count + ? , update_date = now() WHERE product_id = ? AND (user_id = ? OR temp_user_id = ?)";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productCount);
			ps.setInt(2, productId);
			ps.setString(3, userId);
			ps.setString(4, tempUserId);
			result = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
		return result;
	}

	/**
	 * 商品IDがデータベース上に存在するかどうか判別します。
	 * @param productId　商品ID
	 * @return　存在する商品IDかどうかboolean値で戻す
	 */
	public boolean isRightProductId(int productId){
		boolean result = false;
		Connection con = db.getConnection();
		String sql = "SELECT * FROM product_info WHERE product_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			result = rs.next();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
		return result;
	}
}
