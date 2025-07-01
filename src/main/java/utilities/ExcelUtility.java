package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	String path;
	FileInputStream fi;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell cell;
	DataFormatter dataformater;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int get_row_count(String sheetname) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		int total_row = workbook.getSheet(sheetname).getLastRowNum();
		workbook.close();
		fi.close();
		return total_row;
	}

	public int get_col_count(String sheetname, int row_index) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		int total_col = workbook.getSheet(sheetname).getRow(row_index).getLastCellNum();
		workbook.close();
		fi.close();
		return total_col;
	}

	public String get_cell_data(String sheetname, int row_index, int col_index) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		cell = workbook.getSheet(sheetname).getRow(row_index).getCell(col_index);
		dataformater = new DataFormatter();
		String data;
		try {
			data = dataformater.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		workbook.close();
		fi.close();
		return data;
	}

}
