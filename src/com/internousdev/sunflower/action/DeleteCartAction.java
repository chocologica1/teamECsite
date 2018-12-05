package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.CartInfoDAO;
import com.internousdev.sunflower.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
public class DeleteCartAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;

	/**
	 * cart.jspから削除対象の商品IDを受け取る<br>
	 * key、value共に商品ID
	 */
	private Map<Integer,Integer> productIdMap = new HashMap<>();

	private CartInfoDAO cartInfoDAO = new CartInfoDAO();

	private List<CartInfoDTO> cartInfoDTOList = null;

	/**
	 * カート画面から受け取った削除対象の商品IDを元にCartInfoDAOのdeleteメソッドを呼び出しカートから商品を削除します。<br>
	 * 削除に成功した場合カート情報テーブルの情報を再取得、カート画面に遷移します。<br>
	 * 削除に失敗した場合エラー画面に遷移します。
	 */

	public String execute(){
		List<Integer> resultList = new ArrayList<>();
		boolean existError = false;

		//deleteメソッドの呼び出し、戻り値をresultListに格納
		for(Integer productId : productIdMap.keySet()){
			resultList.add(cartInfoDAO.delete(productId,String.valueOf(session.get("userId")),String.valueOf(session.get("tempUserId"))));
		}

		//resultListに0(削除失敗)があるかどうかを判定、existErrorにboolean値を格納
		for(Integer i:resultList){
			existError = i <= 0 ? true : existError;
		}

		//cartInfoDTOListの読み込み
		cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(String.valueOf(session.get("userId")), String.valueOf(session.get("tempUserId")));

		//existErrorがtrueの場合SUCCESS、falseの場合ERRORを戻す
		return existError ? SUCCESS : ERROR;
	}

	//以下getter及びsetter

	public void setProductIdMap(Map<Integer,Integer> productIdMap){
		this.productIdMap = productIdMap;
	}

	public List<CartInfoDTO> getCartInfoDTOList(){
		return cartInfoDTOList;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
