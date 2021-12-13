package project;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class SearchOrder {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\Quastech\\Software\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		//Click on Sign in button
		driver.findElement(By.xpath("//a[@class='login']")).click();
			
		//Implicit Wait -> https://www.browserstack.com/guide/wait-commands-in-selenium-webdriver
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
		/*------------------------------------Sign in ------------------------------------*/
		driver.findElement(By.id("email")).sendKeys("test1997@test.com");
		driver.findElement(By.id("passwd")).sendKeys("Test@123");
		driver.findElement(By.id("SubmitLogin")).click();
		
		//Use actions class to use mouse hover action
		Actions actions=new Actions(driver);
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebElement womenTab = driver.findElement(By.className("sf-with-ul"));
		WebElement TshirtTab=driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[1]/ul/li[1]/ul//a[@title='T-shirts']"));
		actions.moveToElement(womenTab).moveToElement(TshirtTab).click().perform();
		Thread.sleep(2000);
		
		//Get product name
		WebElement getString = driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"));
		String text = getString.getText();
		//System.out.println(text);  // printed to console
		
		//enter product name in search
		driver.findElement(By.id("search_query_top")).sendKeys(text);
		driver.findElement(By.name("submit_search")).click();
		Thread.sleep(2000);
		
		String searchResultName = driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
		//System.out.println(searchResultName);
		
		if(text.equalsIgnoreCase(searchResultName)) {
			   System.out.println("Test Case Passed");
			  }
		else{
			   System.out.println("Test Case Failed");
			  }
			  

	 driver.close();
	}

}
