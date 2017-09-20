package com.wind.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * excel文件操作工具类
 * @author followwwind
 *
 */
public class ExcelUtils {
	/**
	 * 读取excel表格中的数据
	 * @param path excel表格路径
	 * @param sheetnum excel表格第几个sheet
	 * @return
	 */
	public static List<List<String>> readExcel(String path, int sheetnum) {
		Workbook wb = null;
		List<List<String>> listsheet = new ArrayList<List<String>>();
		wb = getWorkbook(path);
		int sheets = wb.getNumberOfSheets();
		if(sheetnum <= sheets && sheetnum >=0){
			//获取sheet
			Sheet sheet = wb.getSheetAt(sheetnum);
			// 获得第一个表单的迭代器
			Iterator<Row> rows = sheet.rowIterator();
			//存储excel单个sheet
			while (rows.hasNext()) {
				// 获得行数据
				Row row = rows.next();
				// 获得第一行的迭代器
				Iterator<Cell> cells = row.cellIterator();
				//存储excel单行数据
				List<String> listcell = new ArrayList<String>();
				while (cells.hasNext()) {
					Cell cell = cells.next();
					String cellValue = "";
					switch (cell.getCellType()) { // 根据cell中的类型来输出数据
					case HSSFCell.CELL_TYPE_NUMERIC:
						DecimalFormat df = new DecimalFormat("#.#######");
						cellValue = df.format(cell.getNumericCellValue());
						// System.out.println(cell.getNumericCellValue());
						break;
					case HSSFCell.CELL_TYPE_STRING:
						cellValue = String.valueOf(cell.getStringCellValue());
						// System.out.println(cell.getStringCellValue());
						break;
					case HSSFCell.CELL_TYPE_BOOLEAN:
						cellValue = String.valueOf(cell.getBooleanCellValue());
						// System.out.println(cell.getBooleanCellValue());
						break;
					case HSSFCell.CELL_TYPE_FORMULA:
						cellValue = String.valueOf(cell.getCellFormula());
						// System.out.println(cell.getCellFormula());
						break;
					default:
						cellValue = String.valueOf("");
						// System.out.println("unsuported sell type");
						break;
					}
					listcell.add(cellValue);
				}
				listsheet.add(listcell);
			}
		}
		return listsheet;
	}
	
    /**
     * 
     * @param path 文件路径
     * @param sheetName sheet名称
     * @param head excel表头
     * @param bodydata excel表体数据
     */
	public static void writeExcel(String path, String sheetName, List<String> head, List<List<String>> bodydata){ 
		OutputStream out = null;
		Workbook wb = null;
		File file = new File(path);
        try {
        	if(file.exists()){
        		file.delete();
        	}
			out = new FileOutputStream(path);
			wb = new HSSFWorkbook(); 
			//wb = getWorkbook(path);
			//创建新的sheet（页），命名为sheetName
	        Sheet sheet = wb.createSheet(sheetName);
	        Row row = null;
	        Cell c = null;
	        if(head != null && head.size() > 0){
	        	row = sheet.createRow(0);
	        	for(int i = 0; i < head.size(); i++){
					c = row.createCell(i);
					c.setCellValue(head.get(i));
				}
	        }
	        int rownum = row != null? 1 : 0;
	        List<String> rowdata = new ArrayList<String>();
			for(int j = 0; j < bodydata.size(); j++){
				row = sheet.createRow(j + rownum);
				rowdata = bodydata.get(j);
				for(int col = 0; col < rowdata.size(); col++){
					c = row.createCell(col);
					c.setCellValue(rowdata.get(col));
				}
			}
			wb.write(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			IOUtils.close(out);
		}
	}
	
	/**
	 * 获取工作簿workbook
	 * @param type
	 * @param path
	 * @return
	 */
	public static Workbook getWorkbook(String path){
		Workbook wb = null;
		InputStream input = null;
		try {
			input = new FileInputStream(path);
			if(path.endsWith("xlsx")){
				// 初始化excel工作簿 (2007)
				wb = new XSSFWorkbook(input);
			}else{
				wb = new HSSFWorkbook(input); 
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			IOUtils.close(input);
		}
		return wb;
	}
}
