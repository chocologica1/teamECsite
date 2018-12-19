package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.ProductInfoDAO;
import com.internousdev.sunflower.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {
	//フィールド
		//商品詳細
	private int productId;
	private String imageFilePath;
	private String imageFileName;
	private String productName;
	private String productNameKana;
	private int price;
	private String releaseCompany;
	private Date releaseDate;
	private String productDescription;
		//関連商品
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		//セッション
	private Map<String,Object> session;

	//メソッド
	public String execute() {

		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}

		String result = ERROR;
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		//商品詳細を取得
		productInfoDTO = productInfoDAO.getProductInfo(productId);
		imageFilePath = productInfoDTO.getImageFilePath();
		imageFileName = productInfoDTO.getImageFileName();
		productName = productInfoDTO.getProductName();
		productNameKana = productInfoDTO.getProductNameKana();
		price = productInfoDTO.getPrice();
		releaseCompany = productInfoDTO.getReleaseCompany();
		releaseDate = productInfoDTO.getReleaseDate();
		productDescription = productInfoDTO.getProductDescription();

		//ない商品情報へのアクセス阻止
		if(imageFilePath == null){
			return ERROR;
		}

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

	public String getImageFilePath() {
		return imageFilePath;
	}

	public String getImageFileName() {
		return imageFileName;
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

	public Date getReleaseDate() {
		return releaseDate;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

	@Override
	public void setSession(Map<String,Object> session) {
		this.session = session;
	}

}
