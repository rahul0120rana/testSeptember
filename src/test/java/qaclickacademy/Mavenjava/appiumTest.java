package qaclickacademy.Mavenjava;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class appiumTest {

	@Test
	public void postjira() throws IOException {
		System.out.println("PostJira");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\rahul.rana\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		//Take screenshots
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C:\\users\\rahul.rana\\GeckoDriver\\screenshot.png"));
	}

	@Test
	public void delTwitter() {
		System.out.println("DelTwitter");
	}
	@Test
	public void tab() throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahul.rana\\Chromedriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> wins=driver.getWindowHandles();
		Iterator<String> newI=wins.iterator();
		 String parentW=newI.next();
		 String childW=newI.next();
		 driver.switchTo().window(childW);
		 driver.get("https://rahulshettyacademy.com/");
		 String nameText=driver.findElements(By.xpath("//div[@id='courses-block']//h2")).get(0).getText();
		 driver.switchTo().window(parentW);
		 driver.findElement(By.xpath("//input[@name='name']")).sendKeys(nameText);
		 //take screenshot of particular webElement only
		 WebElement nameField =driver.findElement(By.xpath("//input[@name='name']"));
		 File file =nameField.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(file,new File("logo.png"));
		 
	}
}
