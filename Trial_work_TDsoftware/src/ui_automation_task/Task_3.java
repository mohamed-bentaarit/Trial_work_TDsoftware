package ui_automation_task;

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

public class Task_3 {
public static void main(String[] args) throws InterruptedException {
	
	int min_items			= 2 ;
    int max_items			= 0 ;
	int random_items		= 0 ;

	String projectlocation 	= System.getProperty("user.dir");
	String baseurl 			= "https://www.saucedemo.com/";
	String expectedurl 		= "https://www.saucedemo.com/inventory.html";
	String actualurl		= "";
	//Define the user's login value
	String user 			= "standard_user" ;
	//Define the user's pwd value
	String pwd 				= "secret_sauce" ;
	// Define WebElements IDs.
	String id_user 			= "user-name";
	String id_pwd  			= "password";
	String id_login			= "login-button";
	String id_cart_icon		= "shopping_cart_container";
	// Define WebElements xPath.
	String xpth_add_to_cart	= "//button [contains (@id, 'add-to-cart')]";
	String xpth_rmv_fm_cart	= "//button [contains (@id, 'remove')] ";
	
	
	// System Property for Chrome Driver   
    System.setProperty("webdriver.chrome.driver", projectlocation+"\\lib\\chromedriver\\chromedriver.exe");  
    // Instantiate a ChromeDriver class.       
    WebDriver driver= new ChromeDriver();  
    //Open Chrome and go to baseurl.
    driver.get(baseurl);
	//Maximize the browser  
    driver.manage().window().maximize();
    
    //Define WebElements needed to login.
    WebElement username = driver.findElement(By.id(id_user));
    WebElement password = driver.findElement(By.id(id_pwd));
    WebElement login = driver.findElement(By.id(id_login));
    
    //Typing Credentials and signing-in.
    username.sendKeys(user);
    password.sendKeys(pwd);
    login.click();
    
    //Compare currentUrl to expectedUrl defined earlier.
    actualurl = driver.getCurrentUrl();
    if (actualurl.contentEquals(expectedurl)){
    	System.out.println("Test Passed : currentUrl is same as expectedUrl");
    }else {
    	System.out.println("Test Failed : currentUrl is same as expectedUrl");
    }
    
    //Delay 2 seconds.
    Thread.sleep(2000);
    
    // Fill out List "items_add_to_cart" with elements that can be added to Cart.
    List<WebElement> items_add_to_cart = driver.findElements(By.xpath(xpth_add_to_cart));
    
    System.out.println("Number of items that can be added to Cart:" +items_add_to_cart.size());
    
    //Get random number of items to add to cart
    Random r = new Random();
    max_items = items_add_to_cart.size();
    random_items = r.nextInt(max_items-min_items) + min_items;
    	
    //Add items to cart
    for(int i=1;i<random_items ;i++){
    		driver.findElement(By.xpath(xpth_add_to_cart)).click();
			Thread.sleep(2000);
		}
    	
    //Open shopping cart container.
    driver.findElement(By.id(id_cart_icon)).click();
    Thread.sleep(2000);
    
    //Fill out List "items_in_cart" with elements in Cart.
    List<WebElement> items_in_cart = driver.findElements(By.xpath(xpth_rmv_fm_cart));
    
    System.out.println("Number of items in Cart:" +items_in_cart.size());
    
    //Delay 2 seconds.
    Thread.sleep(2000);
    
	for(int i=1;i< random_items;i++){
		driver.findElement(By.xpath(xpth_rmv_fm_cart)).click();
		Thread.sleep(2000);
	}
   
	items_in_cart = driver.findElements(By.xpath(xpth_rmv_fm_cart));
	
	//Test Cart is Empty or Not.
	if ( items_in_cart.size() == 0){
    	System.out.println("Test Passed : Test Cart is Empty");
     
    }else{
    	System.out.println("Test Failed : Test Cart is Empty");
    }
	
    //Close Browser.
    driver.quit();
	
}
}
