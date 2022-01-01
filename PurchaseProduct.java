package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PurchaseProduct {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Quastech\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		driver.findElement(By.id("email")).sendKeys("test1997@test.com");
		driver.findElement(By.id("passwd")).sendKeys("Test@123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		Actions actions=new Actions(driver);
		driver.findElement(By.linkText("WOMEN")).click();

		//Select the image first-> then click on More button, use action class
		 WebElement Image = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[1]/div[1]/a[1]/img[1]"));
		 WebElement MoreBtn = driver.findElement(By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
		 actions.moveToElement(Image).moveToElement(MoreBtn).click().perform();
		 
		 //to scroll down the webpage
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)", "");
		 
		 //change quantity -> 2
		 driver.findElement(By.id("quantity_wanted")).clear();
		 driver.findElement(By.id("quantity_wanted")).sendKeys("2");
		 
		 //change size -> L
		 WebElement size = driver.findElement(By.id("group_1"));
		 Select sel = new Select(size);
		 sel.selectByVisibleText("L");
		 
		 //select color
		 driver.findElement(By.id("color_8")).click();
		 
		 //add to cart
		 driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		 
		 //click on proceed
		 driver.findElement(By.xpath("//body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[4]/div[1]/div[2]/div[4]/a[1]/span[1]")).click();
		 driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[2]/a[1]/span[1]")).click();
		 driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();
		 driver.findElement(By.xpath("//input[@id='cgv']")).click();
		 driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();
		 
		 //PayBy Check
		 driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[2]/div[1]/p[1]/a[1]")).click();
		 //Confirm order
		 driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();
		 
		//Get Text
		  String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
		  
		  // Verify that Product is ordered
		  if(ConfirmationText.contains("complete")) {
		   System.out.println("Order Completed: Test Case Passed");
		  }
		  else {
		   System.out.println("Order Not Successfull: Test Case Failed");
		  }
		  
		  
		  js.executeScript("window.scrollBy(0,250)", "");
	}

}
