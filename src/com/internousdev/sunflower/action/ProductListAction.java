package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.ProductInfoDAO;
import com.internousdev.sunflower.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport implements SessionAware {
	//フィールド
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String,Object> session;

	//メソッド
	public String execute() {

		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}

		//sessionに検索エラーが入っていたら切る
		session.remove("keywordsErrorMessageList");

		//商品一覧を取得
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		productInfoDTOList = productInfoDAO.getProductInfoList();

		return SUCCESS;
	}

	//アクセサ
	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
