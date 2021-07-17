package test;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;   
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 

public class thirdtest {
public static void main(String[] args) throws InterruptedException {
	

	String projectlocation = System.getProperty("user.dir");
	String baseurl = "https://www.saucedemo.com/";
	String expectedurl = "https://www.saucedemo.com/inventory.html";
	String actualurl = "";
	String user = "standard_user" ;
	String pwd = "secret_sauce" ;
	// System Property for Chrome Driver   
    System.setProperty("webdriver.chrome.driver", projectlocation+"\\lib\\chromedriver\\chromedriver.exe");  
      
    // Instantiate a ChromeDriver class.       
    WebDriver driver= new ChromeDriver();  
    
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//WebDriver driver = new RemoteWebDriver(DesiredCapabilities.chrome());
    driver.get(baseurl);
	
    //Maximize the browser  
    driver.manage().window().maximize();
    
 
    
    
    WebElement username = driver.findElement(By.id("user-name"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement login = driver.findElement(By.id("login-button"));
    username.sendKeys(user);
    password.sendKeys(pwd);
    login.click();
    
    actualurl = driver.getCurrentUrl();
        
    if (actualurl.contentEquals(expectedurl)){
    	System.out.println("Test Passed");
    }else {
    	System.out.println("Test Failed");
    }
    
    Thread.sleep(2000);
    
    List<WebElement> ListOfElements = driver.findElements(By.xpath("//button [contains (@id, 'add-to-cart')]"));
    
    System.out.println("Number of Elements:" +ListOfElements.size());
    
    Random r = new Random();
    int low = 2;
    int high = ListOfElements.size();
    int result = r.nextInt(high-low) + low;
    System.out.println(result);
    	for(int i=1;i<result ;i++){
    		driver.findElement(By.xpath("//button [contains (@id, 'add-to-cart')] ")).click();
			System.out.println(i);
			Thread.sleep(2000);
		}
    	
    	
  //tr/td[contains (@class, 'right')]/span
    	
    driver.findElement(By.id("shopping_cart_container")).click();
    Thread.sleep(2000);
    List<WebElement> ListOfElementsCart = driver.findElements(By.xpath("//button [contains (@id, 'remove')]"));
    
    System.out.println("Number of Elements in Cart:" +ListOfElementsCart.size());
    
	for(int i=1;i< result;i++){
		driver.findElement(By.xpath("//button [contains (@id, 'remove')] ")).click();
		System.out.println(i);
		Thread.sleep(2000);
	}
    
}
}
