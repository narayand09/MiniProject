package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xfile, String xlsSheet)
	{
		int rowcount = 0;
		try {
			fi=new FileInputStream(xfile);
			wb=new XSSFWorkbook(fi);
			ws=wb.getSheet(xlsSheet);
			rowcount=ws.getLastRowNum();
			wb.close();
			fi.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowcount;
		
		
	}
	
	public static int getCellCount(String xfile, String xlsSheet, int rownum) throws IOException
	{
		fi=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsSheet);
		row=ws.getRow(rownum);
		int cellcount=row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}
	
	public static String getCellData(String xfile, String xlsSheet, int rownum, int colnum) throws IOException
	{
		fi=new FileInputStream(xfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsSheet);
		row=ws.getRow(rownum);
		cell=row.getCell(colnum);
		String data;
		try {
			DataFormatter formatter=new DataFormatter();
			String celldata=formatter.formatCellValue(cell);
			return celldata;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			data="";
		}
		
		wb.close();
		fi.close();
		return data;
		
	}
	
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		fo=new FileOutputStream(xlfile);
		wb.write(fo);		
		wb.close();
		fi.close();
		fo.close();
	}
	
	

}
