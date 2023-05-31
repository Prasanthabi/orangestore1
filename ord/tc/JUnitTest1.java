package ord.tc;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JUnitTest1 {
	
	static WebDriver driver;
	static TakesScreenshot shot;
		
	@BeforeClass
	public static void fc01() {
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public static void fc02() {
		driver.close();
	}
	
	@After
	public void fc03() throws IOException {
		shot = (TakesScreenshot)driver;
		File s1 = shot.getScreenshotAs(OutputType.FILE);
		File d1 = new File("D:\\Abhi\\1AA-selinum\\After.png");
		FileUtils.copyFile(s1, d1);
		
	}
	@Before
	public void fc04() throws IOException {
		shot = (TakesScreenshot)driver;
		File s2 = shot.getScreenshotAs(OutputType.FILE);
		File d2 = new File("D:\\Abhi\\1AA-selinum\\Befor.png");
		FileUtils.copyFile(s2, d2);
	}
	@Test
	public void fc05() {
		driver.findElement(By.id("email")).sendKeys("Prasanth");
		driver.findElement(By.id("pass")).sendKeys("Prasanth@123");
	}
}
