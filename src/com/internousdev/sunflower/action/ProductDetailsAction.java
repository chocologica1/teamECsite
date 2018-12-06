package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.internousdev.sunflower.dao.ProductInfoDAO;
import com.internousdev.sunflower.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport {
	//フィールド
		//商品詳細
	private int productId;
	private String productName;
	private String productNameKana;
	private int price;
	private String releaseCompany;
	private Date registDate;
	private String productDescription;
		//関連商品
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

	//メソッド
	public String execute() {

		String result = ERROR;
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		//商品詳細を取得
		productInfoDTO = productInfoDAO.getProductInfo(productId);
		productName = productInfoDTO.getProductName();
		productNameKana = productInfoDTO.getProductNameKana();
		price = productInfoDTO.getPrice();
		releaseCompany = productInfoDTO.getReleaseCompany();
		registDate = productInfoDTO.getRegistDate();
		productDescription = productInfoDTO.getProductDescription();

		//関連商品を3つ取得
		int categoryId = productInfoDTO.getCategoryId();
		productInfoDTOList = productInfoDAO.getProductInfoListByCategoryId(categoryId, productId, 0 ,3);

		result = SUCCESS;
		return result;

	}

	//アクセサ
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductNameKana() {
		return productNameKana;
	}

	public int getPrice() {
		return price;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}

	public Date getRegistDate() {
		return registDate;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

}
