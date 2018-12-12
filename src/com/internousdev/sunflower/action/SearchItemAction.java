package com.internousdev.sunflower.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.sunflower.dao.MCategoryDAO;
import com.internousdev.sunflower.dao.ProductInfoDAO;
import com.internousdev.sunflower.dto.MCategoryDTO;
import com.internousdev.sunflower.dto.ProductInfoDTO;
import com.internousdev.sunflower.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class SearchItemAction extends ActionSupport implements SessionAware {

	private int categoryId;
	private String keywords;
	private Map<String, Object> session;
	private List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

	public String execute(){

		List<MCategoryDTO> mCategoryDTOList = new ArrayList<MCategoryDTO>();
		List<String> keywordsErrorMessageList = new ArrayList<String>();

		//セッションタイムアウト
		if(session == null || session.isEmpty()){
			return "timeOut";
		}

		String result = ERROR;
		//再度検索（エラーなし）した時にkeywordsErrorMessageListを削除するため
		session.remove("keywordsErrorMessageList");
        InputChecker inputChecker = new InputChecker();

        //空白文字のチェックしてくれる.isBlank()
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
          case 1 :
        	//keywords.split(" ")→検索でスペースを入れたときに分割する
            productInfoDTOList = productInfoDAO.getProductInfoListAll(keywords.split(" "));
            result = SUCCESS;
            break;

          default:
        	productInfoDTOList = productInfoDAO.getProductInfoListByKeywords(keywords.split(" "), categoryId);
        	result = SUCCESS;
        	break;
        }

        Iterator<ProductInfoDTO> iterator = productInfoDTOList.iterator();
        if(!(iterator.hasNext())){
        	productInfoDTOList = null;
        }

        if(!session.containsKey("mCategoryList")){
        	MCategoryDAO mCategoryDAO = new MCategoryDAO();
        	mCategoryDTOList = mCategoryDAO.getMCategoryList();
        	session.put("mCategoryDTOList", mCategoryDTOList);
        }

        return result;
	}

	public String getKeywords(){
		return keywords;
	}

	public void setKeywords(String keywords){
		this.keywords = keywords;
	}

	public int getCategoryId(){
		return categoryId;
	}

	public void setCategoryId(int categoryId){
		this.categoryId = categoryId;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String, Object> session){
		this.session = session;
	}

	public List<ProductInfoDTO> getProductInfoDTOList() {
		return productInfoDTOList;
	}

}
