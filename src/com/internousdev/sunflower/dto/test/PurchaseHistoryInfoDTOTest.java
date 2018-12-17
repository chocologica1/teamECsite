package com.internousdev.sunflower.dto.test;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.internousdev.sunflower.dto.PurchaseHistoryInfoDTO;

public class PurchaseHistoryInfoDTOTest {
	int max = 2147483647;
	int min = -2147483648;
	String exmax = "2147483648";
	String exmin = "-2147483649";

	@Test
	public void testGetProductName1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductName1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductName2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductName2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductName3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductName3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductName4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductName4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductName5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductName5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductName6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductName6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductName7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductName7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductName8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductName8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setProductName(expected);

		String actual = dto.getProductName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductNameKana1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductNameKana1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductNameKana2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductNameKana2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductNameKana3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductNameKana3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductNameKana4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductNameKana4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductNameKana5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductNameKana5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductNameKana6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductNameKana6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductNameKana7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductNameKana7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductNameKana8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductNameKana8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setProductNameKana(expected);

		String actual = dto.getProductNameKana();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFilePath1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFilePath1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFilePath2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFilePath2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFilePath3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFilePath3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFilePath4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFilePath4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFilePath5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFilePath5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFilePath6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFilePath6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFilePath7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFilePath7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFilePath8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFilePath8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setImageFilePath(expected);

		String actual = dto.getImageFilePath();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFileName1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFileName1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFileName2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFileName2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFileName3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFileName3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFileName4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFileName4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFileName5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFileName5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFileName6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFileName6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFileName7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFileName7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetImageFileName8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetImageFileName8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setImageFileName(expected);

		String actual = dto.getImageFileName();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetPrice1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = 0;
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetPrice1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = 0;
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetPrice2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = max;
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetPrice2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = max;
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetPrice3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = min;
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetPrice3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = min;
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetPrice4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmax);
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		}
	}

	@Test
	public void testSetPrice4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmax);
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		}
	}

	@Test
	public void testGetPrice5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmin);
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}

	@Test
	public void testSetPrice5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmin);
		dto.setPrice(expected);

		int actual = dto.getPrice();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}

	@Test
	public void testGetProductCount1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = 0;
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductCount1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = 0;
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductCount2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = max;
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductCount2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = max;
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductCount3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = min;
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetProductCount3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = min;
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetProductCount4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmax);
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		}
	}

	@Test
	public void testSetProductCount4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmax);
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		}
	}

	@Test
	public void testGetProductCount5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmin);
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}

	@Test
	public void testSetProductCount5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmin);
		dto.setProductCount(expected);

		int actual = dto.getProductCount();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}

	@Test
	public void testGetTotalPrice1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = 0;
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetTotalPrice1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = 0;
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetTotalPrice2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = max;
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetTotalPrice2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = max;
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetTotalPrice3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = min;
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetTotalPrice3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		int expected = min;
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetTotalPrice4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmax);
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		}
	}

	@Test
	public void testSetTotalPrice4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmax);
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		}
	}

	@Test
	public void testGetTotalPrice5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmin);
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}

	@Test
	public void testSetTotalPrice5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		try{
		int expected = Integer.parseInt(exmin);
		dto.setTotalPrice(expected);

		int actual = dto.getTotalPrice();
		assertEquals(expected , actual);
		}catch(RuntimeException e){
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}

	@Test
	public void testGetReleaseDate1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		Date expected = null;

		dto.setReleaseDate(expected);
		Date actual = dto.getReleaseDate();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetReleaseDate1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		Date expected = null;

		dto.setReleaseDate(expected);
		Date actual = dto.getReleaseDate();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetReleaseDate2() throws ParseException{
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setReleaseDate(expected);
		assertEquals(expected , dto.getReleaseDate());
	}

	@Test
	public void testSetReleaseDate2() throws ParseException{
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
		Date expected = sdf.parse("20180420 12:00:00");
		dto.setReleaseDate(expected);
		assertEquals(expected , dto.getReleaseDate());
	}

	@Test
	public void testGetReleaseCompany1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetReleaseCompany1() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = null;
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetReleaseCompany2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetReleaseCompany2() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetReleaseCompany3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetReleaseCompany3() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = " ";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetReleaseCompany4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetReleaseCompany4() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "　";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetReleaseCompany5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetReleaseCompany5() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetReleaseCompany6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetReleaseCompany6() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "あいう１２３";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetReleaseCompany7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetReleaseCompany7() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "abc123あいう１２３";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testGetReleaseCompany8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

	@Test
	public void testSetReleaseCompany8() {
		PurchaseHistoryInfoDTO dto = new PurchaseHistoryInfoDTO();
		String expected = "ａｂｃ１２３あいう漢字";
		dto.setReleaseCompany(expected);

		String actual = dto.getReleaseCompany();
		assertEquals(expected , actual);
	}

}
