package com.java.visiologparser;
import java.io.File;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.IndexedColors;

public class excelGeneratorforStaticField
{

public void writeExcelFile(String fileName,Map staticFieldMap){

	FileOutputStream fileOutputStream = null;
	HSSFWorkbook sampleWorkbook = null;
	HSSFSheet sampleDataSheet = null;
	try{
		sampleWorkbook = new HSSFWorkbook();
		sampleDataSheet = sampleWorkbook.createSheet("SampleDataSheet1");
		/**
		* Create two rows using HSSFRow class, where headerRow denotes the
		* header and the dataRow1 denotes the cell data.
		*/
		HSSFRow headerRow = null;
		HSSFCell firstHeaderCell=null;
		HSSFRow headerRow2 = sampleDataSheet.createRow(1);
		HSSFRow headerRow3 = sampleDataSheet.createRow(2);
		HSSFRow headerRow4 = sampleDataSheet.createRow(3);
		HSSFRow headerRow5 = sampleDataSheet.createRow(4);
		HSSFRow headerRow6 = sampleDataSheet.createRow(5);
		HSSFRow headerRow7 = sampleDataSheet.createRow(6);
		HSSFRow headerRow8 = sampleDataSheet.createRow(7);
		HSSFRow headerRow9 = sampleDataSheet.createRow(8);
		HSSFRow headerRow10 = sampleDataSheet.createRow(9);
		HSSFRow headerRow11 = sampleDataSheet.createRow(10);
		HSSFRow headerRow12 = sampleDataSheet.createRow(11);
		HSSFRow headerRow13 = sampleDataSheet.createRow(12);
		HSSFRow headerRow14 = sampleDataSheet.createRow(13);
		
		
		 
		
		HSSFCellStyle cellStyle = setHeaderStyle(sampleWorkbook);
		/**
		* Call the setHeaderStyle method and set the styles for the
		* all the three header cells.
		*/
		for(int counter=0;counter<14;counter++){
			headerRow= sampleDataSheet.createRow(counter);
			firstHeaderCell = headerRow.createCell(0);
			firstHeaderCell.setCellStyle(cellStyle);
			firstHeaderCell.setCellValue(new HSSFRichTextString("Service Name"));
			headerRow.createCell(1).setCellValue((String)staticFieldMap.get("Service Name"));
		}
		
		/*firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Service Name"));
		
		headerRow1.createCell(1).setCellValue((String)staticFieldMap.get("Service Name"));
		
		firstHeaderCell = headerRow2.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Node Name"));
		headerRow2.createCell(1).setCellValue((String)staticFieldMap.get("Node Name"));
		
		
		firstHeaderCell = headerRow3.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Session Start Time"));
		headerRow3.createCell(1).setCellValue("Software Engineer3");
		
		firstHeaderCell = headerRow4.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Repository Name"));
		headerRow4.createCell(1).setCellValue((String)staticFieldMap.get("Repository Name"));
		
		firstHeaderCell = headerRow5.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Folder Name"));
		headerRow5.createCell(1).setCellValue((String)staticFieldMap.get("Folder Name"));
		
		firstHeaderCell = headerRow6.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Integration Bit Size"));
		headerRow6.createCell(1).setCellValue((String)staticFieldMap.get("Folder Name"));
		
		firstHeaderCell = headerRow7.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Server Mode"));
		headerRow7.createCell(1).setCellValue((String)staticFieldMap.get("Server Mode"));
		
		firstHeaderCell = headerRow8.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Server Code Page"));
		headerRow8.createCell(1).setCellValue("Software Engineer8");
		
		firstHeaderCell = headerRow9.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Sort Order"));
		headerRow9.createCell(1).setCellValue("Software Engineer9");
		
		firstHeaderCell = headerRow10.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Precision"));
		headerRow10.createCell(1).setCellValue("Software Engineer10");
		
		firstHeaderCell = headerRow11.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Commit Type"));
		headerRow11.createCell(1).setCellValue("Software Engineer11");
		
		firstHeaderCell = headerRow12.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("Commit InterVal"));
		headerRow12.createCell(1).setCellValue("Software Engineer12");
		
		firstHeaderCell = headerRow13.createCell(0);
		firstHeaderCell.setCellStyle(cellStyle);
		firstHeaderCell.setCellValue(new HSSFRichTextString("DTM Error Log"));
		headerRow13.createCell(1).setCellValue("Software Engineer13");*/
		
		/*dataRow1.createCell(0).setCellValue(new HSSFRichTextString("Node Name"));
		dataRow2.createCell(0).setCellValue(new HSSFRichTextString("Session Start Time"));
		dataRow3.createCell(0).setCellValue(new HSSFRichTextString("Repository Name"));
		dataRow4.createCell(0).setCellValue(new HSSFRichTextString("Folder Name"));
		dataRow5.createCell(0).setCellValue(new HSSFRichTextString("Integration Bit Size"));
		dataRow6.createCell(0).setCellValue(new HSSFRichTextString("Server Mode"));
		dataRow7.createCell(0).setCellValue(new HSSFRichTextString("Server Code Page"));
		dataRow8.createCell(0).setCellValue(new HSSFRichTextString("Sort Order"));
		dataRow9.createCell(0).setCellValue(new HSSFRichTextString("Precision"));*/
	/*	HSSFCell secondHeaderCell = headerRow.createCell(1);
		secondHeaderCell.setCellStyle(cellStyle);
		secondHeaderCell.setCellValue(new HSSFRichTextString("Designation"));
		HSSFCell thirdHeaderCell = headerRow.createCell(2);
		thirdHeaderCell.setCellStyle(cellStyle);
		thirdHeaderCell.setCellValue(new HSSFRichTextString("Country"));*/
		/**
		* Set the cell value for all the data rows.
		*/
		/*dataRow1.createCell(0).setCellValue(new HSSFRichTextString("Gift Sam"));
		dataRow1.createCell(1).setCellValue("Software Engineer");
		dataRow1.createCell(2).setCellValue("Malaysia");*/
		fileOutputStream = new FileOutputStream(fileName);
		sampleWorkbook.write(fileOutputStream);
	}
	catch (Exception ex){
		ex.printStackTrace();
	}
	finally	{
		try {
			if (fileOutputStream != null){
				fileOutputStream.close();
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
	}
}

private HSSFCellStyle setHeaderStyle(HSSFWorkbook sampleWorkBook){
	HSSFFont font = sampleWorkBook.createFont();
	font.setFontName(HSSFFont.FONT_ARIAL);
	font.setColor(IndexedColors.PLUM.getIndex());
	font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
	HSSFCellStyle cellStyle = sampleWorkBook.createCellStyle();
	cellStyle.setFont(font);
	return cellStyle;
}
public static void main(String[] args)
{
new excelGeneratorforStaticField().writeExcelFile("D:\\sampleexcel.xls",null);
}
}
