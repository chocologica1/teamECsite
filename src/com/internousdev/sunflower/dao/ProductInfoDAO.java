package com.internousdev.sunflower.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.sunflower.dto.ProductInfoDTO;
import com.internousdev.sunflower.util.DBConnector;

public class ProductInfoDAO {
	//キーワード検索(全てのカテゴリ)
	public List<ProductInfoDTO> getProductInfoListAll(String[] keywordsList) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

		String sql = "select * from product_info where";
		boolean initializeFlag = true;
		for(String keyword : keywordsList) {
			if (initializeFlag) {
				sql += "(product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag = false;
			} else {
				sql += "or (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTOList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDTOList;
	}

	//キーワード検索(カテゴリ指定)
	public List<ProductInfoDTO> getProductInfoListByKeywords(String[] keywordsList, int categoryId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

		String sql = "select * from product_info where";
		boolean initializeFlag = true;
		for(String keyword : keywordsList) {
			if (initializeFlag) {
				sql += " category_id=" + categoryId + " and ((product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
				initializeFlag = false;
			} else {
				sql += "or (product_name like '%" + keyword + "%' or product_name_kana like '%" + keyword + "%')";
			}
		}
		sql += ")";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTOList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDTOList;
	}

	//商品一覧取得
	public List<ProductInfoDTO> getProductInfoList() {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

		String sql = "select * from product_info";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTOList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDTOList;
	}

	//商品詳細取得
	public ProductInfoDTO getProductInfo(int productId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductInfoDTO productInfoDTO = new ProductInfoDTO();

		String sql = "select * from product_info where product_id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setProductNameKana(rs.getString("product_name_kana"));
				productInfoDTO.setProductDescription(rs.getString("product_description"));
				productInfoDTO.setCategoryId(rs.getInt("category_id"));
				productInfoDTO.setPrice(rs.getInt("price"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTO.setReleaseDate(rs.getDate("release_date"));
				productInfoDTO.setReleaseCompany(rs.getString("release_company"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDTO;
	}

	//関連商品
	public List<ProductInfoDTO> getProductInfoListByCategoryId(int categoryId, int productId, int limitOffset, int limitRowCount) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		List<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();

		String sql = "select * from product_info where category_id=? and product_id not in (?) order by rand() limit ?,?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ps.setInt(2, productId);
			ps.setInt(3, limitOffset);
			ps.setInt(4, limitRowCount);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				ProductInfoDTO productInfoDTO = new ProductInfoDTO();
				productInfoDTO.setProductId(rs.getInt("product_id"));
				productInfoDTO.setProductName(rs.getString("product_name"));
				productInfoDTO.setImageFilePath(rs.getString("image_file_path"));
				productInfoDTO.setImageFileName(rs.getString("image_file_name"));
				productInfoDTOList.add(productInfoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return productInfoDTOList;
	}
}
