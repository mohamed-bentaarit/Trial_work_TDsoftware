package test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;   
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait; 
public class secondtest {
public static void main(String[] args) throws InterruptedException {
	

	String projectlocation = System.getProperty("user.dir");
	String baseurl = "https://demo.applitools.com/index.html#";
	String expectedurl = "https://demo.applitools.com/app.html";
	String actualurl = "";
	String user = "user" ;
	String pwd = "password" ;
	// System Property for Chrome Driver   
    System.setProperty("webdriver.chrome.driver", projectlocation+"\\lib\\chromedriver\\chromedriver.exe");  
      
    // Instantiate a ChromeDriver class.       
    WebDriver driver= new ChromeDriver();  
    
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//WebDriver driver = new RemoteWebDriver(DesiredCapabilities.chrome());
    driver.get(baseurl);
	
    //Maximize the browser  
    driver.manage().window().maximize();
    
 
    
    
    WebElement username = driver.findElement(By.id("username"));
    WebElement password = driver.findElement(By.id("password"));
    WebElement login = driver.findElement(By.id("log-in"));
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
    
   // List<WebElement> ListOfElements = driver.findElements(By.xpath("//tr/td[contains (@class, 'nowrap')]/span[contains (@class, 'yellow')]"));

    List<WebElement> ListOfElements = driver.findElements(By.xpath("//tr/td/span[contains (@class, 'yellow')] "));
    
    System.out.println("Number of pending Elements:" +ListOfElements.size());
 // Initialize and wait till element(link) became clickable - timeout in 10 seconds
    //WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
       //     .until(ExpectedConditions.elementToBeClickable(By.className("logged-user-name")));
    // Print the first result
    //System.out.println(firstResult.getText());
    
    //System.out.println("Number of Elements:" +ListOfElements.size());
    
  //tr/td[contains (@class, 'right')]/span
    
}
}
