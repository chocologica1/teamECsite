package com.internousdev.sunflower.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sunflower.dto.CartInfoDTO;
import com.internousdev.sunflower.util.DBConnector;

public class CartInfoDAO {

	private DBConnector db = new DBConnector();

	/**
	 * 未実装です。
	 * カート内商品情報一覧を取得します。
	 *
	 * @param loginId	ユーザーID
	 * @param tempUserId	仮ユーザーID
	 * @return	カート情報一覧をDTOListで戻します
	 */

	public List<CartInfoDTO> getCartInfoDTOList(String loginId, String tempUserId) {
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
				+ "pi.category_id,"
				+ "pi.image_file_path,"
				+ "pi.image_file_name,"
				+ "pi.release_date,"
				+ "pi.release_company,"
				+ "pi.status"
				+ "FROM cart_info ci"
				+ "LEFT JOIN product_info pi"
				+ "ON ci.product_id = pi.product_id"
				+ "WHERE user_id = ? OR temp_user_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try{con.close();}catch(SQLException e){}
		}
		return cartInfoDTOList;
	}

	/**
	 * 未実装です。
	 * カート内の商品一品目を削除します。
	 *
	 * @param productId	削除対象の商品ID
	 * @param usertId	ユーザーID
	 * @param tempUserId	仮ユーザーID
	 * @return	削除に成功した場合正の整数、失敗した場合は0を戻します
	 */
	public int delete(int productId, String loginId, String tempUserId) {
		return 0;
	}

	/**
	 * 未実装です。
	 * カート内に商品を追加します。
	 * @param productId	追加する商品ID
	 * @param productCount	追加する個数
	 * @param loginId	ユーザーID
	 * @param tempUserId	仮ユーザーID
	 * @return	追加に成功した場合正の整数、失敗した場合は0を戻します
	 */

	public int regist(int productId, int productCount, String loginId, String tempUserId) {
		return 0;
	}

	/**
	 * 未実装です。
	 * ログインIDと仮ログインIDで保持していたカート情報をリンクさせます。
	 * @param tempUserId	仮ログインID
	 * @param LoginId	ユーザID
	 * @return	追加に成功した場合正の整数、失敗した場合は0を戻します
	 */
	public int linkToLoginId(String tempUserId,String loginId){
		return 0;
	}

	/**
	 * 未実装です。
	 * カート内の全ての商品の合計金額を戻します。
	 * @param tempUserId	仮ログインID
	 * @param loginId	ユーザーID
	 * @return	合計金額を戻します
	 */
	public int getTotalPrice(String tempUserId,String loginId){
		return 0;
	}

	/**
	 * 未実装です。
	 * カート内に指定された商品があるかを調べます。
	 * @param productId
	 * @param loginId
	 * @param tempUserId
	 * @return	指定された商品があるかboolean値で戻します。
	 */
	public boolean existsProduct(int productId,String loginId,String tempUserId){
		return false;
	}

	/**
	 * 未実装です。
	 * カート内の全ての商品を削除します。
	 * @param loginId	ユーザーID
	 * @return	削除に成功した場合、削除件数（品目数）をintで戻します。削除されていない場合0を戻します。
	 */
	public int deleteAll(String loginId){
		return 0;
	}

	/**
	 * 未実装です。
	 * 既にカートに入ってある商品の個数を変更します。
	 * @param productId	対象の商品ID
	 * @param count	個数です。この数量をカート情報テーブルのproduct_countに足します。
	 * @param loginId	ユーザーID
	 * @param tempUserId	仮ユーザーID
	 */
	public void addCount(int productId,int count,String loginId,String tempUserId){

	}
}
