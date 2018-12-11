package com.internousdev.sunflower.action;

import java.util.ArrayList;
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
	private int[] productIdArray;

	private CartInfoDAO cartInfoDAO = new CartInfoDAO();

	private List<CartInfoDTO> cartInfoDTOList = null;

	private int totalPrice;

	/**
	 * カート画面から受け取った削除対象の商品IDを元にCartInfoDAOのdeleteメソッドを呼び出しカートから商品を削除します。<br>
	 * 削除に成功した場合カート情報テーブルの情報を再取得、カート画面に遷移します。<br>
	 * 削除に失敗した場合エラー画面に遷移します。
	 */

	public String execute(){
		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}
		List<Integer> resultList = new ArrayList<>();
		String result = ERROR;



		//deleteメソッドを全削除対象商品IDを引数に指定して呼び出し、戻り値をresultListに格納
		for(int productId : productIdArray){
			resultList.add(cartInfoDAO.delete(productId,String.valueOf(session.get("loginId")),String.valueOf(session.get("tempUserId"))));
		}

		//resultListに0(削除失敗)があるかどうかを判定
		if(resultList.size() > 0){
			result = SUCCESS;
			for(Integer i:resultList){
				result = i > 0 ? result : ERROR;
			}
		}

		//cartInfoDTOList及び合計金額の読み込み
		cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(String.valueOf(session.get("loginId")), String.valueOf(session.get("tempUserId")));
		totalPrice = cartInfoDAO.getTotalPrice(String.valueOf(session.get("loginId")),String.valueOf(session.get("tempUserId")));

		return result;
	}

	//以下getter及びsetter



	public void setProductIdArray(int[] productIdArray){
		this.productIdArray = productIdArray;
	}

	public List<CartInfoDTO> getCartInfoDTOList(){
		return cartInfoDTOList;
	}

	public int getTotalPrice(){
		return totalPrice;
	}

	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object> session){
		this.session = session;
	}
}
