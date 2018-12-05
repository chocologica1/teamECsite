package com.internousdev.sunflower.dto;

import java.util.Date;

public class CartInfoDTO {
	/**
	 *	カート情報テーブル(cart_info)から受け取るパラメータ
	 */
	private int id;
	private String userId;
	private String tempUserId;
	private int productId;
	private int productCount;
	private int price;
	private Date registDate;
	private Date updateDate;

	/**
	 * 	商品情報テーブル(product_info)から受け取るパラメータ
	 */
	private String productName;
	private String productNameKana;
	private String productDescription;
	private int categoryId;
	private String imageFilePath;
	private String imageFileName;
	private Date releaseDate;
	private String releaseCompany;
	private int status;

	/**	商品一品目の合計金額*/
	private int subtotal;

	//以下getter及びsetter

	public int getId(){
		return id;
	}

	public void setId(int id){
		this.id = id;
	}

	public String getUserId(){
		return userId;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getTempUserId(){
		return tempUserId;
	}

	public void setTempUserId(String tempUserId){
		this.tempUserId = tempUserId;
	}

	public int getProductId(){
		return productId;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductCount(){
		return productCount;
	}

	public void setProductCount(int productCount){
		this.productCount = productCount;
	}

	public int getPrice(){
		return price;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public Date getRegistDate(){
		return registDate;
	}

	public void setRegistDate(Date registDate){
		this.registDate = registDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}

	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana){
		this.productNameKana = productNameKana;
	}

	public String getProductDescription(){
		return productDescription;
	}

	public void setProductDescription(String productDescription){
		this.productDescription = productDescription;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public String getImageFilePath(){
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath){
		this.imageFilePath = imageFilePath;
	}

	public String getImageFileName(){
		return imageFileName;
	}

	public void setImageFileName(String imageFileName){
		this.imageFileName = imageFileName;
	}

	public Date getReleaseDate(){
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseCompany(){
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany){
		this.releaseCompany = releaseCompany;
	}

	public int getStatus(){
		return status;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getSubtotal(){
		return subtotal;
	}

	public void setSubtotal(int subtotal){
		this.subtotal = subtotal;
	}
}
