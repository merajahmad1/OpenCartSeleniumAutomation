package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx"; //taking excel file from test data folder
		ExcelUtility xl = new ExcelUtility(path);  //creating an object of excel file

		int rowNum = xl.getRowCount("Sheet1");    //getting totaL no of rows
		int colCount = xl.getCellCount("Sheet1", 1);   //getting totaL no of columns

		String loginData[][] = new String[rowNum][colCount]; //creating two dimensional array that can store data

		for (int i = 1; i <= rowNum; i++) {
			for (int j = 0; j < colCount; j++) {
				loginData[i - 1][j] = xl.getCellData("Sheet1", i, j);
			}
		}
		return loginData;    //returning two dimensional array
	}

}
