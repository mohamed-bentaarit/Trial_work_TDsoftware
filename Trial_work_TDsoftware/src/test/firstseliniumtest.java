package test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.By;  
import org.openqa.selenium.JavascriptExecutor;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;  

public class firstseliniumtest {

public static void main(String[] args) throws InterruptedException {
	
	String projectlocation = System.getProperty("user.dir");
	
	// System Property for Chrome Driver   
    System.setProperty("webdriver.chrome.driver", projectlocation+"\\lib\\chromedriver\\chromedriver.exe");  
      
    // Instantiate a ChromeDriver class.       
    WebDriver driver= new ChromeDriver();  
	
	//WebDriver driver = new RemoteWebDriver(DesiredCapabilities.chrome());
	driver.navigate().to("http://webdriveruniversity.com/Datepicker/index.html");
	
    //Maximize the browser  
    driver.manage().window().maximize();  
    
   //driver.findElement(By.id("datepicker")).click();
   //driver.findElement(By.className("input-group-addon")).click();
   // driver.findElement(By.xpath("//i[contains(@class, 'gly')]")).click();
    driver.findElement(By.xpath("//i")).click();
    
   //driver.findElement(By.className("next")).click();
   //delay(100);
   //driver.findElement(By.className("day")).click();
 
    driver.findElement(By.xpath("//div[contains(@class, 'days')]/table/thead/tr/th[contains(@class, 'next')]")).click();
    Thread.sleep(2000);
    driver.findElement(By.className("day")).click();
    //driver.quit();
    
    
    
}
}

