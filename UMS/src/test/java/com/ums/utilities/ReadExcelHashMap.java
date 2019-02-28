package com.ums.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelHashMap {
	
	public static final String EXCELFILELOCATION = "./Data.xlsx";
	
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	private static XSSFRow row;
	
	public static void loadExcel() throws Exception
	{
		File file = new File(EXCELFILELOCATION);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("QA");

		fis.close();
	}
	
	public static Map<String, Map<String, String>> getDataMap() throws Exception
	{
		if(sheet==null)
		{
			loadExcel();
		}
		Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
		Map<String, String> myMap = new HashMap<String, String>();
		
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			row = sheet.getRow(i);
			String keyCell = "";
			if(row.getCell(0)!= null) {
				keyCell = row.getCell(0).toString();
				int colNum = row.getLastCellNum();
				for(int j=1;j<colNum;j++)
				{
					String value = null;
					if(CellType.STRING.equals(row.getCell(j).getCellTypeEnum())) {
								value = row.getCell(j).getStringCellValue();
						}else {
							value = row.getCell(j).getRawValue();
						}
		
					myMap.put(keyCell,value);
				}
				superMap.put("MASTERDATA", myMap);
			}
		}
		return superMap;
				
	}
		public static String getValue(String key) throws Exception
		{
			Map<String,String>myVal = getDataMap().get("MASTERDATA");
			String retValue = myVal.get(key);
			return retValue;
		}
		
		/*public static void main(String[] args) throws Exception {
			System.out.println(getValue("urlLink"));
			System.out.println(getValue("FrontEnd"));
		}*/
				
}
