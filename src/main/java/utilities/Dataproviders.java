package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import constants.FrameworkConstants;


public class Dataproviders {

	String path;
	
	@DataProvider (name="logindata")
	public String[][] getdata() throws IOException {
		path = FrameworkConstants.exel_path;

		ExcelUtility xl_utility = new ExcelUtility(path);

		int total_row = xl_utility.get_row_count("sheet1");
		System.out.println(total_row);
		int total_col = xl_utility.get_col_count("sheet1", 1);
		System.out.println(total_col);

		String[][] data = new String[total_row][total_col]; 

		for (int r = 1; r <= total_row; r++) {
			for (int c = 0; c < total_col; c++) {
				data[r - 1][c] = xl_utility.get_cell_data("sheet1", r, c);
			}
		}

		return data;
	}

}
