/*Verify error messages for mandatory fields
 * 
 * Leave Mandatory fields as blank
 */
package project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class VerifyMandatory {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "D:\\Quastech\\Software\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		//Click on Sign in button
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		//Enter email id
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("hey@test.com");
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(2000);
		

		//Select Radio button title
		driver.findElement(By.id("id_gender1")).click();
		
		//DOB
		Select date = new Select(driver.findElement(By.id("days")));
		date.selectByValue("20");
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByIndex(2);
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("1997");
		//Tick Checkbox
		driver.findElement(By.id("optin")).click();
		
		//click on register
		driver.findElement(By.name("submitAccount")).click();
		
		//error while submitting blank mandatory values
		
		

	}

}
