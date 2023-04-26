package testpack;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class screenshot {
	
	@Test
	public void test() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		Reporter.log("Chrome Browser got launched");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("Navigated to login page of the application");
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys("jhansi4868@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Jhansi@04");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Reporter.log("Enter the valid credentails and clicked on login button");

		Assert.assertTrue(driver.findElement(By.xpath("//a[.='Edit your account information']")).isDisplayed());
		
		File src1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("screenshots//screenshot1.png"));
		
		Reporter.log("<a target=\"_blank\" href=\"\\home\\navadhiti\\eclipse-workspace1\\TestNG\\screenshots\\screenshot1.png\">Screenshot</a>");
		Reporter.log("<img src=\"\\home\\navadhiti\\eclipse-workspace1\\TestNG\\screenshots\\screenshot1.png\"/>");

         driver.close();
				
		
	}

}
