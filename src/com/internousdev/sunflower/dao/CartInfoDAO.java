package com.internousdev.sunflower.dao;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sunflower.dto.CartInfoDTO;

public class CartInfoDAO {

	/**
	 * 未実装です。
	 * カート内商品情報一覧を取得します。
	 *
	 * @param userId	ユーザーID
	 * @param tempUserId	仮ユーザーID
	 * @return	カート情報一覧をDTOListで戻します
	 */

	public List<CartInfoDTO> getCartInfoDTOList(String userId, String tempUserId) {
		List<CartInfoDTO> cartInfoDTOList = new ArrayList<>();
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
	public int delete(int productId, String usertId, String tempUserId) {
		return 0;
	}

}
