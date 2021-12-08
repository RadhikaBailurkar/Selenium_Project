/* Verify invalid email address error
 * 
 * 1. Invalid Email Address
 * Input: 348$%feni
 * Output: Test Fail
 * 
 * 2. Valid Email Address
 * Input: 397@sif.org
 * Output: Test Pass
 * 
 * 
 * Input
 */
package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class VerifyInvalidEmail {

	public static void main(String[] args) throws Throwable{
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "D:\\Quastech\\Software\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		//Click on Sign in button
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		/*Method 1 - Enter invalid email address
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("348$%feni");
		driver.findElement(By.id("SubmitCreate")).click();
		*/
		
		
		//Method 2
		WebElement element = driver.findElement(By.id("email_create"));
		element.sendKeys("348$%feni");
		String text = element.getAttribute("value");
		driver.findElement(By.id("SubmitCreate")).click();
		//System.out.println(text);
		
		if(text.contains("@") && text.contains(".")) {
			System.out.println("Test Pass, Valid email id");
		}
		else {
			System.out.println("Test Fail");
		}
		
		Thread.sleep(3000);
		driver.close();

	}

}
