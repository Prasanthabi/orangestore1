package ord.tc;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class hotelBooking {
			
		static WebDriver driver;
		static TakesScreenshot shot;
		static Select select;
					
		@BeforeClass
		public static void fc01() {
			driver = new ChromeDriver();
			driver.get("https://adactinhotelapp.com/");
			driver.manage().window().maximize();
		}
		
		@AfterClass
		public static void fc02() {
			//driver.close();
		}
		
		@After
		public void fc03() throws Exception {
			shot = (TakesScreenshot)driver;
			File s1 = shot.getScreenshotAs(OutputType.FILE);
			File d1 = new File("D:\\Abhi\\1AA-selinum\\orderbooking.png");
			FileUtils.copyFile(s1, d1);
			
			
		}
				
		@Before
		public void fc04() throws Exception  {
			shot = (TakesScreenshot)driver;
			File s2 = shot.getScreenshotAs(OutputType.FILE);
			File d2 = new File("D:\\Abhi\\1AA-selinum\\Befor.png");
			FileUtils.copyFile(s2, d2);
			
		}
		@Test
		public void fc05() throws Exception {
			
			driver.findElement(By.id("username")).sendKeys("Prasanth550");
			driver.findElement(By.id("password")).sendKeys("Prasanth@123");
			driver.findElement(By.id("login")).click();
			
			Thread.sleep(2000);
			
			
			WebElement Location = driver.findElement(By.id("location"));
			select = new Select(Location);
			select.selectByIndex(3);
			WebElement Hotels = driver.findElement(By.id("hotels"));
			select = new Select(Hotels);
			select.selectByIndex(2);
			WebElement room = driver.findElement(By.id("room_type"));
			select = new Select(room);
			select.selectByIndex(2);
			WebElement nos = driver.findElement(By.id("room_nos"));
			select = new Select(nos);
			select.selectByIndex(1);	
			WebElement adult = driver.findElement(By.id("adult_room"));
			select = new Select(adult);
			select.selectByIndex(2);			
			WebElement child = driver.findElement(By.id("child_room"));
			select = new Select(child);
			select.selectByIndex(0);
			driver.findElement(By.id("Submit")).click();
			
			
			Thread.sleep(2000);
			
			
			driver.findElement(By.id("radiobutton_0")).click();
			driver.findElement(By.id("continue")).click();
			
			
			Thread.sleep(2000);
			
			
			driver.findElement(By.id("first_name")).sendKeys("Prasanth");
			driver.findElement(By.id("last_name")).sendKeys("A");
			driver.findElement(By.id("address")).sendKeys("chennai,India");
			driver.findElement(By.id("cc_num")).sendKeys("6543211234567890");
			driver.findElement(By.id("cc_cvv")).sendKeys("7890");
			WebElement cCtype = driver.findElement(By.id("cc_type"));
			select = new Select(cCtype);
			select.selectByIndex(2);
			WebElement ccExpMonth = driver.findElement(By.id("cc_exp_month"));
			select = new Select(ccExpMonth);
			select.selectByIndex(2);
			WebElement ccExpYear = driver.findElement(By.id("cc_exp_year"));
			select = new Select(ccExpYear);
			select.selectByIndex(18);
			driver.findElement(By.id("book_now")).click();
			
			
			Thread.sleep(5000);
			
			
			driver.findElement(By.id("my_itinerary")).click();
			
			
			Thread.sleep(5000);
			
			
			WebElement element = driver.findElement(By.className("select_text"));
			String text = element.getAttribute("value");
			System.out.println(text);
					
		}


}
