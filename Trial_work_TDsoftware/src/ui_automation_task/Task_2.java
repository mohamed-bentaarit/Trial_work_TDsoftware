package ui_automation_task;

import java.util.List;
import org.openqa.selenium.By;   
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Task_2 {
public static void main(String[] args) throws InterruptedException {
	
	String projectlocation 	= System.getProperty("user.dir");
	String baseurl 			= "https://demo.applitools.com/index.html#";
	String expectedurl 		= "https://demo.applitools.com/app.html";
	String actualurl 		= "";
	//Define the user's login value
	String user 			= "user" ;
	//Define the user's pwd value
	String pwd 				= "password" ;  
	//xPath to desired status. possible values :  'Declined', 'Pending', 'Complete'
	String xpath_status 	= "//tr/td/span[text() = 'Pending']" ;
	//xPath of row matching status defined
	String xpath_row 		= xpath_status + "/ancestor::tr" ;
	//xPath of amount matching status defined
    String xpath_amount 	= xpath_row + "/td[contains (@class, 'right')]/span";	
    
	
    
    // System Property for Chrome Driver.   
    System.setProperty("webdriver.chrome.driver", projectlocation+"\\lib\\chromedriver\\chromedriver.exe");  
    // Instantiate a ChromeDriver class.       
    WebDriver driver	= new ChromeDriver();  
	//Open Chrome and go to baseurl.
    driver.get(baseurl);
    //Maximize the browser.  
    driver.manage().window().maximize();
    //Delay 2 seconds. 
    Thread.sleep(2000);
    
    
    //Define WebElements needed to login.
    WebElement username = driver.findElement(By.id("username"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement login = driver.findElement(By.id("log-in"));
    
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
    
    // Fill out List "Elements_amount" with elements that have the desired status
    List<WebElement> Elements_amount = driver.findElements(By.xpath(xpath_amount));
    
    //print out the number of elements
    System.out.println("Number of Elements:" +Elements_amount.size());
    
   //print out the amounts of elements.
    System.out.println("Amounts of Elements:");
    for(WebElement e : Elements_amount) {
    	System.out.println(e.getText());
   } 
   
    //Delay 2 seconds. 
    Thread.sleep(2000);
    
    //Close Browser.
    driver.quit();
}
}