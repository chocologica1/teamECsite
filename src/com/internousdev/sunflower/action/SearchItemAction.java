package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.MCategoryDAO;
import com.internousdev.sunflower.dto.MCategoryDTO;
import com.internousdev.sunflower.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware {

	private String categoryId;
	private String keywords;
	private String pageNo;
	private List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
	private List<String> keywordsErrorMessageList = new ArrayList<String>();
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
	private Map<String, Object> session;

	public String execute(){

		String result = ERROR;
		session.remove("keywordsErrorMessageList");
        InputChecker inputChecker = new InputChecker();

        if(StringUtils.isBlank(keywords)){
        	keywords = "";
        }else {
        	keywords = keywords.replaceAll("　", " ").replaceAll("\\s{2,}", " ");
        }

        if(!(keywords.equals(""))){
        	keywordsErrorMessageList = inputChecker.doCheck("検索ワード", keywords, 0, 16, true, true, true, true, false, true, false, true, true);

        	Iterator<String> iterator = keywordsErrorMessageList.iterator();

        	if(iterator.hasNext()){
        		session.put("keywordsErrorMessageList", keywordsErrorMessageList);
        		return SUCCESS;
        	}
        }

        ProductInfoDAO productInfoDAO = new ProductInfoDAO();

        switch (categoryId){
          case"1":
            productInfoDTOList = productInfoDAO.getProductInfoListAll(keywords.split(" "));
            result = SUCCESS;
            break;

          default:
        	productInfoDTOList = productInfoDAO.getProductionInfoListByKeywords(keywords.split(" "), categoryId);
        	result = SUCCESS;
        	break;
        }

        Iterator<ProductInfoDTO> iterator = productInfoDTOList.Iterator();
        if(!(iterator.hasNext())){
        	productInfoDTOList = null;
        }

        if(!session.containsKey("mCategoryList")){
        	MCategoryDAO mCategoryDAO = new MCategoryDAO();
        	mCategoryDTOList = mCategoryDAO.getMCategoryList();
        	session.put("mCategoryDTOList", mCategoryDTOList);
        }
	}

	public String getPageNo(){
		return pageNo;
	}

	public void setPageNo(String pageNo){
		this.pageNo = pageNo;
	}

	public String getKeywords(){
		return keywords;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public List<MCategoryDTO> getmCategoryDTOList(){
		return mCategoryDTOList;
	}

	public void setmCategoryList(List<MCategoryDTO> mCategoryDTOList){
		this.mCategoryDTOList = mCategoryDTOList;
	}

	public List<String> getKeywordsErrorMessageList(){
		return keywordsErrorMessageList;
	}

	public void setKeywordsErrorMessageList(List<String> keywordsErrorMessageList){
		this.keywordsErrorMessageList = keywordsErrorMessageList;
	}

	public List<ProductInfoDTO> productInfoDTOList(){
		return productInfoDTOList;
	}

	public void setProductInfoDTOList(List<ProductInfoDTO> productInfoDTOList){
		this.productInfoDTOList = productInfoDTOList;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

}
