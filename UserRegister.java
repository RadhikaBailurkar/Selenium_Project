/* Automate user registration process
 * 
 * Ref: https://www.guru99.com/select-option-dropdown-selenium-webdriver.html
 * Ref: https://www.techlistic.com/2020/06/automate-ecommerce-website.html#google_vignette
 * Aim: Create new account on e-comm website 
 * 
 * Date: 5th Dec'2021
 * 
 */

package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UserRegister {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.gecko.driver", "D:\\Quastech\\Software\\geckodriver-v0.30.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		//Click on Sign in button
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(2000);
		
		//Enter email address in create account section
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("test1997@test.com");
		
		//Click on create an account button
		driver.findElement(By.xpath("//body[@id='authentication']/div[@id='page']/div[@class='columns-container']/div[@id='columns']/div[@class='row']/div[@id='center_column']/div[@class='row']/div[@class='col-xs-12 col-sm-6']/form[@id='create-account_form']/div[@class='form_content clearfix']/div[@class='submit']/button[@id='SubmitCreate']/span[1]")).click();
		Thread.sleep(2000);
		
		/*-------------------------------Enter Personal Information --------------------------------*/
		//Select Radio button title
		driver.findElement(By.id("id_gender2")).click();
		//Enter Firstname
		driver.findElement(By.id("customer_firstname")).sendKeys("Doe");
		
		//Enter last name
		driver.findElement(By.id("customer_lastname")).sendKeys("Doe");
		//Enter password
		driver.findElement(By.id("passwd")).sendKeys("Test@123");
		//DOB
		Select date = new Select(driver.findElement(By.id("days")));
		date.selectByValue("20");
		Select month = new Select(driver.findElement(By.id("months")));
		month.selectByIndex(2);
		//month.selectByVisibleText("February");
		Select year = new Select(driver.findElement(By.id("years")));
		year.selectByValue("1997");
		//Tick Checkbox
		driver.findElement(By.id("optin")).click();
		
		
		/*--------------------------------------Your Address -----------------------------------------*/
		//Enter company name
		driver.findElement(By.id("company")).sendKeys("Technosoft");
		//Enter Address
		driver.findElement(By.id("address1")).sendKeys("Test 81/1,2nd cross");
		//Enter City
		driver.findElement(By.id("city")).sendKeys("XYZ");
		//Select State
		WebElement drop1=driver.findElement(By.name("id_state"));
		Select state =new Select(drop1);
		state.selectByValue("10");
		//Enter Zipcode
		driver.findElement(By.id("postcode")).sendKeys("51838");
		// Select Country
		WebElement drop2 = driver.findElement(By.name("id_country"));
		Select country = new Select(drop2);
		country.selectByVisibleText("United States");
		//Additional information
		driver.findElement(By.id("other")).sendKeys("test");
		//Enter Mobile Phone
		driver.findElement(By.id("phone_mobile")).sendKeys("987654321");
		//Assign an address alias
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
		driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
		//click on register
		driver.findElement(By.name("submitAccount")).click();
		
		
		
		//System.out.println("Print text(): " + e.getText() );
		
		Thread.sleep(3000);
		driver.close();

	}

}
