/*Verify error messages for entering incorrect values in fields.
 * 
 */
package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.regex.*;

public class VerifyIncorrectValues {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "D:\\Quastech\\Software\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		//Click on Sign in button
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		//NoSuchElementException -> https://stackoverflow.com/questions/46202283/exception-in-thread-main-org-openqa-selenium-nosuchelementexception-unable-to
		//driver.findElement(By.id("email_create")).sendKeys("hey@test.com");
		
		//Alternate solution
		WebDriverWait wait = new WebDriverWait (driver, 15);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("email_create")));
		element.sendKeys("hey@test.com");
		
		driver.findElement(By.id("SubmitCreate")).click();
		Thread.sleep(2000);
		
		/*-------------------------Enter info in form----------------------------------------*/
		
		WebElement item1 = driver.findElement(By.id("customer_firstname"));				//enter firstname
		item1.sendKeys("865#$4");
		String fname = item1.getAttribute("value");
		
		//https://www.techiedelight.com/check-string-contains-only-alphabets-java/
		if(fname!= null && fname.matches("^[a-zA-Z]*$")){
			System.out.println("test pass");											//print ans to console
		}
		else {
			System.out.println("test fail, firstname should contain alphabets");
		}
		
		WebElement item3 = driver.findElement(By.id("passwd"));						//enter password
		item3.sendKeys("aaa");
		String pass = item3.getAttribute("value");
		
		if(pass.length()>3) {
			System.out.println("test pass, valid password");
		}
		else {
			System.out.println("test fail");
		}
		
		WebElement item2 = driver.findElement(By.id("phone_mobile"));				//enter mobile no.
		item2.sendKeys("fdn#$yyu");
		String mobile = item2.getAttribute("value");
		
		String regex = "\\d{10}"; 													//Regular expression to accept valid phone number
	    boolean result = mobile.matches(regex);										//Matching the given phone number with regular expression
	    if(result) {
	    	System.out.println("test pass, valid phone no:");
	    }
	    else {
	    	System.out.println("test fail, enter valid ph no.");
	    }
	    	
		driver.findElement(By.name("submitAccount")).click();							//click on register
		

	

	}

}
