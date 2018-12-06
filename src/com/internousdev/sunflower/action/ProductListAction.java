package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.List;

import com.internousdev.sunflower.dao.ProductInfoDAO;
import com.internousdev.sunflower.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductListAction extends ActionSupport {
	//フィールド
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

	//メソッド（商品一覧を取得するだけ）
	public String execute() {
		String result = ERROR;
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		productInfoDTOList = productInfoDAO.getProductInfoList();
		if (productInfoDTOList.size() != 0) {
			result = SUCCESS;
		}
		return result;
	}

	//アクセサ
	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}
}
