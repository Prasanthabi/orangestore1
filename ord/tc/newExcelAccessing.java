package ord.tc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class newExcelAccessing {

	public static void main(String[] args) throws IOException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();
		
		WebElement skills = driver.findElement(By.id("Skills"));
		Select select = new Select(skills);
		
		List<WebElement> options = select.getOptions();
		int size = options.size();
		System.out.println(size);
		
		for (int j = 0; j < size; j++) {
			String text1 = options.get(j).getText();
			System.out.println(text1);
			}
		
		File file = new File("C:\\Users\\agast\\eclipse-workspace\\MavenDayOne\\file\\Skills.xlsx");
		Workbook book = new XSSFWorkbook();
		
		Sheet sheet = book.createSheet("Skills");
				
		for (int i = 0; i < size; i++) {
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			String text = options.get(i).getText();
			cell.setCellValue(text);
		}
		
		FileOutputStream stream = new FileOutputStream(file);
		book.write(stream);
		}

}
