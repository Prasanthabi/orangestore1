package ord.tc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class IplFrancies {

	public static void main(String[] args) throws IOException {
		File file =new File("C:\\Users\\agast\\eclipse-workspace\\MavenDayOne\\file\\MavenDayOne.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook book = new XSSFWorkbook(stream);
		Sheet sheet = book.getSheet("IPL");
		int ofRows = sheet.getPhysicalNumberOfRows();
		System.out.println(ofRows);
		Row row = sheet.getRow(3);
		int ofCells = row.getPhysicalNumberOfCells();
		System.out.println(ofCells);
		for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
			Cell cell = row.getCell(i);
			System.out.println(cell);
		}
	}

}
